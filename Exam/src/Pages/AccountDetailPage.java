package Pages;

import org.openqa.selenium.Alert;
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
public class AccountDetailPage extends DetailsContainer{
    private WebDriver driver;
    private WebDriverWait wait;


    public AccountDetailPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
    public AccountsHomePage clickDeleteAccountBtn(){
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        clickDeleteBtn(driver, wait);
        return new AccountsHomePage(driver);
    }
}
