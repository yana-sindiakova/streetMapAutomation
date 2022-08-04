package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    public static final long DEFAULT_TIMEOUT = 30;

    private WebDriver driver;
    private PageFactoryManager pageFactoryManager;
    private MainPage mainPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens {string} page")
    public void userOpensPage(String url) {
        mainPage = pageFactoryManager.getMaiPage();
        mainPage.openHomePage(url);
    }

    @Given("User opens Distance tab")
    public void userOpensDistanceTab() {
        mainPage.clickOnDirectionButton();
    }

    @When("User types {string} route from location")
    public void userTypesRouteFromLocation(String fromLocation) {
        mainPage.inputLocationToRouteFromInputField(fromLocation);
    }

    @When("User types {string} route to location")
    public void userTypesRouteToLocation(String toLocation) {
        mainPage.inputLocationToRouteToInputField(toLocation);
    }

    @When("User select {string} transport type")
    public void userSelectTransportType(String transportType) {
        mainPage.openTransportDropdown()
                .selectOptionInTransportDropdown(transportType);
    }

    @When("User click on the Go button")
    public void userClickOnTheGoButton() {
        mainPage.clickOnGoButton();
    }

    @Then("User check {string} distance between cities")
    public void userCheckDistanceBetweenCities(String distance) {
        assertTrue(distance + " calculation is not correct",
                mainPage.getDistanceText().contains(distance));
    }
}
