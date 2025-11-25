package Tests.Products;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Pages.Products.Single_Product_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Single_Product extends BaseTest {
    Login_Page login;
    Home_Page home;
    Account_Page account;
    Single_Product_Page singleProduct;

    @BeforeMethod
    public void preCondition() {
        driver.get("http://localhost:8888/opencartDemo/");
        home = new Home_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login = new Login_Page(driver);
        account = new Account_Page(driver);
        singleProduct = new Single_Product_Page(driver);
        login.enterEmail("tete@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();
        waitForVisible(account.editInformation);
        account.clickLogo();
        waitForVisible(home.feature);
        singleProduct.ClickProduct(By.xpath("//a[text()='iPhone']"));
        waitForVisible(singleProduct.productTitle);
    }

    @AfterMethod
    public void after(){
        driver.get("http://localhost:8888/opencartDemo/");
        home.clickMyAccount();
        home.clickLogout();
    }


    @Test (priority = 1)
    public void verifyProductTitle() {
        singleProduct.asserProductTitle();
    }

    @Test (priority = 1)
    public void verifyProductPrice() {
        singleProduct.asserProductPrice();

    }

    @Test (priority = 2)
    public void addToWishList() {
        singleProduct.addToWishList();
        waitForVisible(singleProduct.wishListSuccessMsg);
        singleProduct.assertWishListSuccess();
    }






}