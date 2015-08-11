package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Veronica Prado on 8/11/2015.
 */
public abstract class DetailsContainer {
    @FindBy(xpath = "//input[@title='Delete']")
    @CacheLookup
    protected WebElement deleteBtn;
    public void clickDeleteBtn(WebDriver driver, WebDriverWait wait){
        deleteBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }
}
