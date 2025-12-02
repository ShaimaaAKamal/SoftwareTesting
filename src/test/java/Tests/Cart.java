package Tests;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Cart_Page;
import Pages.Checkout_Page;
import Pages.Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static CucumberTests.stepDefinitions.Base.waitForVisible;


public class Cart extends BaseTest {
    Login_Page loginPage;
    Cart_Page cartPage;
    Account_Page account;
    Home_Page home;
    Checkout_Page checkout;
    @BeforeMethod
    public void precondition() {
        driver.get(storeBaseUrl);
        loginPage = new Login_Page(driver);
        cartPage = new Cart_Page(driver);
        account=new Account_Page(driver);
        home=new Home_Page(driver);
        checkout=new Checkout_Page(driver);
        cartPage.ClickMyAccountIcon();
        cartPage.ClickLoginIcon();
        loginPage.enterEmail(storeUserEmail);
        loginPage.enterPassword(storeUserPassword);
        loginPage.submitForm();
        waitForVisible(account.editInformation);
    }

    @AfterMethod
    public void after(){
        home.clickMyAccount();
        home.clickLogout();
    }

    @Test(priority = 0)
    public void VerifyRegisteredUserAddProductsToCart(){
        account.clickLogo();
        waitForVisible(home.feature);
        cartPage.ClickAddToCartButton();
        waitForVisible(cartPage.Success_Message);
        cartPage.assertSuccessMessageDisplay();
    }
    @Test(priority = 1)
    public void ModifyProductQuantity() {
        cartPage.AddToCart();
        cartPage.ModifyQuantity("5");
        cartPage.ClickUpdateButton();
        waitForVisible(cartPage.Modify_Message);
        cartPage.assertModifyQuantityMessageDisplay();
    }


    @Test(priority = 2)
    public void verifyRegisteredUserCannotExceedStockQuantity() {
        cartPage.AddToCart();
        cartPage.ModifyQuantity("200");
        cartPage.ClickUpdateButton();
        waitForVisible(cartPage.Modify_Message);
        waitFoRInVisible(cartPage.Modify_Message);
        waitForVisible(cartPage.OutOfStock_Message);
        cartPage.assertOutOfStockMessage();
        cartPage.close();
        waitFoRInVisible(cartPage.OutOfStock_Message);
    }

    @Test(priority = 3)
        public void VerifyNavigateToProductPageFromCart(){
        account.clickLogo();
        waitForVisible(home.feature);
        cartPage.ClickAddToCartButton();
        waitForVisible(cartPage.Success_Message);
        waitFoRInVisible(cartPage.Success_Message);
        cartPage.ClickOnShoppingCartIcon();
        waitForVisible(cartPage.pageTitle);
        cartPage.NavigateToProductPage();
        wait.until(ExpectedConditions.urlContains("product_id"));
        cartPage.assertNavigateToProductPageFromCart();
        }

        @Test(priority = 4)
        public void VerifyRegisteredUserSelectSpecificProductOption(){
            account.clickLogo();
            waitForVisible(home.feature);
            cartPage.ClickOnAnOptionedProduct();
            driver.findElement(By.xpath("//h1[text()='Canon EOS 5D']"));
            cartPage.SelectDropdownButton();
            cartPage.ClickProductAddToCartButton();
            waitForVisible(cartPage.Success_Message);
            cartPage.ClickOnShoppingCartIcon();
            waitForVisible(cartPage.pageTitle);
            cartPage.assertOptionedProductAddedToCartSuccessfully();
        }

        @Test(priority = 5)
        public void VerifyTotalDisplaysTaxDetails(){
            account.clickLogo();
            waitForVisible(home.feature);
            cartPage.ClickAddToCartButton();
            waitForVisible(cartPage.Success_Message);
            waitFoRInVisible(cartPage.Success_Message);
            cartPage.ClickOnShoppingCartIcon();
            waitForVisible(cartPage.pageTitle);
            cartPage.assertTotalDisplayTaxDetails();
        }

     @Test(priority = 6)
     public void VerifyRegisteredUserRemoveProductsFromCart(){
        cartPage.AddToCart();
        cartPage.RemoveFromCart();
        waitForVisible(cartPage.Success_Message);
        cartPage.assertSuccessMessageDisplay();
     }

        @Test(priority = 7)
        public void VerifyRegisteredUserProceedToCheckOutSuccessfully(){
            account.clickLogo();
            waitForVisible(home.feature);
            cartPage.ClickAddToCartButton();
            waitForVisible(cartPage.Success_Message);
            waitFoRInVisible(cartPage.Success_Message);
            cartPage.ClickOnShoppingCartIcon();
            waitForVisible(cartPage.pageTitle);
            cartPage.ClickCheckOutButton();
            waitForVisible(checkout.pageTitle);
            cartPage.assertUserNavigateToCheckOutPage();
        }



}