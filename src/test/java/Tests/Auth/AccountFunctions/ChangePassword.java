package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.ChangePassword_Page;
import Pages.Auth.AccountFunctions.EditAccountInformation_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePassword extends BaseTest {

    ChangePassword_Page updatePassword;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        updatePassword = new ChangePassword_Page(driver);
        accountPage=new Account_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToChangePasswordUsingMainPage();
        waitForVisible(updatePassword.PageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void editWithEmptyPassword() {
        updatePassword.enterConfirmPassword("Test710#");
        updatePassword.changePassword();
        waitForVisible(updatePassword.passwordError);
        updatePassword.assertEmptyPasswordError();
    }

    @Test(priority = 0)
    public void editWithEmptyConfirmPassword() {
        updatePassword.enterPassword("Test710#");
        updatePassword.changePassword();
        waitForVisible(updatePassword.confirmPasswordError);
        updatePassword.assertEmptyConfirmPassword();
    }

    @Test(priority = 0)
    public void editWithBothEmpty() {
        updatePassword.changePassword();
        waitForVisible(updatePassword.passwordError);
        updatePassword.assertBothEmpty();
    }
    @Test(priority = 0)
    public void editWithPasswordLessThan4() {
        updatePassword.enterPassword("123");
        updatePassword.changePassword();
        waitForVisible(updatePassword.passwordError);
        updatePassword.assertEmptyPasswordError();
    }
    @Test(priority = 0)
    public void editWithPasswordMoreThan20() {
        updatePassword.enterPassword("counterproductivesw");
        updatePassword.changePassword();
        waitForVisible(updatePassword.passwordError);
        updatePassword.assertEmptyPasswordError();
    }


    @Test(priority = 0)
    public void editWithPasswordDoNotMatch() {
        updatePassword.enterPassword("Test710@");
        updatePassword.enterConfirmPassword("Test710#");
        updatePassword.changePassword();
        waitForVisible(updatePassword.confirmPasswordError);
        updatePassword.assertEmptyConfirmPassword();
    }

    @Test(priority = 1)
    public void back() {
        updatePassword.back();
        waitForVisible(accountPage.editInformation);
    }
    @Test(priority = 1)
    public void editPasswordWithValidData() {
        updatePassword.enterPassword("Test710@");
        updatePassword.enterConfirmPassword("Test710@");
        updatePassword.changePassword();
        waitForVisible(accountPage.updatedSuccessfully);
    }
}
