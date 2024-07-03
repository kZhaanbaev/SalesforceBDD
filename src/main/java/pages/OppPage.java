package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OppPage {
    WebDriver driver;

    public OppPage(WebDriver driver){
        this.driver = driver;
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

    public void createNewOpp(String oppName, String closeDate, String accountName, String stage){
        createNewOppBtn.click();
        newOppName_inputField.sendKeys(oppName);
        newCloseDate_inputField.sendKeys(closeDate);
        selectStageBtn.click();

        switch (stage.toLowerCase()){
            case "prospecting": selectTypeOption_Prospecting.click();
                break;
            default:
                Assert.fail("Type was not found");
        }

        accountNameSearchField.sendKeys(accountName);
        driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='" + accountName + "']")).click();

        saveBtn.click();
    }
    @FindBy(xpath = "//button[@title='Edit Order Number']")
    public WebElement oppOrderNumberEditBtn;
    @FindBy(xpath = "//input[@name='OrderNumber__c']")
    public WebElement oppOrderNumberInputField;
    @FindBy(xpath = "//records-record-layout-item[@field-label='Order Number']//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']")
    public WebElement oppOrderNumberOutputField;
    @FindBy(xpath = "//button[@name='SaveEdit']")
    public WebElement oppSaveEditBtn;

}
