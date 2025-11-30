package Tests.Admin.Products;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.Products.Products_Page;
import Pages.Admin.Products.Single_Product_Page;
import Pages.Admin.System.Settings_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Products extends BaseTest {
    Settings_Page settingsPage;
    Products_Page products;
    Admin_Login_Page login;
    Dashboard_Page dashboard;
    @BeforeMethod
    public void Precondition() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        settingsPage = new Settings_Page(driver);
        login=new Admin_Login_Page(driver);
        dashboard=new Dashboard_Page(driver);
        driver.get(adminPanelBaseUrl);
        login.enterUsername(adminUsername);
        login.enterPassword(adminPassword);
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
        products = new Products_Page(driver);
        products.openCatalog();
        waitForVisible(products.productsSection);
        products.openProductSection();
        waitForVisible(products.pageTitle);
    }

    @AfterMethod
    public void after(){
        dashboard.clickLogout();
    }

    @Test(priority  =0)
    public void testOpenProductSection() {
        products.assertOpenProductScreen();
    }

    @Test(priority  =1)
    public void testClickAddNewButton() {
        products.clickAddNew();
        wait.until(ExpectedConditions.urlContains("product.form"));
        products.assertNavigateToNewProductScreen();
    }

    @Test(priority  =2)
    public void testFilterByName() throws InterruptedException {
        products.filterByName("iphone");
        wait.until(ExpectedConditions.urlContains("iphone"));
        products.assertFilterFunctions();
    }

    @Test(priority  =3)
    public void testSelectFirstProductCheckbox() {
        products.selectFirstProduct();
        products.assertFirstProductSelection();
    }

    @Test(priority  =4)
    public void testClickCopyProduct() {
        products.selectFirstProduct();
        products.clickCopy();
        waitForVisible(products.successAlert);
        products.assertSuccess();
        waitFoRInVisible(products.successAlert);
    }

    @Test(priority  =6)
    public void testClickDeleteProduct() {
        products.selectFirstProduct();
        products.clickDelete();
        waitForVisible(products.successAlert);
        products.assertSuccess();
        waitFoRInVisible(products.successAlert);

    }

    @Test(priority  =5)
    public void testOpenFirstProductForEdit() {
        products.openFirstProductForEdit();
        wait.until(ExpectedConditions.urlContains("product.form"));
        products.assertOpenEdit();
    }

}