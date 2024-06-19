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
}
