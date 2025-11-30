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
        driver.get(storeBaseUrl);
        home = new Home_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login = new Login_Page(driver);
        account = new Account_Page(driver);
        singleProduct = new Single_Product_Page(driver);
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(account.editInformation);
        account.clickLogo();
        waitForVisible(home.feature);
        singleProduct.ClickProduct(By.xpath("//a[text()='iPhone']"));
        waitForVisible(singleProduct.productTitle);
    }

    @AfterMethod
    public void after(){
        driver.get("http://localhost:8888/opencart/");
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


    @Test (priority = 1)
    public void compareProduct() {
        singleProduct.compareProduct();
    }

    @Test (priority = 1)
    public void addToCartButton() {
        singleProduct.addToCart();
    }

    @Test (priority = 1)
    public void assertATCSuccessMsgWhenEditProductQuantity() {
        singleProduct.editQuantity(2);
        singleProduct.addToCart();
        waitForVisible(singleProduct.aTCSuccessMsg);
        singleProduct.assertATCSuccess();
    }

    @Test (priority = 1)
    public void assertNoATCSuccessMsgForZeroQuantity() {
        singleProduct.editQuantity(0);
        singleProduct.addToCart();
        waitForVisible(singleProduct.aTCEAlert);
        singleProduct.assertATCError();

    }

    @Test (priority = 2)
    public void addReview() {
        singleProduct.reviews();
        singleProduct.review_YourName("Test");
        singleProduct.review_YourReview("Test111111111111111111");
        singleProduct.rateRadioBtn();
        singleProduct.continueBtn();
    }


    @Test (priority = 2)
    public void addToWishList() {
        singleProduct.addToWishList();
        waitForVisible(singleProduct.wishListSuccessMsg);
        singleProduct.assertWishListSuccess();
    }






}





