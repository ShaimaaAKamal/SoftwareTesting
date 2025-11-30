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
        driver.get(adminPanelBaseUrl);
        login.enterUsername(adminUsername);
        login.enterPassword(adminPassword);
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
        if (orders.getOrderCount() != 0) {
            throw new SkipException("Skipping: Orders exist in the table.");
        }
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void navigateToAddNewOrder(){
         orders.clickAddNewIcon();
        wait.until(ExpectedConditions.urlContains("order.info"));
//        order.AssertInPage();
    }

    @Test(priority = 0)
    public void FilterOrderByOrderId() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByOrderId() because no orders exist.");
        }
        String OrderId=orders.getOrderfirstId();
        orders.enterOrderIdFilter(OrderId);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertOrderIDfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderByNonExisingOrderId() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByNonExisingOrderId() because no orders exist.");
        }
        orders.enterOrderIdFilter("-1");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void FilterOrderByExsitingCustomer() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByExsitingCustomer() because no orders exist.");
        }
        String customerName=(orders.getOrderData(0)).get(2);
        orders.enterCustomerFilter(customerName);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertCustomerfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderByNonExisingCustomer() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByNonExisingCustomer() because no orders exist.");
        }
        orders.enterCustomerFilter("NONE");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void FilterOrderByExsitingTotal() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByExsitingTotal() because no orders exist.");
        }
        String orderTotal=(orders.getOrderData(0)).get(4);
        orders.enterTotalFilter(orderTotal);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertTotalfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderByInvalidTotall() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByExsitingTotal() because no orders exist.");
        }
        orders.enterTotalFilter("%%%%%");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void assertShippingIconisNotClickable() throws InterruptedException {
        orders.assertShippingIconisNotClickable();
    }


    @Test(priority = 0)
    public void assertPrintInvoiceIconisNotClickable() throws InterruptedException {
        orders.assertPrintInvoiceIconisNotClickable();
    }

    @Test(priority = 0)
    public void FilterOrderByOrderStatus() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByOrderStatus() because no orders exist.");
        }
        String status=(orders.getOrderData(0)).get(3);
        orders.selectOrderStatus(status);
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertStatusfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderBynonExisingOrderStatus() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderBynonExisingOrderStatus() because no orders exist.");
        }
        orders.selectOrderStatus("");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertAllTablesData(count);
    }

    @Test(priority = 0)
    public void FilterOrderByStore() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderByStore() because no orders exist.");
        }
        orders.selectStore("Default");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertStatusfILTEResult();
    }

    @Test(priority = 0)
    public void FilterOrderBynonExistingStore() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run FilterOrderBynonExistingStore() because no orders exist.");
        }
        orders.selectStore("");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertAllTablesData(count);
    }



    @Test(priority = 0)
    public void selectWithValidDate() throws InterruptedException {

        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run selectWithValidDate() because no orders exist.");
        }
        orders.selectDateFrom("2025-11-26");
        orders.selectDateTo("2025-11-26");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertAllTablesData(count);
    }

    @Test(priority = 0)
    public void selectWithInvalidFutureDate() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run selectWithInvalidFutureDate() because no orders exist.");
        }
        orders.selectDateFrom("2026-11-26");
        orders.selectDateTo("2026-11-26");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }

    @Test(priority = 0)
    public void selectWithInvalidDateFirmat() throws InterruptedException {
        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run selectWithInvalidDateFirmat() because no orders exist.");
        }
        orders.selectDateFrom("2026-1126");
        orders.selectDateTo("2026-1126");
        orders.clickFilterBtn();
        Thread.sleep(1000);
        orders.assertEmptyOrders();
    }
    @Test(priority = 1)
    public void viewOrderIcon() {

        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run viewOrderIcon() because no orders exist.");
        }
        orders.clickViewButton(0);
        wait.until(ExpectedConditions.urlContains("order.info"));
//        order.AssertInPage();
    }

    @Test(priority = 2)
    public void deleteOrder() {

        int count = orders.getOrderCount();

        if (count == 0) {
            throw new SkipException("Cannot run DeleteOrder() because no orders exist.");
        }
        orders.selectOrderCheckbox(0);
        orders.clickDeleteIcon();
        waitForVisible(orders.successMessage);
        order.AssertSuccess();
        orders.setCloseBtn();
        waitFoRInVisible(orders.successMessage);
    }

}
