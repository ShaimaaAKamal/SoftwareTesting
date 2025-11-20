package Tests.Auth;

import Pages.Auth.AccountFunctions.AddressBook_Page;
import Pages.Auth.AccountFunctions.ChangePassword_Page;
import Pages.Auth.AccountFunctions.EditAccountInformation_Page;
import Pages.Auth.AccountFunctions.wishlist_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.*;

public class Account extends BaseTest {
    Login_Page login;
    Home_Page home;
    Account_Page accountPage;
    EditAccountInformation_Page editAccount;
    ChangePassword_Page changePassword;
    AddressBook_Page addressBook;
    wishlist_Page wishlist;
    @BeforeTest
    public void beforeTest(){
        home=new Home_Page(driver);
        login = new Login_Page(driver);
        accountPage=new Account_Page(driver);
        editAccount=new EditAccountInformation_Page(driver);
        changePassword=new ChangePassword_Page(driver);
        addressBook=new AddressBook_Page(driver);
        wishlist=new wishlist_Page(driver);
        accountPage.logout();
    }
    @BeforeMethod
    public void preCondition() {
        driver.get("http://localhost:8888/opencartDemo/");
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail("temo@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();
        waitForVisible(accountPage.editInformation);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void navigateToEditAccountUsingMainPage(){
        accountPage.navigateToEditAccountUsingMainPage();
        waitForVisible(editAccount.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToEditAccountUsingSidebar(){
        accountPage.navigateToEditAccountUsingSidebar();
        waitForVisible(editAccount.pageTitle);
    }


    @Test(priority = 0)
    public void navigateToChangePasswordSidebar(){
        accountPage.navigateToChangePasswordUsingSidebar();
        waitForVisible(changePassword.PageTitle);
    }

    @Test(priority = 0)
    public void navigateToChangePasswordUsingMainPage(){
        accountPage.navigateToChangePasswordUsingMainPage();
        waitForVisible(changePassword.PageTitle);
    }

    @Test(priority = 0)
    public void navigateToAddressbookSidebar(){
        accountPage.navigateToAddressBookUsingSidebar();
        waitForVisible(addressBook.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToWishlistUsingMainPage(){
        accountPage.navigateToWishlistUsingMainPage();
        waitForVisible(wishlist.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToWishlistUsingSidebar(){
        accountPage.navigateToWishlistUsingSidebar();
        waitForVisible(wishlist.pageTitle);
    }
}
