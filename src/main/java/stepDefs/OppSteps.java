package stepDefs;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class OppSteps {
    private TestContext testContext;

    public OppSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I navigate to {string} page from favourites list")
    public void i_navigate_to_page_from_favourites_list(String listItem) {
        switch (listItem.toLowerCase()) {
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
        String opportunityName = map.get("Opportunity Name").replace("{current_time}", testContext.getBrowserUtils().getLogTime());
        testContext.getOppPage().createNewOpp(
                opportunityName,
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
        switch (fieldName.toLowerCase()) {
            case "account name":
                Assert.assertEquals(fieldValue, testContext.getOppPage().accountNameField_detailsView.getText());
                break;
            default:
                Assert.fail(fieldValue + "'s value didn't match " + fieldValue);
        }
    }

    @And("I move stage of an Opp to {string}")
    public void iMoveStageOfAnOppTo(String element) {
        switch (element) {
            case "Qualification":
                testContext.getBrowserUtils().Waits.waitForPageToLoad();
                testContext.getBrowserUtils().Waits.waitForElementToBeClickable(testContext.getOppPage().qualificationOppStage);
                testContext.getBrowserUtils().clickWithJs(testContext.getOppPage().qualificationOppStage);
                testContext.getBrowserUtils().clickWithJs(testContext.getOppPage().markAsCurrentStageBTn);
                break;
            case "Closed":
              for(WebElement stages: testContext.getOppPage().listOfStages){
                  testContext.getOppPage().markStageAsCompleteBtn.click();
              }
               break;
            default:
                Assert.fail();
        }
    }
    @Then("I should see the following stages displayed under Stage History section:")
    public void iShouldSeeTheFollowingStagesDisplayedUnderStageHistorySection(List<String> expectedStages) {

        testContext.getBrowserUtils().Waits.waitForElementToBeVisibleWhileScrolling
                (testContext.getOppPage().viewAllStageHistoryBTn, 3);
        testContext.getOppPage().viewAllStageHistoryBTn.click();

        List<String> actualStages = testContext.getOppPage().getStageHistory();

        for(String stages: expectedStages){
           Assert.assertTrue(actualStages.containsAll(expectedStages));
        }

    }
}
