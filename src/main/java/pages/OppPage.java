package pages;

import core.TestContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;

public class OppPage {
    WebDriver driver;

    private TestContext testContext;

    public OppPage(TestContext testContext){
        this.testContext = testContext;
        this.driver = testContext.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@aria-label='Favorite this item']/following-sibling::div/button")
    public WebElement favListBtn;

    @FindBy(xpath = "//a[contains(@href, 'AllOpportunities') and @role]")
    public WebElement allOpportunitiesOption;

    @FindBy(xpath = "//li[contains(@data-target-selection-name, 'Opportunity.New')]/a")
    public WebElement createNewOppBtn;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    public WebElement saveBtn;

    @FindBy(xpath = "//label[text()='Opportunity Name']/following-sibling::div/input")
    public WebElement newOppName_inputField;

    @FindBy(xpath = "//label[text()='Close Date']/following-sibling::div/input")
    public WebElement newCloseDate_inputField;

    @FindBy(xpath = "//label[text()='Stage']/following::button")
    public WebElement selectStageBtn;

    @FindBy(xpath = "//span[@title='Prospecting']")
    public WebElement selectTypeOption_Prospecting;

    @FindBy(xpath = "//label[text()='Account Name']/following-sibling::div//input")
    public WebElement accountNameSearchField;

    @FindBy(xpath = "//div[contains(@class, 'active')]//a[text()='Details']")
    public WebElement detailsViewPage;

    @FindBy(xpath = "(//div[@class='slds-grid']/a[contains(@href, 'Account')])[2]//slot//slot")
    public WebElement accountNameField_detailsView;

    @FindBy(xpath = "//li[@data-name='Qualification']")
    public WebElement qualificationOppStage;

    @FindBy(xpath = "//ul[@class = 'slds-path__nav']//li")
    public List<WebElement> listOfStages;

    @FindBy(xpath = "//div[@data-aura-class = 'runtime_sales_pathassistantPathAssistantHeader']/button")
    public WebElement markAsCurrentStageBTn;

    @FindBy(xpath = "//lightning-icon/parent::button[contains(@class, 'mark-complete stepAction current uiButton')]")
    public WebElement markAsCompleteBtn;

    @FindBy(xpath = "//div[contains(@class, 'pathassistantPathAssistantHeader')]/button")
    public WebElement selectClosedStageBtn;

    @FindBy(xpath = "//div[@class = 'slds-card__footer']/parent::a")
    public WebElement viewAllStageHistoryBTn;

    @FindBy(xpath = "//select[@class = 'stepAction required-field select']")
    public WebElement selectClosedStageStatus;

    @FindBy(xpath = "//button[@title = 'Save']")
    public WebElement saveClosedStageStatusBtn;

    @FindBy(xpath = "//div[@data-aura-class ='forceListViewManagerGrid']//table[@aria-label = 'Stage History']//tbody//th[1]")
    public List<WebElement> stageHistoryRows;



    public void createNewOpp(String oppName, String closeDate, String accountName, String stage) {
        createNewOppBtn.click();
        newOppName_inputField.sendKeys(oppName);
        newCloseDate_inputField.sendKeys(closeDate);
        selectStageBtn.click();

        switch (stage.toLowerCase()) {
            case "prospecting":
                selectTypeOption_Prospecting.click();
                break;
            default:
                Assert.fail("Type was not found");
        }

        accountNameSearchField.sendKeys(accountName);
        driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='" + accountName + "']")).click();

        saveBtn.click();
    }

    public List<String> getStageHistory() {
        List<String> stages = new ArrayList<>();
        for (WebElement row : stageHistoryRows) {
            stages.add(row.getText());
        }
        return stages;
    }

    public void moveStageToClosed() {

        for (WebElement stageElement : listOfStages) {
            if (stageElement.getText().equalsIgnoreCase("Negotiation/Review")) {
                testContext.getBrowserUtils().Waits.waitForElementToBeVisible(markAsCompleteBtn);
                testContext.getBrowserUtils().clickWithJs(markAsCompleteBtn);
                testContext.getBrowserUtils().Waits.waitForPageToLoad();
                testContext.getBrowserUtils().Waits.waitForElementToBeVisible(selectClosedStageStatus);
                Select select = new Select(selectClosedStageStatus);
                select.selectByVisibleText("Closed Won");
                saveClosedStageStatusBtn.click();
                break;
            } else {
                testContext.getBrowserUtils().Waits.waitForElementToBeVisible(markAsCompleteBtn);
                testContext.getBrowserUtils().clickWithJs(markAsCompleteBtn);
            }

        }
    }
}
