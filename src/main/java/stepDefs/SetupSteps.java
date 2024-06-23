package stepDefs;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

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

    @Then("Verify following buttons are enabled")
    public void verify_following_buttons_are_enabled(List<String> buttons) {
        for(String each: buttons){
            switch (each.toLowerCase()) {
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
    }

    @Then("Verify title of the page is Home | Salesforce")
    public void verify_title_of_the_page_is_home_salesforce() {
        testContext.getBrowserUtils().sleep(2000);
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
            case "appexchange":
                Assert.assertTrue(testContext.getSetupPage().appExchangeBtn.isDisplayed());
                break;
        }
    }

    @Then("Verify following options are visible")
    public void verifyFollowingOptionsAreVisible(List<String> list) {
        for(String each: list){
            switch (each.toLowerCase()) {
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
                case "appexchange":
                    Assert.assertTrue(testContext.getSetupPage().appExchangeBtn.isDisplayed());
                    break;
            }
        }
    }

    @Then("I verify {string} option is visible under Most Recently Used section")
    public void iVerifyOptionIsVisibleUnderMostRecentlyUsedSection(String option) {
        switch (option.toLowerCase()) {
            case "marketing":
                Assert.assertTrue(testContext.getSetupPage().recentlyUse_Marketing.isDisplayed());
                break;
            case "community":
                Assert.assertTrue(testContext.getSetupPage().recentlyUse_Community.isDisplayed());
                break;
            case "account layout":
                Assert.assertTrue(testContext.getSetupPage().recentlyUse_AccountLayout.isDisplayed());
                break;
        }
    }

    @Then("Verify following options are visible under Most Recently Used section:")
    public void verify_following_options_are_visible_under_most_recently_used_section(List<String> list) {
        for (String each: list){
            switch (each.toLowerCase()) {
                case "marketing":
                    Assert.assertTrue(testContext.getSetupPage().recentlyUse_Marketing.isDisplayed());
                    break;
                case "community":
                    Assert.assertTrue(testContext.getSetupPage().recentlyUse_Community.isDisplayed());
                    break;
                case "account layout":
                    Assert.assertTrue(testContext.getSetupPage().recentlyUse_AccountLayout.isDisplayed());
                    break;
            }
        }
    }

    @When("I click {string} button")
    public void iClickButton(String button) {
        switch (button.toLowerCase()) {
            case "app launcher":
                testContext.getSetupPage().appLauncherBtn.click();
                break;
            case "view all":
                testContext.getBrowserUtils().waitForElementToBeVisible(testContext.getSetupPage().viewAllLaunchBtn);
                testContext.getSetupPage().viewAllLaunchBtn.click();
                break;
            case "service":
                testContext.getSetupPage().serviceLaunchBtn.click();
                testContext.getBrowserUtils().waitForURLToContainText("page/home");
                break;
            case "accounts":
                testContext.getHomePage().accountsNavBtn.click();
                break;
        }
    }

    @Then("I should see option {string}")
    public void iShouldSeeOption(String option) {
        switch (option.toLowerCase()) {
            case "service":
                Assert.assertTrue(testContext.getSetupPage().serviceLaunchBtn.isDisplayed());
                break;
            case "community":
                Assert.assertTrue(testContext.getSetupPage().communityLaunchBtn.isDisplayed());
                break;
            case "content":
                Assert.assertTrue(testContext.getSetupPage().contentLaunchBtn.isDisplayed());
                break;
        }
    }


}
