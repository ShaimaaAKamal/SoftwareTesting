package Tests.Admin.Orders;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.Orders.Orders_Page;
import Pages.Admin.Orders.Single_Order_Page;
import Tests.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Single_Order extends BaseTest {
    Orders_Page orders;
    Admin_Login_Page login;
    Dashboard_Page dashboard;
    Single_Order_Page order;

    @BeforeMethod
    public void Precondition() {
        orders = new Orders_Page(driver);
        login = new Admin_Login_Page(driver);
        dashboard = new Dashboard_Page(driver);
        order = new Single_Order_Page(driver);
        driver.get("http://localhost:8888/opencartDemo/myadminpanel");
        login.enterUsername("admin");
        login.enterPassword("admin");
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
        orders.clickSales();
        waitForVisible(orders.Orders);
        orders.clickOrders();
        waitForVisible(orders.pageTitle);
        orders.clickAddNewIcon();
        waitForVisible(order.addProductBtn);
    }

    @AfterMethod
    public void after() {
        order.closeModal();
        waitForVisible(order.customerTab);
        dashboard.clickLogout();
    }

    @Test(priority = 0)
    public void cutomerDataWithEmptyFirstName() {
        driver.findElement(order.customerTab).click();
        waitForVisible(order.inputCustomer);
        order.enterFirstName("");
        order.enterLastName("Kamal");
        order.enterTelephone("01020414320");
        order.enterEmail("tete@gmail.com");
        order.saveCutomerData();
        waitForVisible(order.errorFirstName);
        order.AssertCustomerFirstnameError();
//        order.closeModal();
//        waitForVisible(order.customerTab);
    }

    @Test(priority = 0)
    public void cutomerDataWithEmptyLASTName() {
        driver.findElement(order.customerTab).click();
        waitForVisible(order.inputCustomer);
        order.enterFirstName("Shaimaa");
        order.enterLastName("");
        order.enterTelephone("01020414320");
        order.enterEmail("tete@gmail.com");
        order.saveCutomerData();
        waitForVisible(order.errorLasrName);
        order.AssertCustomerLastnameError();
//        order.closeModal();
//        waitForVisible(order.customerTab);
    }

    @Test(priority = 0)
    public void cutomerDataWithEmptEmail() {
        driver.findElement(order.customerTab).click();
        waitForVisible(order.inputCustomer);
        order.enterFirstName("Shaimaa");
        order.enterLastName("kamal");
        order.enterTelephone("01020414320");
        order.enterEmail("");
        order.saveCutomerData();
        waitForVisible(order.errorEmail);
        order.AssertCustomerEmailnameError();
//        order.closeModal();
//        waitForVisible(order.customerTab);
    }

    @Test(priority = 0)
    public void cutomerDataAllEmpty() {
        driver.findElement(order.customerTab).click();
        waitForVisible(order.inputCustomer);
        order.enterFirstName("");
        order.enterLastName("");
        order.enterTelephone("01020414320");
        order.enterEmail("");
        order.saveCutomerData();
        waitForVisible(order.errorFirstName);
        order.AssertCustomerEmailnameError();
        order.AssertCustomerLastnameError();
        order.AssertCustomerFirstnameError();
//        order.closeModal();
//        waitForVisible(order.customerTab);
    }


    @Test(priority = 1)
    public void fullCutomerData() {
        driver.findElement(order.customerTab).click();
        waitForVisible(order.inputCustomer);
        order.enterFirstName("Shaimaa");
        order.enterLastName("Kamal");
        order.enterTelephone("01020414320");
        order.enterEmail("tete@gmail.com");
        order.saveCutomerData();
        waitForVisible(order.successAlert);
        order.AssertSuccess();
//        order.closeModal();
//        waitForVisible(order.customerTab);
    }

    @Test(priority = 2)
    public void fillPaymentAddressWithEmptyFirstName() {
        order.openPaymentModel();
        waitForVisible(order.paymentFirstName);
        order.entrePaymentFirstName("");
        order.enterPaymentLastName("Doe");
        order.entrePaymentAddress1("Street 1");
        order.entrePaymentCity("Cairo 1");
        order.entrePaymentCode("12345");
        order.selectPaymentCountry("Egypt");
        order.selectPaymentZone("Ad Daqahliyah");
        waitForVisible(order.savePaymentBtn);
        order.savePaymentData();
        waitForVisible(order.errorPaymentFirstName);
        order.AssertPaymentFirstnameError();
    }
    @Test(priority = 2)
    public void fillPaymentAddressWithEmptyLastName() {
        order.openPaymentModel();
        waitForVisible(order.paymentFirstName);
        order.entrePaymentFirstName("John");
        order.enterPaymentLastName("");
        order.entrePaymentAddress1("Street 1");
        order.entrePaymentCity("Cairo 1");
        order.entrePaymentCode("12345");
        order.selectPaymentCountry("Egypt");
        order.selectPaymentZone("Ad Daqahliyah");
        waitForVisible(order.savePaymentBtn);
        order.savePaymentData();
        waitForVisible(order.errorPaymentLasrName);
        order.AssertPaymentLastnameError();
    }
    @Test(priority = 2)
    public void fillPaymentAddressWithCity() {
        order.openPaymentModel();
        waitForVisible(order.paymentFirstName);
        order.entrePaymentFirstName("John");
        order.enterPaymentLastName("Doe");
        order.entrePaymentAddress1("Street 1");
        order.entrePaymentCity("");
        order.entrePaymentCode("12345");
        order.selectPaymentCountry("Egypt");
        order.selectPaymentZone("Ad Daqahliyah");
        waitForVisible(order.savePaymentBtn);
        order.savePaymentData();
        waitForVisible(order.errorPaymentCity);
        order.AssertPaymentCityError();
    }
    @Test(priority = 2)
    public void fillPaymentAddressWithEmptyAddress1() {
        order.openPaymentModel();
        waitForVisible(order.paymentFirstName);
        order.entrePaymentFirstName("John");
        order.enterPaymentLastName("Doe");
        order.entrePaymentAddress1("");
        order.entrePaymentCity("Cairo-1");
        order.entrePaymentCode("12345");
        order.selectPaymentCountry("Egypt");
        order.selectPaymentZone("Ad Daqahliyah");
        waitForVisible(order.savePaymentBtn);
        order.savePaymentData();
        waitForVisible(order.errorPaymentAddress1);
        order.AssertPaymentAddress1Error();
    }

    @Test(priority = 3)
    public void fillPaymentAddress() {
        order.openPaymentModel();
        waitForVisible(order.paymentFirstName);
        order.entrePaymentFirstName("John");
        order.enterPaymentLastName("Doe");
        order.entrePaymentAddress1("Street 1");
        order.entrePaymentCity("Cairo 1");
        order.entrePaymentCode("12345");
        order.selectPaymentCountry("Egypt");
        order.selectPaymentZone("Ad Daqahliyah");
        order.savePaymentData();
        waitForVisible(order.successAlert);
        order.AssertSuccess();
    }

    @Test(priority = 4)
    public void AddProduct() {
        order.openProductModel();
        waitForVisible(order.inputProduct);
        order.enterProductName("iphone");
        order.enterProductQty("2");
        order.saveProdut();
        waitForVisible(order.successAlert);
        order.AssertSuccess();
    }

}
