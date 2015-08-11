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
public class OpportunityDetailsPage extends DetailsContainer{
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath ="//h2[@class='pageDescription']")
    @CacheLookup
    private WebElement opportunityTitle;
    @FindBy(xpath = "//td[contains(.,'Opportunity Name')]/following::div")
    @CacheLookup
    private WebElement opportunityNameValue;

    @FindBy(xpath = "//td[contains(.,'Close Date')]/following::div")
    @CacheLookup
    private WebElement closeDateValue;

    @FindBy(xpath = "//td[contains(.,'Stage')]/following::div")
    @CacheLookup
    private WebElement stageValue;

    @FindBy(xpath = "//td[contains(.,'Account Name')]/following::div")
    @CacheLookup
    private WebElement accountValue;

    public OpportunityDetailsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
    public String getOpportunityTitle(){
        wait.until(ExpectedConditions.visibilityOf(opportunityTitle));
        return opportunityTitle.getText();
    }

    public String getOpportunityNameValue(){
        wait.until(ExpectedConditions.visibilityOf(opportunityNameValue));
        return opportunityNameValue.getText();
    }

    public String getCloseDateValue() {
        wait.until(ExpectedConditions.visibilityOf(closeDateValue));
        return closeDateValue.getText();
    }

    public String getStageValue() {
        wait.until(ExpectedConditions.visibilityOf(stageValue));
        return stageValue.getText();
    }

    public String getAccountValue() {
        wait.until(ExpectedConditions.visibilityOf(accountValue));
        return accountValue.getText();

    }

    public OpportunityHomePage clickDeleteOpportunityBtn(){
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
        clickDeleteBtn(driver,wait);
        return new OpportunityHomePage(driver);
    }
}
