package Pages.Admin.Customers;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Single_Customer_Page {
    WebDriver driver;

    // Constructor //
    public Single_Customer_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators //
    By Customers_Dropdown = By.xpath("//a[@href=\"#collapse-6\"]");
    By Select_Customer_Button = By.xpath("//a[@href=\"http://localhost:8080/opencart/admin123/index.php?route=customer/customer&user_token=6951c9375615d945fb89f9ae44fc6313\"]");
    By AddNew_Button = By.xpath("//a[@aria-label=\"Add New\"]");
    public By Customer_First_Name = By.id("input-firstname");
    By Customer_Last_Name = By.id("input-lastname");
    By Email_Input = By.id("input-email");
    By Password_Input = By.id("input-password");
    By Confirm_Password_Input = By.id("input-confirm");
    By Save_Button = By.id("button-save");
    //    By Back_Button =By.xpath("//a[@class=\"btn btn-light\"]");
    By Transaction_Button = By.xpath("//a[@href=\"#tab-transaction\"]");
   public By Transaction_Description = By.name("description");
    By Transaction_Amount = By.name("amount");
    By Edit_Icon = By.xpath("//a[@aria-label=\"Edit\"]");
    By Logout_Button = By.xpath("//a[@class=\"nav-link\"]");
    public By successMessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By errorMessage=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    public By firstnameError=By.id("error-firstname");
    public By lastnameError=By.id("error-lastname");
    public By mailError=By.id("error-email");
    public By passwordError=By.id("error-password");
    public By confirmPasswordError=By.id("error-confirm");
    By add_Transaction_Amount= By.xpath("//button[@id='button-transaction']");
    Faker faker = new Faker();

    public String generateFakeEmail() {
        return faker.internet().emailAddress();
    }
    //  Actions //
    public void ClickCustomersDropdown() {
        driver.findElement(Customers_Dropdown).click();
    }

    public void SelectCustomerButton() {
        driver.findElement(Select_Customer_Button).click();
    }

    public void ClickOnAddNewCustomerButton() {
        driver.findElement(AddNew_Button).click();
    }

    public void EnterCustomerFirstName(String CustomerFirstName) {
        driver.findElement(Customer_First_Name).sendKeys(CustomerFirstName);
    }

    public void EnterCustomerLastName(String CustomerLastName) {
        driver.findElement(Customer_Last_Name).sendKeys(CustomerLastName);
    }

    public void ClearCustomerLastName() {
        driver.findElement(Customer_Last_Name).clear();
    }

    public void EnterEmail() {
        String mail=generateFakeEmail();
        driver.findElement(Email_Input).sendKeys(mail);
    }

    public void EnterPassword(String password) {
        driver.findElement(Password_Input).sendKeys(password);
    }

    public void EnterConfirmPassword(String ConfirmPassword) {
        driver.findElement(Confirm_Password_Input).sendKeys(ConfirmPassword);
    }

    public void ClickOnSaveButton() {
        driver.findElement(Save_Button).click();
    }


    public void ClickOnTransactionButton() {
        driver.findElement(Transaction_Button).click();
    }

    public void EnterTransactionDetails(String Description, String Amount) {
        driver.findElement(Transaction_Description).sendKeys(Description);
        driver.findElement(Transaction_Amount).sendKeys(Amount);
    }


    public void addTransaction(){
        driver.findElement(add_Transaction_Amount).click();
    }
    public void ClickOnEditIcon() {
        driver.findElement(Edit_Icon).click();
    }

    public void EditCustomerLastName(String CustomerLastName) {
        driver.findElement(Customer_Last_Name).clear();
        driver.findElement(Customer_Last_Name).sendKeys(CustomerLastName);
    }
    public void ClickOnLogoutButton(){
        driver.findElement(Logout_Button).click();
    }


    // Assertion //
    public void assertSuccessDisplayModifyMessage() {
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
    }

    public void assertFirstNameErrorDisplayed(){
        Assert.assertTrue(driver.findElement(firstnameError).isDisplayed());
    }
    public void assertLastNameErrorDisplayed(){
        Assert.assertTrue(driver.findElement(lastnameError).isDisplayed());
    }
    public void assertMailErrorDisplayed(){
        Assert.assertTrue(driver.findElement(mailError).isDisplayed());
    }
    public void assertPasswordErrorDisplayed(){
        Assert.assertTrue(driver.findElement(passwordError).isDisplayed());
    }
    public void assertdErrorDisplayed(){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
    }
    public void assertWarningMessageDisplay() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).isDisplayed());
    }

    public void assertValidationErrorDisplay() {
        Assert.assertTrue(driver.findElement(By.id("error-password")).isDisplayed());
    }

    public void assertConfirmPasswordErrorDisplay() {
        Assert.assertTrue(driver.findElement(confirmPasswordError).isDisplayed());
    }

    public void assertErrorMessageWhenPasswordDoesNotMatch() {
        Assert.assertTrue(driver.findElement(By.id("error-confirm")).isDisplayed());
    }

    public void assertSuccessModifyMessageDisplay() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
    }
}