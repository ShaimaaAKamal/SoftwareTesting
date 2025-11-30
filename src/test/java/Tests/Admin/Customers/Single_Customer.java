package Tests.Admin.Customers;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Customers.Customers_Page;
import Pages.Admin.Customers.Single_Customer_Page;
import Pages.Admin.Dashboard_Page;
import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Single_Customer extends BaseTest {
    Admin_Login_Page login;
    Single_Customer_Page singleCustomer;
    Dashboard_Page dashboard;
    Customers_Page customersPage;
    @BeforeMethod
    public void preCondition(){
        singleCustomer= new Single_Customer_Page(driver);
        customersPage=new Customers_Page(driver);
        login=new Admin_Login_Page(driver);
        dashboard=new Dashboard_Page(driver);
        driver.get(adminPanelBaseUrl);
        login.enterUsername(adminUsername);
        login.enterPassword(adminPassword);
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
        customersPage.ClickCustomersDropdown();
        waitForVisible(customersPage.Select_Customer_Button);
        customersPage.SelectCustomerButton();
        waitForVisible(customersPage.pageTitle);
    }

    @AfterMethod
    public void TierDown(){
        dashboard.clickLogout();
    }

    @Test(priority = 0)
    public void AddNewCustomerData() {
        customersPage.ClickOnAddNewCustomerButton();
        wait.until(ExpectedConditions.urlContains("customer.form"));
        singleCustomer.EnterCustomerFirstName("sara");
        singleCustomer.EnterCustomerLastName("h");
        singleCustomer.EnterEmail();
        singleCustomer.EnterPassword("1234567");
        singleCustomer.EnterConfirmPassword("1234567");
        singleCustomer.ClickOnSaveButton();
        waitForVisible(singleCustomer.successMessage);
        singleCustomer.assertSuccessDisplayModifyMessage();
    }

    @Test(priority = 1)
    public void AddNewCustomerDataWithINCorrectEmailForm() {
        customersPage.ClickOnAddNewCustomerButton();
        wait.until(ExpectedConditions.urlContains("customer.form"));
        singleCustomer.EnterCustomerFirstName("sara");
        singleCustomer.EnterCustomerLastName("h");
        singleCustomer.EnterPassword("1234567");
        singleCustomer.EnterConfirmPassword("1234567");
        singleCustomer.ClickOnSaveButton();
        waitForVisible(singleCustomer.errorMessage);
        singleCustomer.assertdErrorDisplayed();
        waitFoRInVisible(singleCustomer.errorMessage);
        waitForVisible(singleCustomer.mailError);
        singleCustomer.assertMailErrorDisplayed();
    }
    @Test(priority = 2)
    public void AddNewCustomerDataWithINCorrectPasswordForm() {
        customersPage.ClickOnAddNewCustomerButton();
        wait.until(ExpectedConditions.urlContains("customer.form"));
        singleCustomer.EnterCustomerFirstName("sara");
        singleCustomer.EnterCustomerLastName("h");
        singleCustomer.EnterEmail();
        singleCustomer.EnterPassword("25dd");
        singleCustomer.EnterConfirmPassword("25dd");
        singleCustomer.ClickOnSaveButton();
        waitForVisible(singleCustomer.errorMessage);
        singleCustomer.assertdErrorDisplayed();
        waitFoRInVisible(singleCustomer.errorMessage);
        waitForVisible(singleCustomer.passwordError);
        singleCustomer.assertPasswordErrorDisplayed();
    }
    @Test(priority = 3)
    public void AddNewCustomerDataPasswordAndConfirmationPasswordDoesNotMatch() {
        customersPage.ClickOnAddNewCustomerButton();
        wait.until(ExpectedConditions.urlContains("customer.form"));        singleCustomer.EnterCustomerFirstName("sara");
        singleCustomer.EnterCustomerLastName("h");
        singleCustomer.EnterEmail();
        singleCustomer.EnterPassword("1234567");
        singleCustomer.EnterConfirmPassword("1234");
        singleCustomer.ClickOnSaveButton();
        waitForVisible(singleCustomer.errorMessage);
        singleCustomer.assertdErrorDisplayed();
        waitFoRInVisible(singleCustomer.errorMessage);
        waitForVisible(singleCustomer.confirmPasswordError);
        singleCustomer.assertConfirmPasswordErrorDisplay();
    }
    @Test(priority = 4)
    public void AddTransactionForRegisteredCustomer() {
        customersPage.ClickOnEditIcon();
        waitForVisible(singleCustomer.Customer_First_Name);
        singleCustomer.ClickOnTransactionButton();
        waitForVisible(singleCustomer.Transaction_Description);
        singleCustomer.EnterTransactionDetails("Iphone", "3");
        singleCustomer.addTransaction();
        waitForVisible(singleCustomer.successMessage);
        singleCustomer.assertSuccessModifyMessageDisplay();
        singleCustomer.ClickOnSaveButton();
        waitForVisible(singleCustomer.successMessage);
        singleCustomer.assertSuccessModifyMessageDisplay();
    }

    @Test(priority = 5)
    public void EditCustomerData() {
        customersPage.ClickOnEditIcon();
        waitForVisible(singleCustomer.Customer_First_Name);
        singleCustomer.ClearCustomerLastName();
        singleCustomer.EditCustomerLastName("T");
        singleCustomer.ClickOnSaveButton();
        waitForVisible(singleCustomer.successMessage);
        singleCustomer.assertSuccessDisplayModifyMessage();
    }
}