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
        driver.get("http://localhost/opencart");
        home = new Home_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login = new Login_Page(driver);
        login.enterEmail("admin@gmail.com");
        login.enterPassword("admin1234");
        login.submitForm();
        account = new Account_Page(driver);
        waitForVisible(account.editInformation);
//        account.navigateToHomePage();
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.linkText("iPhone"))).perform();
        singleProduct = new Single_Product_Page(driver);
        singleProduct.productPage();
    }


    @Test (priority = 1)
    public void verifyProductTitle() {
        String title = singleProduct.getProductTitle();
        System.out.println("Product Title is : " + title);
    }

    @Test (priority = 1)
    public void verifyProductPrice() {
        String price = singleProduct.getProductPrice();
        System.out.println("Product Price is : " + price);
    }

    @Test (priority = 2)
    public void addToWishList() {
        singleProduct.addToWishList();
    }

    @Test (priority = 2)
    public void verifyAddToWishListSuccessMsg() {
        singleProduct.addToWishList();
        waitForVisible(singleProduct.wishListSuccessMsg);
        singleProduct.assertWishListSuccess();
    }





}