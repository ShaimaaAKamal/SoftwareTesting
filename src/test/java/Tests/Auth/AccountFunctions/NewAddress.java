package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.AddressBook_Page;
import Pages.Auth.AccountFunctions.EditAccountInformation_Page;
import Pages.Auth.AccountFunctions.NewAddress_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewAddress extends BaseTest {
    NewAddress_Page newAddress;
    AddressBook_Page addressBook;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        newAddress = new NewAddress_Page(driver);
        accountPage=new Account_Page(driver);
        addressBook=new AddressBook_Page(driver);
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
        addressBook.addNewAddress();
        waitForVisible(newAddress.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void addNewAddressWithEmptyFirstName(){
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCity("Aswan");
        newAddress.enterCode("12651");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.firstNameError);
        newAddress.assertFirstNameError();
    }
    @Test(priority = 0)
    public void addNewAddressWithEmptyLastName(){
        newAddress.enterFirstName("omar");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCity("Aswan");
        newAddress.enterCode("12651");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.lastNameError);
        newAddress.assertLastNameError();
    }
    @Test(priority = 0)
    public void addNewAddressWithEmptyAddress1(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterCity("Aswan");
        newAddress.enterCode("12651");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.address_1_Error);
        newAddress.assertAddress1Error();
    }

    @Test(priority = 0)
    public void addNewAddressWithEmptyCity(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("12651");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.cityError);
        newAddress.assertCityError();
    }

    @Test(priority = 3)
    public void addNewAddressWithEmptyCode(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCity("Aswan");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.PostCodeError);
        newAddress.assertPostCodeError();
    }

    @Test(priority = 3)
    public void addNewAddressWithCodeMoreThan10Digits(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("123456789128");
        newAddress.enterCity("Aswan");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setNoDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.PostCodeError);
        newAddress.assertPostCodeError();
    }

    @Test(priority = 3)
    public void addNewAddressWithCodeLessThan2Digits(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("1");
        newAddress.enterCity("Aswan");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.PostCodeError);
        newAddress.assertPostCodeError();
    }

    @Test(priority = 3)
    public void addNewAddressWithFirstnameMoreThan32Chars(){
        newAddress.enterFirstName("pseudopseudohypoparathyroidism");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("1");
        newAddress.enterCity("Aswan");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.firstNameError);
        newAddress.assertFirstNameError();
    }

    @Test(priority = 3)
    public void addNewAddressWithLastnameMoreThan32Chars(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("pseudopseudohypoparathyroidism");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("1");
        newAddress.enterCity("Aswan");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.lastNameError);
        newAddress.assertLastNameError();
    }

    @Test(priority = 1)
    public void addNewAddressWithCityNameLessThan2Characyer(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("pseudopseudohypoparathyroidism");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("1");
        newAddress.enterCity("A");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.cityError);
        newAddress.assertCityError();
    }

    @Test(priority = 1)
    public void addNewAddressWithCityNameMoreThan128Characyer(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("pseudopseudohypoparathyroidism");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("1");
        newAddress.enterCity("supercalifragilisticexpialidociouspseudopseudohypoparathyroidismantidisestablishmentarianismfloccinaucinihilipilificationcounterrevolutionaries");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.cityError);
        newAddress.assertCityError();
    }



    @Test(priority = 0)
    public void addNewAddressWithEmptyRegion(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCode("12651");
        newAddress.enterCity("Aswan");
        newAddress.setCountry("63");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.regionError);
        newAddress.assertRegionError();
    }

    @Test(priority = 0)
    public void addNewAddressWithAllEmptyFields(){
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(newAddress.firstNameError);
        newAddress.assertAllEmptyErrors();
    }
    @Test(priority = 0)
    public void back(){
        newAddress.back();
        waitForVisible(addressBook.pageTitle);
    }

    @Test(priority = 4)
    public void addNewAddressWithValidData(){
        newAddress.enterFirstName("omar");
        newAddress.enterLastName("kamal");
        newAddress.enterCompany("nemo");
        newAddress.enterAddress1("21st iejd");
        newAddress.enterCity("Aswan");
        newAddress.enterCode("12651");
        newAddress.setCountry("63");
        newAddress.setState("1004");
        newAddress.setDefault();
        newAddress.addAddress();
        waitForVisible(addressBook.pageTitle);
    }

}
