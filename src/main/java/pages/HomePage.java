package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Accounts']")
    public WebElement accountsNavBtn;

    @FindBy(xpath = "//a[@title='Contacts']")
    public WebElement contactsNavBtn;

    @FindBy(xpath = "//a[@title='Cases']")
    public WebElement casesNavBtn;

}
