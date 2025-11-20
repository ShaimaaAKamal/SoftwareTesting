package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.AddressBook_Page;
import Pages.Auth.AccountFunctions.ChangePassword_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressBook extends BaseTest {
    AddressBook_Page addressBook;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeMethod
    public void preCondition() {
        driver.get("http://localhost:8888/opencartDemo/");
        addressBook = new AddressBook_Page(driver);
        accountPage=new Account_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail("tete@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToChangePasswordUsingMainPage();
        waitForVisible(addressBook.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void back() {
        addressBook.back();
        waitForVisible(accountPage.editInformation);
    }

    @Test(priority = 0)
    public void addNewAddress() {
        addressBook.addNewAddress();
        waitForVisible(accountPage.editInformation);
    }
}
