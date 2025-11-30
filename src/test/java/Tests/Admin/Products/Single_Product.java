package Tests.Admin.Products;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.Orders.Orders_Page;
import Pages.Admin.Orders.Single_Order_Page;
import Pages.Admin.Products.Products_Page;
import Pages.Admin.Products.Single_Product_Page;
import Pages.Admin.System.Settings_Page;
import Tests.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Single_Product extends BaseTest {
    Settings_Page settingsPage;
    Single_Product_Page singleProduct;
    Products_Page products;
    Admin_Login_Page login;
    Dashboard_Page dashboard;

    @BeforeMethod
    public void Precondition() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        settingsPage = new Settings_Page(driver);
        driver.get(adminPanelBaseUrl);
        products = new Products_Page(driver);
        singleProduct = new Single_Product_Page(driver);
        dashboard=new Dashboard_Page(driver);

        login=new Admin_Login_Page(driver);
        login.enterUsername(adminUsername);
        login.enterPassword(adminPassword);
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
        products.openCatalog();
        waitForVisible(products.productsSection);
        products.openProductSection();
        waitForVisible(products.pageTitle);
        products.clickAddNew();
        wait.until(ExpectedConditions.urlContains("product.form"));
    }

    @AfterMethod
    public void after(){
        dashboard.clickLogout();
    }


    @Test(priority = 0)
    public void testEnterProductNameAndMetaTitle() {
        singleProduct.enterProductName("Test Product");
        singleProduct.enterMetaTitle("Test Meta Title");
       singleProduct.assertName();
    }

    @Test(priority = 0)
    public void testEnterDescription() {
        singleProduct.enterDescription("This is a test description.");
        driver.switchTo().frame(driver.findElement(singleProduct.descriptionIframe));
        String desc = driver.findElement(singleProduct.descriptionBody).getText();
        driver.switchTo().defaultContent();
        singleProduct.assertDescription(desc);
    }

    @Test(priority = 0)
    public void testEnterDataTabFields() {
        singleProduct.openDataTab();
        singleProduct.enterModel("TP-001");
        singleProduct.enterPrice("99.99");
        singleProduct.enterQuantity("10");
        singleProduct.assertDataFields();
    }

    @Test(priority = 1)
    public void testClickSaveButton() {
        singleProduct.clickSave();
        waitForVisible(singleProduct.errorAlert);
        singleProduct.assertError();
        waitForVisible(singleProduct.errorAlert);

    }

    @Test(priority = 2)
    public void addNewProduct() {
        singleProduct.enterProductName("Test Product");
        singleProduct.enterMetaTitle("Test Meta Title");
        singleProduct.enterDescription("This is a test description.");
        singleProduct.openSEOab();
        singleProduct.enterSeoData("fwfe");
        singleProduct.openDataTab();
        singleProduct.enterModel("TP-001");
        singleProduct.enterPrice("99.99");
        singleProduct.enterQuantity("10");
        singleProduct.clickSave();
        waitForVisible(singleProduct.successAlert);
        singleProduct.assertSuccess();
        waitForVisible(singleProduct.successAlert);
    }
}