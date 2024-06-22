package stepDefs;

import core.TestContext;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomeSteps {
    private TestContext testContext;

    public HomeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Verify URL is ending with {string}")
    public void verify_url_is_ending_with(String url) {
        testContext.getBrowserUtils().waitForURLToContainText(url);
        Assert.assertTrue(testContext.getDriver().getCurrentUrl().endsWith(url));
    }
}
