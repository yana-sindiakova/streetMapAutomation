package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static stepDefinitions.DefinitionSteps.DEFAULT_TIMEOUT;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@id='sidebar']//a[contains(@class, 'btn-sm')]")
    private WebElement directionButton;

    @FindBy(xpath = "//div[@id='sidebar']//input[@id='route_from']")
    private WebElement routeFromInputField;

    @FindBy(xpath = "//div[@id='sidebar']//input[@id='route_to']")
    private WebElement routeToInputField;

    @FindBy(xpath = "//div[@id='sidebar']//select[@name='routing_engines']")
    private WebElement transportDropdown;

    @FindBy(xpath = "//div[@id='sidebar']//select[@name='routing_engines']/option")
    private List<WebElement> transportDropdownOptions;

    @FindBy(xpath = "//div[@id='sidebar']//input[contains(@class, 'routing_go')]")
    private WebElement goButton;

    @FindBy(xpath = "//div[@id='sidebar_content']//p[contains(text(), 'Distance')]")
    private WebElement distanceElement;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public MainPage clickOnDirectionButton() {
        clickElement(directionButton);
        return this;
    }

    public MainPage inputLocationToRouteFromInputField(String fromLocation) {
        routeFromInputField.sendKeys(fromLocation);
        return this;
    }

    public MainPage inputLocationToRouteToInputField(String toLocation) {
        routeToInputField.sendKeys(toLocation);
        return this;
    }

    public MainPage openTransportDropdown() {
        clickElement(transportDropdown);
        return this;
    }

    public MainPage selectOptionInTransportDropdown(String transportType) {
        clickElement(transportDropdownOptions.stream()
                .filter(e -> e.getText().equals(transportType))
                .findFirst()
                .get());
        return this;
    }

    public MainPage clickOnGoButton() {
        clickElement(goButton);
        return this;
    }

    public String getDistanceText() {
        waitVisibilityOfElement(DEFAULT_TIMEOUT, distanceElement);
        return distanceElement.getText();
    }

}
