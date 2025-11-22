package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.ChangePassword_Page;
import Pages.Auth.AccountFunctions.NewLetters_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewLetters extends BaseTest {
    NewLetters_Page newsLetters;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeMethod
    public void preCondition() {
        driver.get("http://localhost:8888/opencartDemo/");
        newsLetters = new NewLetters_Page(driver);
        accountPage=new Account_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail("tete@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToNewsLetters();
        waitForVisible(newsLetters.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test
    public void back(){
        newsLetters.back();
        waitForVisible(accountPage.editInformation);
    }

    @Test
    public void continueClicking(){
        newsLetters.clickContinue();
        waitForVisible(accountPage.editInformation);
    }

    @Test
    public void subscribe(){
        newsLetters.susbcribe();
        newsLetters.clickContinue();
        waitForVisible(accountPage.updatedSuccessfully);
    }
}
