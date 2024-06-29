package stepDefs;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class OppSteps {
    private TestContext testContext;

    public OppSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @When("I navigate to {string} page from favourites list")
    public void i_navigate_to_page_from_favourites_list(String listItem) {
        switch (listItem.toLowerCase()){
            case "all opportunities":
                testContext.getOppPage().favListBtn.click();
                testContext.getOppPage().allOpportunitiesOption.click();
                break;
            default:
                Assert.fail(listItem + " item was not found");
        }
    }

    @When("I create a new Opp with following fields populated:")
    public void i_create_a_new_opp_with_following_fields_populated(Map<String, String> map) {
        testContext.getOppPage().createNewOpp(
                map.get("Opportunity Name"),
                map.get("Close Date"),
                map.get("Account Name"),
                map.get("Stage")
        );
    }

    @When("I open details view")
    public void i_open_details_view() {
        testContext.getOppPage().detailsViewPage.click();
    }

    @Then("Verify {string} field has value {string}")
    public void verify_field_has_value(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()){
            case "account name":
                Assert.assertEquals(fieldValue, testContext.getOppPage().accountNameField_detailsView.getText());
                break;
            default: Assert.fail(fieldValue + "'s value didn't match " + fieldValue);
        }
    }
}
