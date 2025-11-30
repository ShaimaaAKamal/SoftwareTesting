package Pages.Admin.Orders;

import Pages.Base_Page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Single_Order_Page extends Base_Page {

    // ---------- BUTTONS ----------
    public By addOrderBtn = By.cssSelector("a[data-bs-original-title='Add New']");
    public By saveBtn = By.cssSelector("button[form='form-order'][type='submit']");
    public By cancelBtn = By.cssSelector("a.btn.btn-light");
//    By closeBtn=By.cssSelector(".btn-close");
   public By closeBtn=By.cssSelector("button[data-bs-dismiss='modal']");
    // ---------- CUSTOMER TAB ----------
    public By customerTab = By.xpath("//button[@data-bs-target='#modal-customer']");
//    public By customerTab = By.xpath("//*[@id='content']/div[2]/div[1]/div[2]/div[1]/div[2]/div/button");
    public By inputCustomer = By.id("input-customer");
     By inputFirstName = By.id("input-firstname");
     By inputLastName = By.id("input-lastname");
     By inputEmail = By.id("input-email");
     By inputTelephone = By.id("input-telephone");
    public By errorFirstName=By.id("error-firstname");
    public By errorLasrName=By.id("error-lastname");
    public By errorEmail=By.id("error-email");
    By saveCustomerBtn = By.id("button-customer");
    public By imacProduct=By.linkText("iMac");
    public By inputCustomerGroup = By.id("input-customer-group");
    // ---------- PAYMENT ADDRESS ----------
    public By paymentAddressTab =  By.xpath("//button[@data-bs-target='#modal-payment-address']");
    public By paymentFirstName = By.id("input-payment-firstname");
    public By paymentLastName = By.id("input-payment-lastname");
    public By paymentAddress1 = By.id("input-payment-address-1");
    public By paymentCity = By.id("input-payment-city");
    public By paymentPostcode = By.id("input-payment-postcode");
    public By paymentCountry = By.id("input-payment-country");
    public By paymentZone = By.id("input-payment-zone");
    public By errorPaymentFirstName=By.id("error-payment-firstname");
    public By errorPaymentLasrName=By.id("error-payment-lastname");
    public By errorPaymentAddress1=By.id("error-payment-address-1");
    public By errorPaymentCity=By.id("error-payment-city");
    public By savePaymentBtn = By.id("button-payment-address");

    // ---------- SHIPPING ADDRESS ----------
    public By shippingAddressTab = By.xpath("//button[@data-bs-target='#modal-shipping-address']");
    public By shippingFirstName = By.id("input-shipping-firstname");
    public By shippingLastName = By.id("input-shipping-lastname");
    public By shippingAddress1 = By.id("input-shipping-address-1");
    public By shippingCity = By.id("input-shipping-city");
    public By shippingPostcode = By.id("input-shipping-postcode");
    public By shippingCountry = By.id("input-shipping-country");
    public By shippingZone = By.id("input-shipping-zone");
    public By errorShippingFirstName=By.id("error-shipping-firstname");
    public By errorShippingLasrName=By.id("error-shipping-lastname");
    public By errorShippingAddress1=By.id("error-shipping-address-1");
    public By errorShippingtCity=By.id("error-shipping-city");
    public By saveShippingBtn = By.id("button-shipping-address");

    // ---------- PRODUCTS ----------
    public By saveProduct = By.id("button-product-add");
    public By inputProduct = By.id("input-product");
    public By productQty=By.id("input-quantity");
//    public By addProductBtn =By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tfoot[1]/tr[1]/td[2]/button[1]");
public By addProductBtn =By.cssSelector("button[data-bs-target='#modal-product']");
    // ---------- TOTALS ----------
    public By totalsTab = By.cssSelector("a[href='#tab-total']");
    public By shippingMethodTab= By.id("button-shipping-methods");
    public By shippingMethod = By.id("input-shipping-method-0");
    public By paymentMethodTab = By.id("button-payment-methods");
    public By paymentMethod = By.id("input-payment-method-0");
    public By saveShippingMethodBtn = By.id("button-shipping-method");
    public By savePaymentMethodBtn = By.id("button-payment-method");
    public By confirmButton=By.id("button-confirm");


    // ---------- HISTORY ----------
    public By historyTab = By.cssSelector("a[href='#tab-history']");
    public By orderStatus = By.id("input-order-status");
    public By addHistoryBtn = By.id("button-history");

    // ---------- SUCCESS MESSAGE ----------
//    public By successAlert = By.cssSelector(".alert-success");

    public By successAlert = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By errorAlert=By.cssSelector(".alert-danger");
    public Single_Order_Page(WebDriver driver){
        super(driver);
    }

    public void openProductModel() {
        driver.findElement(addProductBtn).click();
    }
    public void enterProductName(String name) {
        driver.findElement(inputProduct).clear();
        driver.findElement(inputProduct).sendKeys(name);
    }
    public void enterProductQty(String num) {
        driver.findElement(productQty).clear();
        driver.findElement(productQty).sendKeys(num);
    }

    public void saveProdut(){
        scrollAndClick(saveProduct);
    }

    public void openCustomerModel(){
         scrollAndClick(customerTab);
    }
    public void enterFirstName(String fname) {
        driver.findElement(inputFirstName).clear();
        driver.findElement(inputFirstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(inputLastName).clear();
        driver.findElement(inputLastName).sendKeys(lname);
    }

    public void enterEmail(String email) {
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void enterTelephone(String phone) {
        driver.findElement(inputTelephone).clear();
        driver.findElement(inputTelephone).sendKeys(phone);
    }

    public void openPaymentModel() {
        driver.findElement(paymentAddressTab).click();
    }

    public void entrePaymentFirstName(String name) {
        driver.findElement(paymentFirstName).clear();
        driver.findElement(paymentFirstName).sendKeys(name);
    }
    public void enterPaymentLastName(String name) {
        driver.findElement(paymentLastName).clear();
        driver.findElement(paymentLastName).sendKeys(name);
    }
    public void entrePaymentAddress1(String name) {
        driver.findElement(paymentAddress1).clear();
        driver.findElement(paymentAddress1).sendKeys(name);
    }
    public void entrePaymentCity(String name) {
        driver.findElement(paymentCity).clear();
        driver.findElement(paymentCity).sendKeys(name);
    }
    public void entrePaymentCode(String name) {
        driver.findElement(paymentPostcode).clear();
        driver.findElement(paymentPostcode).sendKeys(name);
    }

    public void selectPaymentCountry(String coun) {
        WebElement country=driver.findElement(paymentCountry);
        country.click();
        Select countryElement=new Select(country);
        countryElement.selectByVisibleText(coun);
    }
    public void selectPaymentZone(String val)  {
        WebElement zone=driver.findElement(paymentZone);
        zone.click();
        Select zoneElement=new Select(zone);
        zoneElement.selectByVisibleText(val);
        zone.sendKeys(Keys.TAB);
    }
    public void savePaymentData() {
     scrollAndClick(savePaymentBtn);
    }

    public void scrollModelUp() {
        WebElement element = driver.findElement(By.cssSelector(".modal-body"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop=arguments[1].offsetTop;", element,driver.findElement(shippingZone));
    }

    //Shipping
    public void openShippingModel() {
        scrollAndClick(shippingAddressTab);
    }

    public void entreShippingFirstName(String name) {
        driver.findElement(shippingFirstName).clear();
        driver.findElement(shippingFirstName).sendKeys(name);
    }
    public void enterShippingLastName(String name) {
        driver.findElement(shippingLastName).clear();
        driver.findElement(shippingLastName).sendKeys(name);
    }
    public void entreShippingAddress1(String name) {
        driver.findElement(shippingAddress1).clear();
        driver.findElement(shippingAddress1).sendKeys(name);
    }
    public void entreShippingCity(String name) {
        driver.findElement(shippingCity).clear();
        driver.findElement(shippingCity).sendKeys(name);
    }
    public void entreShippingCode(String name) {
        driver.findElement(shippingPostcode).clear();
        driver.findElement(shippingPostcode).sendKeys(name);
    }

    public void selectShippingCountry(String coun) {
        WebElement country=driver.findElement(shippingCountry);
        country.click();
        Select countryElement=new Select(country);
        countryElement.selectByVisibleText(coun);
    }
    public void selectShippingZone(String val)  {
        WebElement zone=driver.findElement(shippingZone);
        zone.click();
        Select zoneElement=new Select(zone);
        zoneElement.selectByVisibleText(val);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", zone);
        zone.sendKeys(Keys.TAB);

    }





    public void saveShippingData() {
        scrollAndClick(saveShippingBtn);
    }

    //Customer

    public void saveCutomerData() {
        driver.findElement(saveCustomerBtn).click();
    }

    public void closeModal() {
        scrollAndClick(closeBtn);
    }

    public void chooseImac(){
        driver.findElement(imacProduct).click();
    }

    public void openShippingMethodModel  () {
        scrollAndClick(shippingMethodTab);
    }

    public void openPaymentMethodModel() {
        scrollAndClick(paymentMethodTab);
    }
    public void selectShippingMethod() {
        driver.findElement(shippingMethod).click();
    }


    public void selectPaymentMethod() {
        driver.findElement(paymentMethod).click();
    }
    public void saveShippingMethod() {
        scrollAndClick(saveShippingMethodBtn);
    }

    public void savePaymentMethod() {
        scrollAndClick(savePaymentMethodBtn);
    }

    public void closeModalCompletely() {
        // 1. Try normal close first
        try {
            WebElement close = driver.findElement(
                    By.cssSelector("button[data-bs-dismiss='modal'], .btn-close, button.close")
            );
            if (close.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);
            }
        } catch (Exception ignored) {}

        // 2. FORCE REMOVE EVERYTHING (this is the nuclear option that always works)
        ((JavascriptExecutor) driver).executeScript(
                "var modals = document.querySelectorAll('.modal'); " +
                        "modals.forEach(m => {" +
                        "   m.classList.remove('show');" +
                        "   m.style.display = 'none';" +
                        "   m.removeAttribute('aria-modal');" +
                        "   m.setAttribute('aria-hidden', 'true');" +
                        "});" +
                        "document.querySelectorAll('.modal-backdrop').forEach(b => b.remove());" +
                        "document.body.classList.remove('modal-open');" +
                        "document.body.style.overflow = '';" +
                        "document.body.style.paddingRight = '';"
        );

        // 3. Small wait for stability
        try { Thread.sleep(400); } catch (Exception ignored) {}
    }

    public void confirmOrder(){
        scrollAndClick(confirmButton);
    }
    public void AssertInPage(){
        Assert.assertTrue(driver.findElement(addProductBtn).isDisplayed());
    }
    public void AssertCustomerFirstnameError(){
        Assert.assertTrue(driver.findElement(errorFirstName).isDisplayed());
    }
    public void AssertCustomerLastnameError(){
        Assert.assertTrue(driver.findElement(errorLasrName).isDisplayed());
    }
    public void AssertCustomerEmailnameError(){
        Assert.assertTrue(driver.findElement(errorEmail).isDisplayed());
    }
    public void AssertPaymentFirstnameError(){
        Assert.assertTrue(driver.findElement(errorPaymentFirstName).isDisplayed());
    }
    public void AssertPaymentLastnameError(){
        Assert.assertTrue(driver.findElement(errorPaymentLasrName).isDisplayed());
    }
    public void AssertPaymentAddress1Error(){
        Assert.assertTrue(driver.findElement(errorPaymentAddress1).isDisplayed());
    }
    public void AssertPaymentCityError(){
        Assert.assertTrue(driver.findElement(errorPaymentCity).isDisplayed());
    }


    public void AssertShippingFirstnameError(){
        Assert.assertTrue(driver.findElement(errorShippingFirstName).isDisplayed());
    }
    public void AssertShippingLastnameError(){
        Assert.assertTrue(driver.findElement(errorShippingLasrName).isDisplayed());
    }
    public void AssertShippingAddress1Error(){
        Assert.assertTrue(driver.findElement(errorShippingAddress1).isDisplayed());
    }
    public void AssertShippingCityError(){
        Assert.assertTrue(driver.findElement(errorShippingtCity).isDisplayed());
    }


    public void AssertSuccess(){
        Assert.assertTrue(driver.findElement(successAlert).isDisplayed());
    }
    public void AssertErrorAlert(){
        Assert.assertTrue(driver.findElement(errorAlert).isDisplayed());
    }

}
