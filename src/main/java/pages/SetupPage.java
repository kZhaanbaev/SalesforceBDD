package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetupPage {

    public SetupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[starts-with(@class, 'title') and text()='Home']")
    public WebElement homeNavBtn;

    @FindBy(xpath = "//span[starts-with(@class, 'title') and text()='Object Manager']")
    public WebElement objManagerBtn;

    @FindBy(xpath = "//a[@title='Create Menu']")
    public WebElement createBtn;

    @FindBy(id = "userCreateMenuItem")
    public WebElement createUserBtn;

    @FindBy(id = "multipleUserCreateMenuItem")
    public WebElement createMultipleUserBtn;

    @FindBy(id = "createMenuItem")
    public WebElement createCustomObjBtn;

    @FindBy(id = "createCustomTabURL")
    public WebElement createCustomTabBtn;

    @FindBy(id = "userCreateMenuItem")
    public WebElement createEmailTemplateBtn;

    @FindBy(id = "createFlowURL")
    public WebElement createFlowBtn;

    @FindBy(xpath = "//tr//a[text()='Marketing']")
    public WebElement recentlyUse_Marketing;

    @FindBy(xpath = "//tr//a[text()='Community']")
    public WebElement recentlyUse_Community;

    @FindBy(xpath = "//tr//a[text()='Account Layout']")
    public WebElement recentlyUse_AccountLayout;

    @FindBy(xpath = "//button[@title='App Launcher']")
    public WebElement appLauncherBtn;

    @FindBy(xpath = "//a[@data-label='Service']//p")
    public WebElement serviceLaunchBtn;

    @FindBy(xpath = "//a[@data-label='Community']")
    public WebElement communityLaunchBtn;

    @FindBy(xpath = "//a[@data-label='Content']")
    public WebElement contentLaunchBtn;

    @FindBy(xpath = "//button[text()='View All']")
    public WebElement viewAllLaunchBtn;

    @FindBy(xpath = "//button[text()='Visit AppExchange']")
    public WebElement appExchangeBtn;

}
