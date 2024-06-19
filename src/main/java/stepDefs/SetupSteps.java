package stepDefs;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SetupPage;
import utils.BrowserUtils;
import utils.Driver;

public class SetupSteps {
    private SetupPage setupPage;

    public SetupSteps() {
        setupPage = new SetupPage(Driver.getDriver());
    }

    @Then("Verify Home button is enabled")
    public void verify_home_button_is_enabled() {
        Assert.assertTrue(setupPage.homeNavBtn.isEnabled());
    }

    @Then("Verify Object Manager button is enabled")
    public void verify_object_manager_button_is_enabled() {
        Assert.assertTrue(setupPage.objManagerBtn.isEnabled());
    }

    @Then("Verify title of the page is Home | Salesforce")
    public void verify_title_of_the_page_is_home_salesforce() {
        new BrowserUtils(Driver.getDriver()).sleep(2000);
        Assert.assertEquals("Home | Salesforce", Driver.getDriver().getTitle());
    }
}
