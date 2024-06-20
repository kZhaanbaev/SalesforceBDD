package core;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SetupPage;

public class TestContext {
    private WebDriver driver;
    private LoginPage loginPage;
    private SetupPage setupPage;

    public TestContext() {
        driver = new Driver().initializeDriver("chrome");
        loginPage = new LoginPage(driver);
        setupPage = new SetupPage(driver);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public LoginPage getLoginPage() {
        return this.loginPage;
    }

    public SetupPage getSetupPage() {
        return this.setupPage;
    }

}
