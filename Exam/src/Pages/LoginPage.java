package Pages;
import framework.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by Veronica Prado on 8/10/2015.
 */
public class LoginPage {
    //private String urlLogin = "https://login.salesforce.com/";
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id ="username")
    @CacheLookup
    private WebElement usernameTxt;

    @FindBy(id="password")
    @CacheLookup
    private WebElement pwdTxt;

    @FindBy(id="Login")
    @CacheLookup
    private WebElement loginBtn;
    public LoginPage(){
        /*driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);
        driver.get(urlLogin);*/
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(usernameTxt));
        wait.until(ExpectedConditions.visibilityOf(pwdTxt));
    }

    /*Set user Name
    * @param userName
    * @return LoginPage
    * */
    public LoginPage setUsernameTxt(String userName){
        usernameTxt.clear();
        usernameTxt.sendKeys(userName);
        return  this;
    }

    /*Set password for user Name
    * @param pwd
    * @return LoginPage
    * */
    public LoginPage setPwdTxt(String pwd){
        pwdTxt.clear();
        pwdTxt.sendKeys(pwd);
        return this;
    }
    /*click on Login Button
    * @return LoginPage
    * */
    public SalesForceMain clickLoginBtn(){
        loginBtn.click();
        return new SalesForceMain(driver);
    }

    /*Login as primary user
    * @return SalesForceMain
    * */
    public SalesForceMain loginAsPrimaryUSer(){
        String userName = "pradovc01@gmailtest.com";
        String password = "Control123";
        setUsernameTxt(userName);
        setPwdTxt(password);
        return clickLoginBtn();
    }
}
