package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Veronica Prado on 8/10/2015.
 */
public class WebDriverManager {
    private WebDriver driver;
    private WebDriverWait wait;
    private static WebDriverManager instance;
    private final String baseUrl = "https://login.salesforce.com/";
    private static final int TIMEOUT_NORMAL = 15;
    private String browser = "Firefox";
    private WebDriverManager(){
        initializeWebDriver();
    }

    private void initializeWebDriver(){
        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT_NORMAL);
        driver.get(baseUrl);
    }

    public static WebDriverManager getInstance(){
        if(instance == null)
            instance = new WebDriverManager();
        return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWait(){
        return wait;
    }
}
