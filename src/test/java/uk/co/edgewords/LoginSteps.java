package uk.co.edgewords;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class LoginSteps {

    private WebDriver driver;
    private final SharedDictionary sharedDict;

    public LoginSteps(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
        this.driver = (WebDriver)sharedDict.readDict("driver");
    }

    @When("I use the username {string} and password {string}")
    public void i_use_the_username_and_password(String username, String password) throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.linkText("Submit")).click();
    }
    @Then("I am logged in")
    public void i_am_logged_in() throws InterruptedException {
        Thread.sleep(2000);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat("Not logged in", bodyText, containsStringIgnoringCase("User is logged in"));
        //assertThat("We are not logged in",driver.findElement(By.linkText("Log Out")).isDisplayed(), is(true));


    }

    @When("I use the valid login credentials")
    public void i_use_the_valid_login_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        List<Map<String,String>> logins = dataTable.asMaps(String.class,String.class);

        for (var login:logins) {
            driver.findElement(By.id("username")).sendKeys(login.get("username"));
            driver.findElement(By.id("password")).sendKeys(login.get("password"));
            Thread.sleep(1000);
        }
        driver.findElement(By.linkText("Submit")).click();
    }


}
