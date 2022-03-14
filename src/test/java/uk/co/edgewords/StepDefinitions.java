package uk.co.edgewords;

import io.cucumber.java.en.Given;

import org.openqa.selenium.WebDriver;

public class StepDefinitions {

    private final WebDriver driver;
    private final SharedDictionary sharedDict;

    public StepDefinitions(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
        this.driver = (WebDriver)sharedDict.readDict("driver");
    }

    @Given("^(?i)I am on the(?-i) login page$")
    //@Given("the login page is loaded")
    public void IAmOnTheLoginPageBlah() {
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/sdocs/auth.php");

    }
}
