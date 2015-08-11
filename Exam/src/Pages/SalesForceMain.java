package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Veronica Prado on 8/10/2015.
 */
public class SalesForceMain {
    private WebDriver driver;
    private WebDriverWait wait;
    public SalesForceMain(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }
    public TopBar goToTopBar(){
        return new TopBar(driver);
    }

    public SalesMenu gotoSalesMenu(){
        return new SalesMenu(driver);
    }

}
