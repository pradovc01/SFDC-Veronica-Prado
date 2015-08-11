package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Veronica Prado on 8/10/2015.
 */
public class CreateAccount extends CreateContainer {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//label[text()='Account Name']/following::input")
    @CacheLookup
    private WebElement accountNameTxt;

    public CreateAccount(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public CreateAccount setAccountNameTxt(String accountName){
        wait.until(ExpectedConditions.visibilityOf( accountNameTxt));
        accountNameTxt.clear();
        accountNameTxt.sendKeys(accountName);
        return this;
    }

    public AccountDetailPage clickSaveAccountBtn(){
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        clickSaveBtn();
        return new AccountDetailPage(driver);
    }

}
