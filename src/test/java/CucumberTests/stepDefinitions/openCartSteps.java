package CucumberTests.stepDefinitions;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Cart_Page;
import Pages.Checkout_Page;
import Pages.Home_Page;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberTests.stepDefinitions.Base.*;
import static CucumberTests.stepDefinitions.Base.waitForVisible;

public class openCartSteps {

    Login_Page login;
    Account_Page account;
    Home_Page home;
    String storeBaseUrl=Base.storeBaseUrl;
    String storeUserEmail=Base.storeUserEmail;
    String storeUserPassword=Base.storeUserPassword;
    Cart_Page cartPage;
    Checkout_Page checkout;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        login=new Login_Page(driver);
        driver.get(storeBaseUrl);
        home=new Home_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        account=new Account_Page(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();

    }

    @When("User doesn't enter  username and password")
    public void user_enters_empty_username_and_password() {
        login.submitForm();
    }

    @When("User enter empty username and valid password")
    public void user_enters_empty_username_and_valid_password() {
        login.enterPassword(storeUserPassword);
        login.submitForm();
    }

    @When("User enter valid username and empty password")
    public void user_enters_valid_username_and_empty_password() {
        login.enterEmail(storeUserEmail);
        login.submitForm();
    }

    @When("User enter invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {
        login.enterEmail("teyd@gmail.com");
        login.enterPassword(storeUserPassword);
        login.submitForm();
    }

    @When("User enter valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        login.enterEmail(storeUserEmail);
        login.enterPassword("ivipewhvpiew");
        login.submitForm();
    }

    @When("User enter invalid username and invalid password")
    public void user_enters_invalid_username_and_invalid_password() {
        login.enterEmail("teyd@gmail.com");
        login.enterPassword("ivipewhvpiew");
        login.submitForm();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Base.wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("route=account/login")
        ));
//        account.logout();
    }

    @Then("User should not be logged")
    public void user_should_not_be_logged() {
        Base.waitForVisible(login.errorMessage);
        login.assertLoginError();
    }



    @Given("Logged User in home page")
    public void loggedUserOnHomePage() {
        driver.get(storeBaseUrl);
        cartPage = new Cart_Page(driver);
        checkout=new Checkout_Page(driver);
        home=new Home_Page(driver);
        checkout=new Checkout_Page(driver);
//        cartPage.ClickMyAccountIcon();
//        cartPage.ClickLoginIcon();
//        login.enterEmail(storeUserEmail);
//        login.enterPassword(storeUserPassword);
//        login.submitForm();
//        waitForVisible(account.editInformation);
//        account.clickLogo();
        waitForVisible(home.feature);
    }

    @Given("Logged User in cart page")
    public void loggedUserOnOpenCaer() {
        cartPage = new Cart_Page(driver);
        driver.get(storeBaseUrl);
        cartPage.AddToCart();
    }

    @When("click add product to  cart btn")
    public void clickAddToCart() {
        cartPage = new Cart_Page(driver);
        cartPage.ClickAddToCartButton();
    }

    @When("modify the product quantity")
    public void modifyProductQuantity() {
        cartPage = new Cart_Page(driver);
        cartPage.ModifyQuantity("5");
        cartPage.ClickUpdateButton();    }

    @When("modify the product quantity to value exceeding max stock value")
    public void modifyProductQuantityToOutOfStockValue() {
        cartPage = new Cart_Page(driver);
        cartPage.ModifyQuantity("200");
        cartPage.ClickUpdateButton();    }

    @When("user click on specif product")
    public void clickOnProduct() {
        cartPage = new Cart_Page(driver);
        cartPage.NavigateToProductPage();
    }

    @When("user choose specific product variant")
    public void chooseProductVariant() {
        cartPage = new Cart_Page(driver);
        cartPage.ClickOnAnOptionedProduct();
        driver.findElement(By.xpath("//h1[text()='Canon EOS 5D']"));
        cartPage.SelectDropdownButton();
        cartPage.ClickProductAddToCartButton();
    }




    @Then("product added successfully")
    public void product_added_to_Cart_successfully() {
        waitForVisible(cartPage.Success_Message);
        cartPage.assertSuccessMessageDisplay();
    }


    @Then("product quantity updated  successfully")
    public void product_quantity_updated_successfully() {
        waitForVisible(cartPage.Modify_Message);
        cartPage.assertModifyQuantityMessageDisplay();
    }

    @Then("product quantity can not be updated  successfully")
    public void product_quantity_can_not_updated_successfully() {
        waitForVisible(cartPage.OutOfStock_Message);
        cartPage.assertOutOfStockMessage();
    }

    @Then("he will be redirect successfully to this product page")
    public void redirec_to_product_Page() {
        wait.until(ExpectedConditions.urlContains("product_id"));
        cartPage.assertNavigateToProductPageFromCart();
    }

    @Then("this variant will be added successfully to cart")
    public void variantAddedSuccessfully() {
        waitForVisible(cartPage.Success_Message);
        cartPage.ClickOnShoppingCartIcon();
        waitForVisible(cartPage.pageTitle);
        cartPage.assertOptionedProductAddedToCartSuccessfully();
    }


}
