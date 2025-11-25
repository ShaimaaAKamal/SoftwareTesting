package Tests;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Checkout_Page;
import Pages.Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Checkout extends BaseTest{
    Checkout_Page checkout;
    WebDriverWait wait;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeClass
    public void Setup() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8888/opencartDemo/");
        checkout = new Checkout_Page(driver);
        // Go to login page
        driver.findElement(By.cssSelector(".fa-user")).click();
        driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Login']")).click();
        // Login
        driver.findElement(By.id("input-email")).sendKeys("nightmare.orc1000@hotmail.com");
        driver.findElement(By.id("input-password")).sendKeys("raxxarthrall");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }



    @BeforeMethod
    public void preconditions ()
    {
        // Add product
        driver.findElement(By.xpath("//a[normalize-space()='Phones & PDAs']")).click();
        driver.findElement(By.xpath("(//button)[1]")).click();

        // Go to checkout
        driver.findElement(By.xpath("//button[normalize-space()='2 item(s) - $244.00']")).click();
        driver.findElement(By.xpath("//strong[normalize-space()='Checkout']")).click();


    }

//    // 🔹 Helper wait method for visibility
//    public void waitForVisible(By locator){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }

    @Test(priority = 0)
    public void UsingExistingAddress (){
        checkout.ChooseExistingAddress();
    }
    @Test(priority = 1)
    public void UsingNewAddressSuccess (){
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
        checkout.AssertNewAddressSelected();
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
        checkout.AssertCityError();
    }
    @Test(priority = 1)
    public void UsingNewAddressMissingCountry (){
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewPostCode(4444);
        checkout.NewRegion();
        checkout.AssertNewAddressCountryError();
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
        checkout.AssertNewAddressRegionError();
    }

    @Test(priority = 1)
    public void ShippingMethodSuccessful (){
        checkout.ChooseExistingAddress();
        checkout.ChooseShipping();
        checkout.AssertShippingSuccess();
    }

    @Test(priority = 1)
    public void ShippingMethodFailure(){

        checkout.ChooseShipping();
        checkout.AssertShippingError();
    }

    @Test(priority = 1)
    public void PaymentMethodSuccess(){
        checkout.ChooseExistingAddress();
        checkout.ChooseShipping();
        checkout.PaymentMethod();
        checkout.AssertPaymentSuccess();
    }

    @Test(priority = 1)
    public void PaymentMethodFailure(){
        checkout.ChooseShipping();
        checkout.PaymentMethod();
        checkout.AssertPaymentError();
    }

    @Test(priority = 1)
    public void AssertCheckoutSuccess(){
        checkout.ChooseExistingAddress();
        checkout.ChooseShipping();
        checkout.PaymentMethod();
        checkout.AssertSuccessfulCheckout();
    }




}