package Pages.Admin.Orders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Single_Order_Page {
    WebDriver driver;
//    By addpProductbtn=By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tfoot[1]/tr[1]/td[2]/button[1]");
//    By productQty=By.xpath("//input[@id='input-quantity']");
//    By saveBtn=By.id("button-product-add");

    // ---------- BUTTONS ----------
    public By addOrderBtn = By.cssSelector("a[data-bs-original-title='Add New']");
    public By saveBtn = By.cssSelector("button[form='form-order'][type='submit']");
    public By cancelBtn = By.cssSelector("a.btn.btn-light");
    By closeBtn=By.cssSelector(".btn-close");
    // ---------- CUSTOMER TAB ----------
    public By customerTab = By.xpath("//button[@data-bs-target='#modal-customer']");
    public By inputCustomer = By.id("input-customer");
     By inputFirstName = By.id("input-firstname");
     By inputLastName = By.id("input-lastname");
     By inputEmail = By.id("input-email");
     By inputTelephone = By.id("input-telephone");
    public By errorFirstName=By.id("error-firstname");
    public By errorLasrName=By.id("error-lastname");
    public By errorEmail=By.id("error-email");
    By saveCustomerBtn = By.id("button-customer");
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

    // ---------- PRODUCTS ----------
    public By saveProduct = By.id("button-product-add");
    public By inputProduct = By.id("input-product");
    public By productQty=By.id("input-quantity");
    public By addProductBtn =By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tfoot[1]/tr[1]/td[2]/button[1]");

    // ---------- TOTALS ----------
    public By totalsTab = By.cssSelector("a[href='#tab-total']");
    public By shippingMethod = By.id("input-shipping-method");
    public By paymentMethod = By.id("input-payment-method");

    // ---------- HISTORY ----------
    public By historyTab = By.cssSelector("a[href='#tab-history']");
    public By orderStatus = By.id("input-order-status");
    public By addHistoryBtn = By.id("button-history");

    // ---------- SUCCESS MESSAGE ----------
    public By successAlert = By.cssSelector(".alert-success");
    By errorAlert=By.cssSelector(".alert-danger");
    public Single_Order_Page(WebDriver driver){
        this.driver=driver;
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
        driver.findElement(saveProduct).click();
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
    public void selectPaymentZone(String val) {
        WebElement zone=driver.findElement(paymentZone);
        zone.click();
        Select zoneElement=new Select(zone);
        zoneElement.selectByVisibleText(val);
    }
    public void savePaymentData() {
     scrollAndClick(savePaymentBtn);
    }

    public void scrollAndClick(By locator){
        WebElement button = driver.findElement(locator);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // Add small delay to ensure layout stabilizes
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        // Click using JS to bypass overlays
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
    public void saveCutomerData() {
        driver.findElement(saveCustomerBtn).click();
    }

    public void closeModal() {
        scrollAndClick(closeBtn);
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

    public void AssertSuccess(){
        Assert.assertTrue(driver.findElement(successAlert).isDisplayed());
    }
}
