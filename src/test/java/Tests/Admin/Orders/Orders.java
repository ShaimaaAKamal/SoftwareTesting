package Tests.Admin.Orders;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.Orders.Orders_Page;
import Pages.Admin.Orders.Single_Order_Page;
import Pages.Admin.System.Settings_Page;
import Tests.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Orders extends BaseTest {
     Orders_Page orders;
     Admin_Login_Page login;
     Dashboard_Page dashboard;
    Single_Order_Page order;
    @BeforeMethod
    public void Precondition(){
        orders = new Orders_Page(driver);
        login=new Admin_Login_Page(driver);
        dashboard=new Dashboard_Page(driver);
        order=new Single_Order_Page(driver);
        driver.get("http://localhost:8888/opencartDemo/myadminpanel");
        login.enterUsername("admin");
        login.enterPassword("admin");
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
        orders.clickSales();
        waitForVisible(orders.Orders);
        orders.clickOrders();
        waitForVisible(orders.pageTitle);
    }

    @AfterMethod
    public void after(){
        dashboard.clickLogout();
    }

    @Test(priority = 0)
    public void assertOrdersPage(){
       orders.assertAdminOrdersPage();
    }

    @Test(priority = 0)
    public void assertEmptyOrders(){
        if (orders.getOrderCount() != 1) {
            throw new SkipException("Skipping: Orders exist in the table.");
        }
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void navigateToAddNewOrder(){
         orders.clickAddNewIcon();
        wait.until(ExpectedConditions.urlContains("order.info"));
        order.AssertInPage();
    }




}
