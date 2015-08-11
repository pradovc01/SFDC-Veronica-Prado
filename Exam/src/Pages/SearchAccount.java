package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Veronica Prado on 8/10/2015.
 */
public class SearchAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    private String windowsID;
    @FindBy(id="lksrch")
    @CacheLookup
    private WebElement searchAccountTxt;

    @FindBy(name="go")
    @CacheLookup
    private WebElement goBtn;

    private By searchFrame = By.id("searchFrame");
    private By resultFrame = By.id("resultsFrame");

    public SearchAccount(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        windowsID = driver.getWindowHandle();
        PageFactory.initElements(driver, this);
        try {


            Set<String> windows = driver.getWindowHandles();
            windows = driver.getWindowHandles();
            LinkedList<String> windowsList = new LinkedList(windows);
            driver.switchTo().window(windowsList.getLast());
            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(searchFrame));
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public void searchAccount(String accountName) {
        try {
            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(searchFrame));
            searchAccountTxt.clear();
            searchAccountTxt.sendKeys(accountName);
            goBtn.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        try {
            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(resultFrame));

            driver.findElement(By.linkText(accountName)).click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        }
        driver.switchTo().window(windowsID);
    }

}
