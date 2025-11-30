package Tests.Auth.AccountFunctions;

import Pages.Admin.Dashboard_Page;
import Pages.Auth.AccountFunctions.Downloads_Page;
import Pages.Auth.AccountFunctions.RewardPoint_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Downloads extends BaseTest {

    Downloads_Page downlaods;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;
    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        downlaods = new Downloads_Page(driver);
        accountPage=new Account_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToDownloadsUsingSidebar();
        waitForVisible(downlaods.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void assertInpage() {
        downlaods.assertInOrderHistoryPage();
    }

    @Test(priority = 1)
    public void clickContinue() {
        downlaods.clickContinue();
        waitForVisible(accountPage.editInformation);
    }
}
