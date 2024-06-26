package stepDefs;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountSteps {
    private TestContext testContext;

    public AccountSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("I click {string} item from recently view window")
    public void iClickItemFromRecentlyViewWindow(String item) {
        switch (item.toLowerCase()){
            case "first": testContext.getAccountPage().items_recentlyViewed.get(0).click();
                break;
            default:
                Assert.fail("Item was not found");
        }
    }

    @Then("Verify following headers are populated:")
    public void verifyFollowingHeadersArePopulated(List<String> items) {
        for (String each: items){
            switch (each.toLowerCase()){
                case "type":
                    Assert.assertFalse(testContext.getAccountPage().headerType_text.getText().isEmpty());
                break;
                case "phone":
                    Assert.assertFalse(testContext.getAccountPage().headerPhone_text.getText().isEmpty());
                    break;
                case "website":
                    Assert.assertFalse(testContext.getAccountPage().headerWebsite_text.getText().isEmpty());
                    break;
                case "account owner":
                    Assert.assertFalse(testContext.getAccountPage().headerAccountOwner_text.getText().isEmpty());
                    break;
                case "industry":
                    Assert.assertFalse(testContext.getAccountPage().headerIndustry_text.getText().isEmpty());
                    break;
                default: Assert.fail("Header was not found");
            }
        }
    }

    @When("I create a new Account with following fields populated:")
    public void i_create_a_new_account_with_following_fields_populated(Map<String, String> map) {
        testContext.getAccountPage().createNewAccount(
                map.get("accountName"),
                map.get("accountNumber"),
                map.get("type")
        );
    }

    @Then("Verify Account header is {string}")
    public void verifyAccountHeaderIs(String accountName) {
        Assert.assertEquals(accountName, testContext.getAccountPage().accountHeaderText.getText());
    }
}
