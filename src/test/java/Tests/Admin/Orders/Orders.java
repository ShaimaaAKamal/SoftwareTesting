package Tests.Admin.Orders;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.Orders.Orders_Page;
import Pages.Admin.Orders.Single_Order_Page;
import Pages.Admin.System.Settings_Page;
import Tests.BaseTest;
import net.datafaker.providers.entertainment.TheExpanse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    @Test(priority = 0)
    public void FilterOrderByOrderId() throws InterruptedException {
        int orderCount=orders.getOrderCount();
        String OrderId=orders.getOrderfirstId();
        orders.enterOrderIdFilter(OrderId);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertOrderIDfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderByNonExisingOrderId() throws InterruptedException {
        orders.enterOrderIdFilter("-1");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void FilterOrderByExsitingCustomer() throws InterruptedException {
//        int orderCount=orders.getOrderCount();
        String customerName=(orders.getOrderData(0)).get(2);
        orders.enterCustomerFilter(customerName);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertCustomerfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderByNonExisingCustomer() throws InterruptedException {
        orders.enterCustomerFilter("NONE");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void FilterOrderByExsitingTotal() throws InterruptedException {
        String orderTotal=(orders.getOrderData(0)).get(4);
        orders.enterTotalFilter(orderTotal);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertTotalfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderByInvalidTotall() throws InterruptedException {
        orders.enterTotalFilter("%%%%%");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }



    @Test(priority = 0)
    public void FilterOrderByOrderStatus() throws InterruptedException {
        String status=(orders.getOrderData(0)).get(3);
        orders.selectOrderStatus(status);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertStatusfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderBynonExisingOrderStatus() throws InterruptedException {
        int count=orders.getOrderCount();
        orders.selectOrderStatus("");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertAllTablesData(count);
    }

    @Test(priority = 0)
    public void FilterOrderByStore() throws InterruptedException {
        orders.selectStore("Default");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertStatusfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderBynonExistingStore() throws InterruptedException {
        int count=orders.getOrderCount();
        orders.selectStore("");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertAllTablesData(count);
    }



    @Test(priority = 0)
    public void selectWithValidDate() throws InterruptedException {
        int count=orders.getOrderCount();
        orders.selectDateFrom("2025-11-26");
        orders.selectDateTo("2025-11-26");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertAllTablesData(count);
    }

    @Test(priority = 0)
    public void selectWithInvalidFutureDate() throws InterruptedException {
        orders.selectDateFrom("2026-11-26");
        orders.selectDateTo("2026-11-26");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void selectWithInvalidDateFirmat() throws InterruptedException {
        orders.selectDateFrom("2026-1126");
        orders.selectDateTo("2026-1126");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }






}
