package core;

import org.openqa.selenium.WebDriver;
import pages.*;
import utils.BrowserUtils;

public class TestContext {
    private WebDriver driver;
    private BrowserUtils browserUtils;
    private LoginPage loginPage;
    private SetupPage setupPage;
    private HomePage homePage;
    private AccountPage accountPage;
    private OppPage oppPage;

    public TestContext() {
        driver = new Driver().initializeDriver("chrome");
        browserUtils = new BrowserUtils(driver);
        loginPage = new LoginPage(driver);
        setupPage = new SetupPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        oppPage = new OppPage(this);
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

    public HomePage getHomePage() {
        return this.homePage;
    }

    public AccountPage getAccountPage() {
        return this.accountPage;
    }

    public OppPage getOppPage() {
        return this.oppPage;
    }

}
