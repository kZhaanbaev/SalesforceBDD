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
}
