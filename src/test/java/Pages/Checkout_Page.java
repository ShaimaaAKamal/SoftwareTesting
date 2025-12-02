package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Checkout_Page extends Base_Page {
//    WebDriver driver;
    public By pageTitle=By.xpath("//h1[text()='Checkout']");
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
    public By Shipping=By.xpath("//input[@id='input-shipping-method']");
    public By ShippingContinueButton=  By.id("button-shipping-methods");
public By flatRateLabel = By.xpath("//label[@for='input-shipping-method-flat-flat']");
public By chooseMethod = By.id("button-shipping-method");
    By shippingRadio = By.cssSelector("input[type='radio'][name='shipping_method'][value='flat.flat']");
    public By Payment= By.id("button-payment-methods");
    public By PaymentContinueButton= By.id("button-payment-method");
    By paymentRadio = By.cssSelector("input[type='radio'][name='payment_method'][value='cod.cod']");
    public By Comments= By.id("input-comment");
    public By Confirmation= By.xpath("//button[text()='Confirm Order']");
    public By firstNameError=By.xpath("//div[@id='error-shipping-firstname']");
    public By cityError=By.xpath("//div[@id='error-shipping-city']");
    public By address1Error=By.xpath("//div[@id=\"error-shipping-address-1\"]");
    public By countryError=By.xpath("//div[@id=\"error-shipping-country\"]");
    By addNewADDRESS=By.xpath("//button[text()='Continue']");
    public By lastNameError=By.xpath("//div[@id=\"error-shipping-lastname\"]");
    public By addreessNotSelectedError=By.xpath("//div[@id=\"error-shipping-address\"]");
    public By regionError=By.xpath("//div[@id=\"error-shipping-zone\"]");
    public By codeError=By.xpath("//input[@id=\"input-shipping-postcode\"]");
    public By shippingError=By.xpath("//div[@id=\"error-shipping-method\"]");
    public By paymentError=By.xpath("//div[@id=\"error-payment-method\"]");
    public By successMessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By errorMessage=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    public By orderPlaced=By.xpath("//h1[text()='Your order has been placed!']");
    public Checkout_Page (WebDriver Driver) {
       super(Driver);
    }
    public List<WebElement> getAllOrderStatusOptions() {
        WebElement dropdown = driver.findElement(Address_bar);
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        return options;
    }

    public void selectFirstOrderStatusOption() {
        WebElement dropdown = driver.findElement(Address_bar);
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        select.selectByIndex(0);
    }
    public void ChooseExistingAddress (){
        driver.findElement(Address_existing).click();
        selectFirstOrderStatusOption();
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
        WebElement countryElement=driver.findElement(Country);
        countryElement.click();
        Select countryDropdown = new Select(countryElement);
        countryDropdown.selectByVisibleText("Egypt");
    }

    public void NewRegion (){
        WebElement regionElement=driver.findElement(Region_state);
        regionElement.click();
//        List<WebElement> RegionState = driver.findElements(Region_state);
        Select Region = new Select(regionElement);
        Region.selectByVisibleText("Al Qahirah");
    }
    public void AddressContinueButton (){
        driver.findElement(NewAddressContinueButton).click();
    }


    public void ChooseShipping (){
        driver.findElement(Shipping).click();
        driver.findElement(ShippingContinueButton).click();
    }

    public void clickContinueShipping (){
        scrollAndClick(ShippingContinueButton);
//        driver.findElement(ShippingContinueButton).click();
    }

    public void chooseShippingMethod(){
        driver.findElement(chooseMethod).click();
    }

    public void clickShippingRadio(){
        driver.findElement(shippingRadio).click();
    }
    public void PaymentMethod (){
        driver.findElement(Payment).click();
    }
    public void clickPaymentContinueButton(){
        driver.findElement(PaymentContinueButton).click();
    }
    public void clickRadioButton(){
        driver.findElement(paymentRadio).click();
    }
    public void CommentSection (String name) {
        driver.findElement(Comments).click();
        driver.findElement(Comments).sendKeys(name);
    }

    public void Confirm (){
        scrollAndClick(Confirmation);
    }

    public void clickAddNewaddress(){
        WebElement button = driver.findElement(addNewADDRESS);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // Add small delay to ensure layout stabilizes
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        // Click using JS to bypass overlays
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
//        driver.findElement(addNewADDRESS).click();
//    }

    public void AssertAddressNotSelectedError(){
        Assert.assertTrue(driver.findElement(addreessNotSelectedError).isDisplayed());
    }
    public void AssertLastnameError(){
        Assert.assertTrue(driver.findElement(lastNameError).isDisplayed());
    }
    public void AssertAddress1Error(){
        Assert.assertTrue(driver.findElement(address1Error).isDisplayed());

    }
    public void AssertFirstnameError(){
        Assert.assertTrue(driver.findElement(firstNameError).isDisplayed());

    }
    public void AssertCityError(){
        Assert.assertTrue(driver.findElement(cityError).isDisplayed());
    }
    public void AssertNewAddressSelected(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"alert\"]")).isDisplayed());
    }
    public void AssertNewAddressCountryError(){
        Assert.assertTrue(driver.findElement(countryError).isDisplayed());
    }
    public void AssertNewAddressRegionError(){
        Assert.assertTrue(driver.findElement(regionError).isDisplayed());
    }
    public void AssertNewAddressPostCodeError(){
        Assert.assertTrue(driver.findElement(codeError).isDisplayed());

    }
    public void AssertShippingError(){
        Assert.assertTrue(driver.findElement(shippingError).isDisplayed());
    }

    public void AssertShippingSuccess(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"error-shipping-postcode\"]")).isDisplayed());
    }

    public void AssertPaymentError (){
        Assert.assertTrue(driver.findElement(paymentError).isDisplayed());
    }

    public void AssertPaymentSuccess(){
        String Message = "Success: You have changed payment method!";
        Assert.assertEquals(Message,"Success: You have changed payment method!");
    }

    public void AssertSuccessfulCheckout(){
        Assert.assertTrue(driver.findElement(orderPlaced).isDisplayed());
    }

    public void AssertFailureCheckout (){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://localhost/opencart/index.php?route=checkout/checkout&language=en-gb");
    }

    public void assertInCheckoutPage(){
        String title=driver.findElement(pageTitle).getText();
        Assert.assertEquals(title,"Checkout");
    }

    public void assertExistingAddresses(){
       int existingAddress= getAllOrderStatusOptions().size();
       Assert.assertTrue(existingAddress > 0);
    }

  public void AssertShippingMethodError(){
          Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
  }

    public void AssertPaymentMethodError(){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
    }

    public void assertAlert(){
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
    }

}