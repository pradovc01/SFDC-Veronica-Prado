package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Veronica Prado on 8/10/2015.
 */
public class CreateOpportunity extends CreateContainer {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//label[text()='Opportunity Name']/following::input")
    @CacheLookup
    private WebElement opportunityNameTxt;

    @FindBy(xpath = "//label[text()='Close Date']/following::input")
    @CacheLookup
    private WebElement closeDateTxt;

    @FindBy(xpath = "//label[text()='Stage']/following::select")
    @CacheLookup
    private WebElement stageSelectBox;

    @FindBy(xpath = "//img[@alt='Account Name Lookup (New Window)']")
    @CacheLookup
    private WebElement searchAccountImg;

    public CreateOpportunity(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public CreateOpportunity setOpportunityNameTxt(String opportunityName){
        wait.until(ExpectedConditions.visibilityOf(opportunityNameTxt));
        opportunityNameTxt.clear();
        opportunityNameTxt.sendKeys(opportunityName);
        return this;
    }

    public CreateOpportunity setCloseDateTxt(String closeDate){
        wait.until(ExpectedConditions.visibilityOf(closeDateTxt));
        closeDateTxt.clear();
        closeDateTxt.sendKeys(closeDate);
        return this;
    }
    public CreateOpportunity setStateSelectBox(String stageName){
        wait.until(ExpectedConditions.visibilityOf(stageSelectBox));
        Select selectBoxFirstName = new Select( stageSelectBox);
        selectBoxFirstName.selectByVisibleText(stageName);
        return this;
    }

    public SearchAccount clickSearchAccountImg(){
        wait.until(ExpectedConditions.visibilityOf(searchAccountImg));
        searchAccountImg.click();
        return new SearchAccount(driver);
    }

    public OpportunityDetailsPage clickSaveOpportunityBtn(){
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        clickSaveBtn();
        return new OpportunityDetailsPage(driver);
    }
}
