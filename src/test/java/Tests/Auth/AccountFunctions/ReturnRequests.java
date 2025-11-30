package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.OrderHistory_Page;
import Pages.Auth.AccountFunctions.ReturnRequests_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReturnRequests  extends BaseTest {

    ReturnRequests_Page returns;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;
    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        returns = new ReturnRequests_Page(driver);
        accountPage=new Account_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToReturnsRequestsUsingMainPage();
        waitForVisible(returns.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void assertInpage() {
        returns.assertInOrderHistoryPage();
    }

    @Test(priority = 1)
    public void clickContinue() {
        returns.clickContinue();
        waitForVisible(accountPage.editInformation);
    }
}
