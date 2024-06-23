package stepDefs;

import core.TestContext;
import io.cucumber.java.en.And;

public class AccountSteps {
    private TestContext testContext;

    public AccountSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("I click {string} item from recently view window")
    public void iClickItemFromRecentlyViewWindow(String item) {
        System.out.println("");
    }
}
