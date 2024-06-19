package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage(Driver.getDriver());
    }

    @Given("I login to salesforce app")
    public void i_login_to_salesforce_app() {
        Driver.getDriver().get(ConfigReader.readProperty("config.properties", "url"));
        loginPage.loginAsAdmin();
    }

    @Then("Verify title of the page should contain Home")
    public void verifyTitleOfThePageShouldContainHome() {
        new BrowserUtils(Driver.getDriver()).waitForTitleToContain("Home");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Home"));
    }
}
