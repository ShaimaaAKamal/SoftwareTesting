package Tests;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Cart_Page;
import Pages.Checkout_Page;
import Pages.Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Checkout extends BaseTest{
    Checkout_Page checkout;
    WebDriverWait wait;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;
    Cart_Page cartPage;
    @BeforeClass
    public void Setup() {
        home=new Home_Page(driver);
        checkout = new Checkout_Page(driver);
        login=new Login_Page(driver);
        accountPage=new Account_Page(driver);
        cartPage=new Cart_Page(driver);
    }



    @BeforeMethod
    public void preconditions ()
    {
        driver.get(storeBaseUrl);
        // Go to login page
        home.clickMyAccount();
        home.clickLogin();
        // Login
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        waitForVisible(accountPage.editInformation);
        // Add product
        driver.findElement(By.linkText("Phones & PDAs")).click();
        waitForVisible(By.xpath("//h1[text()='Phones & PDAs']"));
//        driver.findElement(By.xpath("(//button)[1]")).click();

        // Go to checkout
        driver.findElement(cartPage.productCartIcon).click();
        waitForVisible(cartPage.Success_Message);
        waitFoRInVisible(cartPage.Success_Message);
        driver.findElement(By.xpath("//span[text()='Checkout']")).click();
        waitForVisible(checkout.pageTitle);
    }

    @AfterMethod
    public void after(){
//        driver.get("http://localhost:8888/opencart/");
        home.clickMyAccount();
        home.clickLogout();
    }


    @Test(priority = 0)
  public void assertInCheckoutPage(){
        checkout.assertInCheckoutPage();
    }


    @Test(priority = 0, dependsOnMethods = "assertInCheckoutPage")
    public void assertExistingAddress (){
        checkout.assertExistingAddresses();
    }

    @Test(priority = 0, dependsOnMethods = "assertExistingAddress")
    public void chooseExistingAddress (){
        checkout.ChooseExistingAddress();
    }


    @Test(priority = 1)
    public void UsingNewAddressMissingFirst (){
        checkout.ChooseNewAddress();
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.firstNameError);
        checkout.AssertFirstnameError();
    }
    @Test(priority = 1)

    public void UsingNewAddressMissingLastname (){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.lastNameError);
        checkout.AssertLastnameError();
    }

    @Test(priority = 1)
    public void UsingNewAddressMissingAddress1 (){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.address1Error);
        checkout.AssertAddress1Error();
    }

    @Test(priority = 1)
    public void UsingNewAddressMissingCity (){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.cityError);
        checkout.AssertCityError();
    }

    @Test(priority = 1)
    public void UsingNewAddressMissingPostCode (){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.codeError);
        checkout.AssertNewAddressPostCodeError();
    }

    @Test(priority = 1)
    public void UsingNewAddressMissingRegion (){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.regionError);
        checkout.AssertNewAddressRegionError();
    }

    @Test(priority = 2)
    public void useSuccessfullNewAddress (){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.successMessage);
        checkout.assertAlert();
    }


    @Test(priority = 3 )
    public void ShippingMethodSuccessful() throws InterruptedException {
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.successMessage);
        waitFoRInVisible(checkout.successMessage);
        checkout.clickContinueShipping();
        waitForVisible(checkout.flatRateLabel);
        checkout.clickShippingRadio();
        checkout.chooseShippingMethod();
        waitForVisible(checkout.successMessage);
    }

//    @Test(priority = 3 )
//    public void ShippingMethodFailure(){
//        checkout.ChooseNewAddress();
//        checkout.NewFirstName("Moamen");
//        checkout.NewLastName("Ahmed");
//        checkout.NewCompany("HiTechNour");
//        checkout.NewAddress1("48 Bavaria elmaadi");
//        checkout.NewAddress2("Madint Nasr");
//        checkout.NewCity("Giza");
//        checkout.NewPostCode(4444);
//        checkout.NewCountry();
//        checkout.NewRegion();
//        checkout.clickAddNewaddress();
//        waitForVisible(checkout.successMessage);
//        waitFoRInVisible(checkout.successMessage);
//        checkout.clickContinueShipping();
//        waitForVisible(checkout.flatRateLabel);
//        checkout.chooseShippingMethod();
//        waitForVisible(checkout.errorMessage);
//        checkout.AssertShippingMethodError();
//    }

    @Test(priority = 3)
    public void PaymentMethodSuccess(){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.successMessage);
        waitFoRInVisible(checkout.successMessage);
        checkout.clickContinueShipping();
        waitForVisible(checkout.flatRateLabel);
        checkout.clickShippingRadio();
        checkout.chooseShippingMethod();
        waitForVisible(checkout.successMessage);
        waitFoRInVisible(checkout.successMessage);
        checkout.PaymentMethod();
        waitForVisible(checkout.PaymentContinueButton);
        checkout.clickRadioButton();
        checkout.clickPaymentContinueButton();
        waitForVisible(checkout.successMessage);
        checkout.AssertPaymentSuccess();
    }

//    @Test(priority = 3)
//    public void PaymentMethodSFailure(){
//        checkout.ChooseNewAddress();
//        checkout.NewFirstName("Moamen");
//        checkout.NewLastName("Ahmed");
//        checkout.NewCompany("HiTechNour");
//        checkout.NewAddress1("48 Bavaria elmaadi");
//        checkout.NewAddress2("Madint Nasr");
//        checkout.NewCity("Giza");
//        checkout.NewPostCode(4444);
//        checkout.NewCountry();
//        checkout.NewRegion();
//        checkout.clickAddNewaddress();
//        waitForVisible(checkout.successMessage);
//        waitFoRInVisible(checkout.successMessage);
//        checkout.clickContinueShipping();
//        waitForVisible(checkout.flatRateLabel);
//        checkout.clickShippingRadio();
//        checkout.chooseShippingMethod();
//        waitForVisible(checkout.successMessage);
//        waitFoRInVisible(checkout.successMessage);
//        checkout.PaymentMethod();
//        waitForVisible(checkout.PaymentContinueButton);
//        checkout.clickPaymentContinueButton();
//        waitForVisible(checkout.errorMessage);
//        checkout.AssertPaymentMethodError();
//    }

    @Test(priority = 4)
    public void PlaceAnOrder(){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.successMessage);
        waitFoRInVisible(checkout.successMessage);
        checkout.clickContinueShipping();
        waitForVisible(checkout.flatRateLabel);
        checkout.clickShippingRadio();
        checkout.chooseShippingMethod();
        waitForVisible(checkout.successMessage);
        waitFoRInVisible(checkout.successMessage);
        checkout.PaymentMethod();
        waitForVisible(checkout.PaymentContinueButton);
        checkout.clickRadioButton();
        checkout.clickPaymentContinueButton();
        waitForVisible(checkout.successMessage);
        checkout.Confirm();
        waitForVisible(checkout.orderPlaced);
        checkout.AssertSuccessfulCheckout();
    }

}