package stepDefs;

import core.TestContext;
import io.cucumber.java.en.And;
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
        testContext.getBrowserUtils().sleep(6000);
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
                map.get("opportunityTitle"),
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

    @And("I click the Edit button of {string} field")
    public void iClickTheEditButtonOfField(String item) {
        switch (item.toLowerCase()){
            case "order number": testContext.getOppPage().oppOrderNumberEditBtn.click();
                break;
            default:
                Assert.fail("Item was not found");
        }
    }

    @And("I set the value of {string} field as {string}")
    public void iSetTheValueOfFieldAs(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()){
            case "order number":
                testContext.getOppPage().oppOrderNumberInputField.sendKeys(fieldValue);
                testContext.getOppPage().oppSaveEditBtn.click();
                break;
            default: Assert.fail(fieldValue + "'s value didn't match " + fieldValue);
        }
    }

    @Then("Verify {string} field as {string} value")
    public void verifyFieldAsValue(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()){
            case "order number":
                Assert.assertEquals(fieldValue, testContext.getOppPage().oppOrderNumberOutputField.getText());
                break;
            default: Assert.fail(fieldValue + "'s value didn't match " + fieldValue);
        }
    }
}
