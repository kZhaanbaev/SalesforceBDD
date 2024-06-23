package stepDefs;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomeSteps {
    private TestContext testContext;

    public HomeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Verify URL is ending with {string}")
    public void verify_url_is_ending_with(String url) {
        Assert.assertTrue(testContext.getDriver().getCurrentUrl().endsWith(url));
    }

    @Then("Verify {string} navigation button is visible")
    public void verifyNavigationButtonIsVisible(String button) {
        switch (button.toLowerCase()) {
            case "accounts":
                Assert.assertTrue(testContext.getHomePage().accountsNavBtn.isDisplayed());
                break;
            case "contacts":
                Assert.assertTrue(testContext.getHomePage().contactsNavBtn.isDisplayed());
                break;
            case "cases":
                Assert.assertTrue(testContext.getHomePage().casesNavBtn.isDisplayed());
                break;
            default:
                Assert.fail(button + " navigation button was not found");
        }
    }



}
