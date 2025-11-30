package Tests;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Auth.Register_Page;
import Pages.Home_Page;
import Pages.Wishlist_Page;
import jdk.jfr.Timestamp;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Home extends BaseTest {
    Home_Page homepage;
    Register_Page registerPage;
    Login_Page loginPage;
    Account_Page account;
    Wishlist_Page wishlistPage;
    @BeforeMethod
    public void precondition() {
        homepage = new Home_Page(driver);
        loginPage = new Login_Page(driver);
        account=new Account_Page(driver);
        wishlistPage=new Wishlist_Page(driver);
        driver.get(storeBaseUrl);
        waitForVisible(homepage.feature);
    }

    @Test (priority = 0)
    public void VerifyUserNavigateToRegistrationPage(){
        homepage.clickMyAccount();
        homepage.clickRegitser();
        waitForVisible(By.id("input-firstname"));
        registerPage = new Register_Page(driver);
        homepage.assertUserNavigateToRegistrationPage();
    }
    @Test (priority = 0)
    public void VerifyUserNavigateToLoginPage(){
        waitForVisible(homepage.feature);
        homepage.clickMyAccount();
        homepage.clickLogin();
        waitForVisible(By.linkText("Forgotten Password"));
        homepage.assertUserNavigateToLoginPage();
    }
    @Test (priority = 0)
    public void VerifyCurrencyChoicesDisplayedAndClickable(){
        homepage.CheckCurrencyDropDownMenu();
        waitForVisible(homepage.currency);
        homepage.assertCurrencyDropDownMenuDisplayed();
    }

    @Test (priority = 0)
    public void VerifyUserCanSelectPoundSterlingCurrency(){
        homepage.CheckCurrencyDropDownMenu();
        waitForVisible(homepage.currency);
        homepage.SelectPoundSterlingChoice();
        homepage.assertPoundSterlingIconDisplayed();
    }
    @Test (priority = 0)
    public void VerifyUserCanSelectUsDollarCurrency(){
        homepage.CheckCurrencyDropDownMenu();
        waitForVisible(homepage.currency);
        homepage.SelectUsDollarChoice();
        homepage.assertUsDollarIconDisplayed();
    }
    @Test (priority = 0)
    public void VerifyUserNavigateToContactUsPage(){
        homepage.ClickOnContactUsIcon();
        homepage.assertUserNavigateToContactUsForm();
    }
    @Test (priority = 0)
    public void VerifyGuestUserNavigateToWishListPage(){
        homepage.ClickOnWishListIcon();
        homepage.assertGuestUserNavigateToWishlistPage();
    }

    @Test (priority = 0)
    public void VerifyGuestUserNavigateToCartPage(){
        homepage.ClickOnShoppingCartIcon();
        homepage.assertUserNavigateToCartPage();
    }

    @Test (priority = 1)
    public void VerifyRegisteredUserNavigateToWishListPage(){
        homepage.ClickOnWishListIcon();
        loginPage.enterEmail(storeUserEmail);
        loginPage.enterPassword(storeUserPassword);
        loginPage.submitForm();
        waitForVisible(wishlistPage.pageTitle);
        homepage.assertRegisteredUserNavigateToWishListPage();
    }

    @Test (priority = 2)
    public void VerifyUserNavigateToCheckOutPage(){
        homepage.ClickOnCheckOutIcon();
        homepage.assertUserNavigateToCheckOutPage();
    }

    @Test (priority = 3)
    public void VerifyRegisteredUserNavigateToLogOutPage() {
        driver.get(storeBaseUrl);
        homepage.clickMyAccount();
        homepage.clickLogout();
        homepage.assertRegisteredUserLoggedOutSuccessfully();
    }

}