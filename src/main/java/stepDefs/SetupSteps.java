package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SetupPage;
import utils.BrowserUtils;
import utils.Driver;

public class SetupSteps {
    private SetupPage setupPage;

    public SetupSteps() {
        setupPage = new SetupPage(Driver.getDriver());
    }

    @Then("Verify {string} button is enabled")
    public void verifyButtonIsEnabled(String button) {
        switch (button.toLowerCase()) {
            case "home":
                Assert.assertTrue(setupPage.homeNavBtn.isEnabled());
                break;
            case "object manager":
                Assert.assertTrue(setupPage.objManagerBtn.isEnabled());
                break;
            default:
                Assert.fail();
        }
    }

    @Then("Verify title of the page is Home | Salesforce")
    public void verify_title_of_the_page_is_home_salesforce() {
        new BrowserUtils(Driver.getDriver()).sleep(2000);
        Assert.assertEquals("Home | Salesforce", Driver.getDriver().getTitle());
    }

    @When("I click Create button")
    public void i_click_create_button() {
        setupPage.createBtn.click();
    }

    @Then("Verify {string} option is visible")
    public void verifyOptionIsVisible(String option) {
        switch (option.toLowerCase()) {
            case "user":
                Assert.assertTrue(setupPage.createUserBtn.isDisplayed());
                break;
            case "multiple users":
                Assert.assertTrue(setupPage.createMultipleUserBtn.isDisplayed());
                break;
            case "custom objects":
                Assert.assertTrue(setupPage.createCustomObjBtn.isDisplayed());
                break;
            case "email template":
                Assert.assertTrue(setupPage.createEmailTemplateBtn.isDisplayed());
                break;
            case "custom tab":
                Assert.assertTrue(setupPage.createCustomTabBtn.isDisplayed());
                break;
            case "flow":
                Assert.assertTrue(setupPage.createFlowBtn.isDisplayed());
                break;
        }
    }
}
