package Tests.Auth;

import Pages.Auth.Forget_Password_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Forget_Password extends BaseTest {
    Home_Page home;
    Forget_Password_Page forgetPassword;
    Login_Page login;

    @BeforeMethod
    public void preCondition(){
        driver.get(storeBaseUrl);
        home=new Home_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login =new Login_Page(driver);
        forgetPassword= new Forget_Password_Page(driver);
        login.navigateToForgetPassword();
        waitForVisible(forgetPassword.backBtn);
    }

    @Test(priority = 0)
    public void sendForgetPasswordWithEmptyEmail() {
        forgetPassword.clickContinue();
        waitForVisible(forgetPassword.errorMessage);
        forgetPassword.assertError();
    }

    @Test(priority = 0)
    public void sendForgetPasswordWithInvalidEmail() {
        forgetPassword.enterEmailAddress("tteo@@gmail.com");
        forgetPassword.clickContinue();
        waitForVisible(forgetPassword.errorMessage);
        forgetPassword.assertError();
    }

    @Test(priority = 0)
    public void navigateToLoginPage() {
        forgetPassword.Back();
        waitForVisible(login.password);
       forgetPassword.assertBackToLogin();
    }

    @Test(priority = 0)
    public void sendForgetPasswordWithvalidEmail() {
        forgetPassword.enterEmailAddress("tete@gmail.com");
        forgetPassword.clickContinue();
        waitForVisible(login.successForgetPasswordMessage);
        forgetPassword.assertSuccessMessage();
    }



}



