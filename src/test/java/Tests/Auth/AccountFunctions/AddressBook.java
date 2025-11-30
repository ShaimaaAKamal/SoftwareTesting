package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.AddressBook_Page;
import Pages.Auth.AccountFunctions.ChangePassword_Page;
import Pages.Auth.AccountFunctions.NewAddress_Page;
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
    NewAddress_Page newAddress;
    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        addressBook = new AddressBook_Page(driver);
        accountPage=new Account_Page(driver);
        newAddress=new NewAddress_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToAddressBookUsingMainPage();
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
        waitForVisible(newAddress.pageTitle);
    }

    @Test(priority = 0)
    public void removeOnlyExistingAddress() {
        if(addressBook.addressesCount() ==  1){
            addressBook.deleteOnlyAddress();
            waitForVisible(addressBook.errorMessage);
        }
    }
    @Test(priority = 0)
    public void removeOneAddressUsingIndex() {
        int index=1;
        int noOfAddress=addressBook.addressesCount();
        if((noOfAddress-1) >= index && index !=0){
            addressBook.deleteAddressUsingIndex(1);
        }
    }




}
