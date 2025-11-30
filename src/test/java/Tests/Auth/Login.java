package Tests.Auth;

import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login extends BaseTest {
    Login_Page login;
    Home_Page home;
    @BeforeMethod
    public void preCondition(){
        driver.get(storeBaseUrl);
        home=new Home_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login = new Login_Page(driver);
    }



    @Test(priority = 0)
    public void loginWithEmptyEmail() {

        login.enterPassword("Test710@");
        login.submitForm();
        waitForVisible(login.errorMessage);
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginWithEmptyPassword() {
        login.enterEmail("temo@gmail.com");
        login.submitForm();
        waitForVisible(login.errorMessage);
        login.assertLoginError();
    }
//
    @Test(priority = 0)
    public void loginWithAllEmptyFields() {
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginvalidEmailAndInvalidPassword() {
        login.enterEmail("temo@gmail.com");
        login.enterPassword("tejd@345");
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginInvalidEmailAndvalidPassword() {
        login.enterEmail("teko@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginInvalidEmailAndInvalidPassword() {
        login.enterEmail("teko@gmail.com");
        login.enterPassword("Test810@");
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(login.errorMessage);
        login.assertLoginError();
    }

    @Test(priority = 1)
    public void loginWithvalidEmailAndvalidPassword() {
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("route=account/login")
        ));
    }


}
