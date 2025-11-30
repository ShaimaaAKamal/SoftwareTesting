package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.EditAccountInformation_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Auth.Register_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditAccountInformation extends BaseTest {

    EditAccountInformation_Page edit;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        edit = new EditAccountInformation_Page(driver);
        accountPage=new Account_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToEditAccountUsingMainPage();
        waitForVisible(edit.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }


    @Test(priority = 0)
    public void editWithEmptyFirstName() {
        edit.clearFirstName();
        edit.changeInformation();
        waitForVisible(By.id("error-firstname"));
        edit.asserTFirstNameError();
    }
    @Test(priority = 0)
    public void editWithEmptyLastName() {
        edit.clearLastName();
        edit.changeInformation();
        waitForVisible(By.id("error-lastname"));
        edit.asserTLasttNameError();
    }
    @Test(priority = 0)
    public void editWithEmptyEmailAddress() {
        edit.clearEmailAddress();
        edit.changeInformation();
        waitForVisible(By.id("error-email"));
        edit.asserTEmailError();
    }

    @Test(priority = 0)
    public void editWithAllEmptyFields() {
        edit.clearFirstName();
        edit.clearLastName();
        edit.clearEmailAddress();
        edit.changeInformation();
        // Wait for any one error (first name error)
        waitForVisible(By.id("error-firstname"));
        edit.assertAllEmptyFields();
    }
    @Test(priority = 0)
    public void editWithFirstNameExceedingMaxLength()  {
        edit.clearFirstName();
        edit.enterFirstName("Superduperultramegatasticwordddd");
        edit.changeInformation();
        waitForVisible(By.id("error-firstname"));
        edit.asserTFirstNameError();
    }

    @Test(priority = 0)
    public void editWithInValidEmail() {
        edit.clearEmailAddress();
        edit.enterEmailAddress("tete@hamilcom");
        edit.changeInformation();
        waitForVisible(By.id("error-email"));
        edit.asserTEmailError();
    }

    @Test(priority = 0)
    public void editWithLastNameExceedingMaxLength() {
        edit.clearLastName();
        edit.enterLastName("Superduperultramegatasticwordddd");
        edit.changeInformation();
        waitForVisible(By.id("error-lastname"));
        edit.asserTLasttNameError();
    }
    @Test(priority = 1)
    public void editWithValidData() {
        edit.clearFirstName();
        edit.enterFirstName("shaimaa");
        edit.clearLastName();
        edit.enterLastName("Kamal");
        edit.clearEmailAddress();
        edit.enterEmailAddress("tete@gmail.com");
        edit.changeInformation();
        waitForVisible(accountPage.updatedSuccessfully);
    }

    @Test(priority = 1)
    public void back() {
        edit.back();
        waitForVisible(accountPage.editInformation);
    }



}
