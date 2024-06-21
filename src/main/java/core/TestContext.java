package core;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SetupPage;
import utils.BrowserUtils;

public class TestContext {
    private WebDriver driver;
    private BrowserUtils browserUtils;
    private LoginPage loginPage;
    private SetupPage setupPage;

    public TestContext() {
        driver = new Driver().initializeDriver("chrome");
        browserUtils = new BrowserUtils(driver);
        loginPage = new LoginPage(driver);
        setupPage = new SetupPage(driver);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public BrowserUtils getBrowserUtils() {
        return this.browserUtils;
    }

    public LoginPage getLoginPage() {
        return this.loginPage;
    }

    public SetupPage getSetupPage() {
        return this.setupPage;
    }

}
