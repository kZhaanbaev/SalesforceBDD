package stepDefs;

import core.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps {
    private TestContext testContext;

    public LoginSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @Given("I login to salesforce app")
    public void i_login_to_salesforce_app() {
        testContext.getLoginPage().loginAsAdmin();
    }

    @Then("Verify title of the page should contain Home")
    public void verifyTitleOfThePageShouldContainHome() {
        testContext.getBrowserUtils().Waits.waitForTitleToContain("Home");
        Assert.assertTrue(testContext.getDriver().getTitle().contains("Home"));
    }
}
