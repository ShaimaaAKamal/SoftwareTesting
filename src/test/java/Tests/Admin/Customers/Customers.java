package Tests.Admin.Customers;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Customers.Customers_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.Orders.Orders_Page;
import Pages.Admin.Orders.Single_Order_Page;
import Tests.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Customers extends BaseTest {
    Admin_Login_Page login;
    Customers_Page customersPage;
    Dashboard_Page dashboard;

    @BeforeMethod
    public void preCondition(){
        customersPage = new Customers_Page(driver);
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



    @Test (priority = 0)
    public void AddNewCustomer() {
        customersPage.ClickOnAddNewCustomerButton();
        wait.until(ExpectedConditions.urlContains("customer.form"));
        customersPage.assertAddNewCustomer();
    }

    @Test (priority = 1)
    public void FilterCustomerData() throws InterruptedException {

        int count = customersPage.getCustomerCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterCustomerData() because no Customers exist.");
        }
        customersPage.EnterCustomerName("Su");
        customersPage.ClickFilterButton();
        Thread.sleep(1000);
        customersPage.assertFilterResult(count);
    }

    @Test (priority = 2)
    public void EditCustomerDetails(){
        int count = customersPage.getCustomerCount();

        if (count == 0) {
            throw new SkipException("Cannot run EditCustomerDetails() because no orders exist.");
        }
        customersPage.ClickOnEditIcon();
        wait.until(ExpectedConditions.urlContains("customer.form"));
        customersPage.assertNavigateToEditCustomerDetails();
    }

    @Test (priority = 3)
    public void DeleteCustomerData() {

        int count = customersPage.getCustomerCount();

        if (count == 0) {
            throw new SkipException("Cannot run EditCustomerDetails() because no orders exist.");
        }

        customersPage.ClickOnCheckBox();
        customersPage.DeleteCustomerData();
        driver.switchTo().alert().accept();
        waitForVisible(customersPage.successMessage);
        customersPage.assertDeleteMessageDisplayed();
        waitFoRInVisible(customersPage.successMessage);
    }

}