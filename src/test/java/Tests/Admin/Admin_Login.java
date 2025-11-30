package Tests.Admin;

import Pages.Admin.Admin_Login_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Admin_Login extends BaseTest {
    Admin_Login_Page login;
    @BeforeMethod
    public void preCondition(){
        driver.get(adminPanelBaseUrl);
        login = new Admin_Login_Page(driver);
    }

    @Test(priority = 0)
    public void loginWithEmptyUsername() {
        login.clearAll();
        login.enterPassword("admin");
        login.submitForm();
        waitForVisible(login.errorMessage);
//        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginWithEmptyPassword() {
        login.clearAll();
        login.enterUsername("admin");
        login.submitForm();
        waitForVisible(login.errorMessage);
//        login.assertLoginError();
    }
    //
    @Test(priority = 0)
    public void loginWithAllEmptyFields() {
        login.clearAll();
        login.submitForm();
        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
//        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginvalidUsernameAndInvalidPassword() {
        login.clearAll();
        login.enterUsername("admin");
        login.enterPassword("adminld");
        login.submitForm();
        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
//        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginInvalidUsernameAndvalidPassword() {
        login.clearAll();
        login.enterUsername("admiddn");
        login.enterPassword("admin@");
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
//        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginInvalidUsernameAndInvalidPassword() {
        login.clearAll();
        login.enterUsername("tess");
        login.enterPassword("Test810@");
        login.submitForm();
        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
//        login.assertLoginError();
    }

    @Test(priority = 1)
    public void loginWithvalidUsernameAndvalidPassword() {
        login.enterUsername("admin");
        login.enterPassword("admin");
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
    }

    @Test(priority = 2)
    public void syste() {
        login.enterUsername("admin");
        login.enterPassword("admin");
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
    }


}
