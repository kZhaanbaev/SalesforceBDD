package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
