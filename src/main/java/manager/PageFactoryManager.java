package manager;

import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class PageFactoryManager {
    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getMaiPage() {
        return new MainPage(driver);
    }


}
