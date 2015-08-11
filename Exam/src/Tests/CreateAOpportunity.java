package Tests;

import Pages.*;

import framework.WebDriverManager;
import org.testng.Assert;

import org.testng.annotations.*;

/**
 * Created by Veronica Prado on 8/10/2015.
 */
public class CreateAOpportunity {

    private SalesForceMain salesForceMain;
    private SalesMenu salesMenu;
    private String accountName = "Account2";
    private String opportunityName = "Oportunity2";
    private String closeDate = "8/10/2015";
    private String stageName ="Prospecting";
    private OpportunityDetailsPage opportunityDetailsPage;

    @BeforeClass
    public void setup(){
        //Preconditions
        //1. Login in the app
        LoginPage login = new LoginPage();
        salesForceMain = login.loginAsPrimaryUSer();
        //2. Create  an account object
        salesMenu = salesForceMain.gotoSalesMenu();
        AccountsHomePage accountsHomePage = salesMenu.clickAccountsTab();
        CreateAccount createAccount = accountsHomePage.clickNewAccountBtn()
                .setAccountNameTxt(accountName);
        createAccount.clickSaveBtn();

    }
    @Test
    public void createAOpportunity(){

        OpportunityHomePage opportunityPage = salesMenu.clickOpportunityTab();
        CreateOpportunity createOpportunity = opportunityPage.clickNewOpportunityBtn()
                .setOpportunityNameTxt(opportunityName)
                .setCloseDateTxt(closeDate)
                .setStateSelectBox(stageName);
        SearchAccount searchAccount = createOpportunity.clickSearchAccountImg();
        searchAccount.searchAccount(accountName);
        opportunityDetailsPage = createOpportunity.clickSaveOpportunityBtn();
        Assert.assertTrue(opportunityName.equals(opportunityDetailsPage.getOpportunityNameValue()),
                "opportunity Name was not created correctly");
        Assert.assertTrue(closeDate.equals(opportunityDetailsPage.getCloseDateValue()),
                "Close Date was not added correctly");
        Assert.assertTrue(stageName.equals(opportunityDetailsPage.getStageValue()),
                "Stage was not added correctly");
        Assert.assertTrue(accountName.equals(opportunityDetailsPage.getAccountValue()),
                "Account was not created corretly");
    }
    @AfterClass
    public void tearDown(){
        opportunityDetailsPage.clickDeleteOpportunityBtn();
        SalesMenu sal = new SalesMenu(WebDriverManager.getInstance().getDriver());
        AccountsHomePage accountsHomePage = sal.clickAccountsTab();
        AccountDetailPage accountDetailPage = accountsHomePage.selectAccount(accountName);
        accountsHomePage= accountDetailPage.clickDeleteAccountBtn();

    }

}
