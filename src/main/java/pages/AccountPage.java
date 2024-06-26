package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//th//a[@title]")
    public List<WebElement> items_recentlyViewed;

    @FindBy(xpath = "(//p[@title='Phone']/following-sibling::p)[1]")
    public WebElement headerPhone_text;

    @FindBy(xpath = "(//p[@title='Website']/following-sibling::p)[1]")
    public WebElement headerWebsite_text;

    @FindBy(xpath = "(//p[@title='Industry']/following-sibling::p)[1]")
    public WebElement headerIndustry_text;

    @FindBy(xpath = "(//p[@title='Type']/following-sibling::p)[1]")
    public WebElement headerType_text;

    @FindBy(xpath = "(//p[@title='Account Owner']/following-sibling::p)[1]")
    public WebElement headerAccountOwner_text;

    @FindBy(xpath = "//li[contains(@data-target-selection-name, 'Account.New')]")
    public WebElement createNewAccountBtn;

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement newAccountName;

    @FindBy(xpath = "//input[@name='AccountNumber']")
    public WebElement newAccountNumber;

    @FindBy(xpath = "//label[text()='Type']/following::button")
    public WebElement selectTypeField;

    @FindBy(xpath = "//span[@title='Prospect']")
    public WebElement selectTypeOption_Prospect;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    public WebElement saveBtn;

    @FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
    public WebElement accountHeaderText;

    public void createNewAccount(String accountName, String accountNumber, String type){
        createNewAccountBtn.click();
        newAccountName.sendKeys(accountName);
        newAccountNumber.sendKeys(accountNumber);
        selectTypeField.click();

        switch (type.toLowerCase()){
            case "prospect": selectTypeOption_Prospect.click();
            break;
            default:
                Assert.fail("Type was not found");
        }

        saveBtn.click();
    }
}
