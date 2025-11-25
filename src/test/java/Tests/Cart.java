package Tests;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Cart_Page;
import Pages.Home_Page;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Cart extends BaseTest {
    Login_Page loginPage;
    Cart_Page cartPage;
    Account_Page account;
    Home_Page home;
    @BeforeMethod
    public void precondition() {
        driver.get("http://localhost:8888/opencartDemo/");
        driver.manage().window().maximize();     loginPage = new Login_Page(driver);
        cartPage = new Cart_Page(driver);
        account=new Account_Page(driver);
        home=new Home_Page(driver);
        cartPage.ClickMyAccountIcon();
        cartPage.ClickLoginIcon();
        loginPage.enterEmail("tete@gmail.com");
        loginPage.enterPassword("Test710@");
        loginPage.submitForm();
        waitForVisible(account.editInformation);
    }

    @AfterMethod
    public void after(){
        driver.get("http://localhost:8888/opencartDemo/");
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
        waitForVisible(cartPage.OutOfStock_Message);
        cartPage.assertOutOfStockMessage();
    }
    @Test(priority = 3)
    public void VerifyRegisteredUserRemoveProductsFromCart(){
        cartPage.AddToCart();
        cartPage.RemoveFromCart();
        waitForVisible(cartPage.emptyCartMessage);
        cartPage.assertEmptyCartMessageDispaly();
    }
}