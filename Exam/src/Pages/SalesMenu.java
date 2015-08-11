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
public class SalesMenu {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(linkText = "Leads")
    @CacheLookup
    private WebElement leadTab;

    @FindBy(linkText = "Accounts")
    @CacheLookup
    private WebElement accountsTab;

    @FindBy(linkText = "Opportunities")
    @CacheLookup
    private WebElement opportunitiesTab;

    public SalesMenu(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public AccountsHomePage clickAccountsTab(){
        wait.until(ExpectedConditions.visibilityOf(accountsTab));
        accountsTab.click();
        return new AccountsHomePage(driver);
    }

    public OpportunityHomePage clickOpportunityTab(){
        wait.until(ExpectedConditions.visibilityOf(opportunitiesTab));
        opportunitiesTab.click();
        return new OpportunityHomePage(driver);
    }


}
