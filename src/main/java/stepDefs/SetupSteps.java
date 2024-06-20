package stepDefs;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.BrowserUtils;

public class SetupSteps {
    private TestContext testContext;

    public SetupSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Verify {string} button is enabled")
    public void verifyButtonIsEnabled(String button) {
        switch (button.toLowerCase()) {
            case "home":
                Assert.assertTrue(testContext.getSetupPage().homeNavBtn.isEnabled());
                break;
            case "object manager":
                Assert.assertTrue(testContext.getSetupPage().objManagerBtn.isEnabled());
                break;
            default:
                Assert.fail();
        }
    }

    @Then("Verify title of the page is Home | Salesforce")
    public void verify_title_of_the_page_is_home_salesforce() {
        new BrowserUtils(testContext.getDriver()).sleep(2000);
        Assert.assertEquals("Home | Salesforce", testContext.getDriver().getTitle());
    }

    @When("I click Create button")
    public void i_click_create_button() {
        testContext.getSetupPage().createBtn.click();
    }

    @Then("Verify {string} option is visible")
    public void verifyOptionIsVisible(String option) {
        switch (option.toLowerCase()) {
            case "user":
                Assert.assertTrue(testContext.getSetupPage().createUserBtn.isDisplayed());
                break;
            case "multiple users":
                Assert.assertTrue(testContext.getSetupPage().createMultipleUserBtn.isDisplayed());
                break;
            case "custom objects":
                Assert.assertTrue(testContext.getSetupPage().createCustomObjBtn.isDisplayed());
                break;
            case "email template":
                Assert.assertTrue(testContext.getSetupPage().createEmailTemplateBtn.isDisplayed());
                break;
            case "custom tab":
                Assert.assertTrue(testContext.getSetupPage().createCustomTabBtn.isDisplayed());
                break;
            case "flow":
                Assert.assertTrue(testContext.getSetupPage().createFlowBtn.isDisplayed());
                break;
        }
    }
}
