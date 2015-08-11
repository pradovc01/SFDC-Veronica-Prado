package Pages;

import org.openqa.selenium.By;
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
public class AccountsHomePage extends HomePageContainer {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountsHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

   public CreateAccount clickNewAccountBtn(){
        wait.until(ExpectedConditions.visibilityOf(newBtn));
        clickNewBtn();
        return new CreateAccount(this.driver);
    }
     public AccountDetailPage selectAccount(String accountName){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(accountName))));
        driver.findElement(By.linkText(accountName)).click();
        return new AccountDetailPage(driver);
    }

}
