package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.OrderHistory_Page;
import Pages.Auth.AccountFunctions.Transcations_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Transcations extends BaseTest {

    Transcations_Page transcation;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;
    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        transcation = new Transcations_Page(driver);
        accountPage=new Account_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToTranscationsUsingMainPage();
        waitForVisible(transcation.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void assertInpage() {
        transcation.assertInOrderHistoryPage();
    }

    @Test(priority = 1)
    public void clickContinue() {
        transcation.clickContinue();
        waitForVisible(accountPage.editInformation);
    }
}
