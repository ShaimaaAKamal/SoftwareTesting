package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Checkout_Page {
    WebDriver driver;
    public By Address_existing = By.id("input-shipping-existing");
    public By Address_bar = By.id("input-shipping-address");
    public By Address_new= By.id("input-shipping-new");
    public By First_name=  By.id("input-shipping-firstname");
    public By Last_name= By.id("input-shipping-lastname");
    public By Company= By.id("input-shipping-company");
    public By Address1= By.id("input-shipping-address-1");
    public By Address2= By.id("input-shipping-address-2");
    public By City= By.id("input-shipping-city");
    public By Postcode= By.id("input-shipping-postcode");
    public By Country= By.id("input-shipping-country");
    public By Region_state= By.id("input-shipping-zone");
    public By NewAddressContinueButton= By.id("button-shipping-address");
    public By Shipping= By.id("button-shipping-methods");
    public By ShippingContinueButton= By.xpath("//button[@id=\"button-shipping-method\"]");
    public By Payment= By.id("button-payment-methods");
    public By PaymentContinueButton= By.xpath("//button[@id=\"button-payment-method\"]");
    public By Comments= By.id("input-comment");
    public By Confirmation= By.xpath("//button[@class=\"btn btn-primary\"\"]");


    public Checkout_Page (WebDriver Driver) {
        driver = Driver;
    }


    public void ChooseExistingAddress (){
        driver.findElement(Address_existing).click();
        driver.findElement(Address_bar).click();
        List<WebElement> Addressbar = driver.findElements(Address_bar);
        Addressbar.get(0).click();
    }
    public void ChooseNewAddress (){
        driver.findElement(Address_new).click();
    }
    public void NewFirstName (String name){
        driver.findElement(First_name).sendKeys(name);
    }

    public void NewLastName (String name){
        driver.findElement(Last_name).sendKeys(name);

    }
    public void NewCompany (String name){
        driver.findElement(Company).sendKeys(name);

    }
    public void NewAddress1(String name){
        driver.findElement(Address1).sendKeys(name);
    }
    public void NewAddress2 (String name){
        driver.findElement(Address2).sendKeys(name);
    }
    public void NewCity (String name){
        driver.findElement(City).sendKeys(name);
    }
    public void NewPostCode (Integer number){
        driver.findElement(Postcode).sendKeys(String.valueOf(number));
    }

    public void NewCountry (){
        driver.findElement(Country).click();
        Select countryDropdown = new Select((WebElement) Country);
        countryDropdown.selectByVisibleText("Egypt");
    }

    public void NewRegion (){
        driver.findElement(Region_state).click();
        List<WebElement> RegionState = driver.findElements(Region_state);
        Select Region = new Select((WebElement) RegionState);
        Region.selectByVisibleText("Al Qahirah");

    }
    public void AddressContinueButton (){
        driver.findElement(NewAddressContinueButton).click();
    }


    public void ChooseShipping (){
        driver.findElement(Shipping).click();
        driver.findElement(ShippingContinueButton).click();
    }

    public void PaymentMethod (){
        driver.findElement(Payment).click();
        driver.findElement(PaymentContinueButton).click();
    }

    public void CommentSection (String name) {
        driver.findElement(Comments).click();
        driver.findElement(Comments).sendKeys(name);
    }

    public void Confirm (){
        driver.findElement(Confirmation).click();
    }

    public void AssertAddressNotSelectedError(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-address\"]")).isDisplayed());
    }
    public void AssertLastnameError(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-lastname\"]")).isDisplayed());
    }
    public void AssertAddress1Error(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-address-1\"]")).isDisplayed());

    }
    public void AssertFirstnameError(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-firstname\"]")).isDisplayed());

    }
    public void AssertCityError(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-city\"]")).isDisplayed());

    }
    public void AssertNewAddressSelected(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"alert\"]")).isDisplayed());
    }
    public void AssertNewAddressCountryError(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-country\"]")).isDisplayed());
    }
    public void AssertNewAddressRegionError(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-zone\"]")).isDisplayed());
    }
    public void AssertNewAddressPostCodeError(){
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id=\"input-shipping-postcode\"]")).isDisplayed());

    }
    public void AssertShippingError(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-method\"]")).isDisplayed());
    }

    public void AssertShippingSuccess(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-postcode\"]")).isDisplayed());
    }

    public void AssertPaymentError (){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-payment-method\"]")).isDisplayed());
    }

    public void AssertPaymentSuccess(){
        String Message = "Success: You have changed payment method!";
        Assert.assertEquals(Message," Success: You have changed payment method!");
    }

    public void AssertSuccessfulCheckout(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost/opencart/index.php?route=checkout/success&language=en-gb");

    }

    public void AssertFailureCheckout (){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost/opencart/index.php?route=checkout/checkout&language=en-gb");
    }



}