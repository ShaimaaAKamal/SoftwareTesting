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
        waitForVisible(home.feature);
    }

    @Given("Logged User in cart page")
    public void loggedUserOnOpenCaer() {
        cartPage = new Cart_Page(driver);
        driver.get(storeBaseUrl);
        cartPage.AddToCart();
    }

    @Given("Logged User in checkout page")
    public void loggedUserOnCheckoutPage() {
        checkout = new Checkout_Page(driver);
        driver.get(storeBaseUrl);
        driver.findElement(By.xpath("//span[text()='Checkout']")).click();
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

    @When("user navigate to shopping cart")
    public void userNavigateToCart() {
        cartPage.ClickOnShoppingCartIcon();
        waitForVisible(cartPage.pageTitle);
    }

    @When("the user click on the checkout button")
    public void clickCheckoutButton() {
        waitForVisible(cartPage.pageTitle);
        checkout=new Checkout_Page(driver);
        cartPage.ClickCheckOutButton();
        waitForVisible(checkout.pageTitle);
    }

    @When("user click remove specific product")
    public void removeItemFromCart() {
        waitForVisible(cartPage.pageTitle);
        cartPage.RemoveFromCart();
    }

    @When("user checks page")
    public void userChecksPage() {
        waitForVisible(checkout.pageTitle);
    }
    @When("user add a product requires shipping to cart")
    public void addShippedProductToCart() {
        driver.findElement(By.linkText("Phones & PDAs")).click();
        waitForVisible(By.xpath("//h1[text()='Phones & PDAs']"));
        driver.findElement(cartPage.productCartIcon).click();
    }
    @When("entering new address details, missing first name")
    public void UsingNewAddressMissingFirstName() {
        waitForVisible(checkout.pageTitle);
        checkout.ChooseNewAddress();
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
    }

    @When("entering new address details, missing last name")
    public void UsingNewAddressMissingLastName() {
        waitForVisible(checkout.pageTitle);
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
    }

    @When("entering new address details, missing address 1")
    public void UsingNewAddressMissingAddress1() {
        waitForVisible(checkout.pageTitle);
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
    }

    @When("entering new address details, missing city")
    public void UsingNewAddressMissingCity() {
        waitForVisible(checkout.pageTitle);
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
    }

    @When("entering new address details, missing post code")
    public void UsingNewAddressMissingPostCode() {
        waitForVisible(checkout.pageTitle);
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
    }

    @When("entering new address details, missing region")
    public void UsingNewAddressMissingRegion() {
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.clickAddNewaddress();
    }

    @When("entering valid new address details")
    public void enterValidAccessDetails() {
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
    }

    @When("user choose shipping method")
    public void chooseShippingMethod() {
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.successMessage);
        waitForInvisible(checkout.successMessage);
        checkout.clickContinueShipping();
        waitForVisible(checkout.flatRateLabel);
        checkout.clickShippingRadio();
        checkout.chooseShippingMethod();
    }



    @When("user choose payment method")
    public void choosePaymentMethod() {
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.successMessage);
        waitForVisible(checkout.successMessage);
        checkout.clickContinueShipping();
        waitForVisible(checkout.flatRateLabel);
        checkout.clickShippingRadio();
        checkout.chooseShippingMethod();
        waitForVisible(checkout.successMessage);
        waitForVisible(checkout.successMessage);
        checkout.PaymentMethod();
        waitForVisible(checkout.PaymentContinueButton);
        checkout.clickRadioButton();
        checkout.clickPaymentContinueButton();
    }


    @When("user place order")
    public void placeOrder() {
        checkout.ChooseNewAddress();
        checkout.NewFirstName("Moamen");
        checkout.NewLastName("Ahmed");
        checkout.NewCompany("HiTechNour");
        checkout.NewAddress1("48 Bavaria elmaadi");
        checkout.NewAddress2("Madint Nasr");
        checkout.NewCity("Giza");
        checkout.NewPostCode(4444);
        checkout.NewCountry();
        checkout.NewRegion();
        checkout.clickAddNewaddress();
        waitForVisible(checkout.successMessage);
        waitForInvisible(checkout.successMessage);
        checkout.clickContinueShipping();
        waitForVisible(checkout.flatRateLabel);
        checkout.clickShippingRadio();
        checkout.chooseShippingMethod();
        waitForVisible(checkout.successMessage);
        waitForInvisible(checkout.successMessage);
        checkout.PaymentMethod();
        waitForVisible(checkout.PaymentContinueButton);
        checkout.clickRadioButton();
        checkout.clickPaymentContinueButton();
        waitForVisible(checkout.successMessage);
        checkout.Confirm();
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
        waitForVisible(cartPage.Modify_Message);
        waitForInvisible(cartPage.Modify_Message);
        waitForVisible(cartPage.OutOfStock_Message);
        cartPage.assertOutOfStockMessage();
        cartPage.close();
        waitForInvisible(cartPage.OutOfStock_Message);
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

    @Then("user can see totals displau successfully")
    public void totalsSuccessfully() {
        cartPage.assertTotalDisplayTaxDetails();
    }

    @Then("the user will be redirected successfully to the checkout page")
    public void redirectSuccessfullyToCheckoutPage() {
        cartPage.assertUserNavigateToCheckOutPage();
    }


    @Then("product will be deleted successfully")
    public void productRemovedSuccessfullyFromCart() {
        waitForVisible(cartPage.Success_Message);
        cartPage.assertSuccessMessageDisplay();
    }

    @Then("user can find page title successfully")
    public void checkoutPageTitleDisplaySuccessfully() {
        checkout.assertInCheckoutPage();
    }

    @Then("user can find existing address successfully")
    public void checkoutExistingAddressOptionDisplaySuccessfully() {
        checkout.assertExistingAddresses();
    }

    @Then("user can choose existing address successfully")
    public void checkoutExistingAddressOptionChoicedSuccessfully() {
        checkout.ChooseExistingAddress();
    }
    @Then("the user will be notified by an error message missing first name")
    public void AssertNewAddressFirstnameError() {
        waitForVisible(checkout.firstNameError);
        checkout.AssertFirstnameError();
    }
    @Then("the user will be notified by an error message last name")
    public void AssertNewAddressLastnameError() {
        waitForVisible(checkout.lastNameError);
        checkout.AssertLastnameError();
    }

    @Then("the user will be notified by an error message missing address 1")
    public void AssertNewAddressAddress1Error() {
        waitForVisible(checkout.address1Error);
        checkout.AssertAddress1Error();
    }
    @Then("the user will be notified by an error message missing city")
    public void AssertNewAddressCityError() {
        waitForVisible(checkout.cityError);
        checkout.AssertCityError();
    }

    @Then("the user will be notified by an error message missing region")
    public void AssertNewAddressRegionError() {
        waitForVisible(checkout.regionError);
        checkout.AssertNewAddressRegionError();
    }


    @Then("the user will be notified by an error message missing post code")
    public void AssertNewAddressPostCodeError() {
        waitForVisible(checkout.codeError);
        checkout.AssertNewAddressPostCodeError();
    }

    @Then("address will be added successfully")
    public void AssertNewShippingAddressAddedSuccessfully() {
        waitForVisible(checkout.successMessage);
        checkout.assertAlert();
    }


    @Then("success message will be displayed")
    public void AssertNewShippingMethoChoicedSuccessfully() {
        waitForVisible(checkout.successMessage);
    }


    @Then("payment success message will be displayed")
    public void AssertPaymentgMethoChoicedSuccessfully() {
        waitForVisible(checkout.successMessage);
        checkout.AssertPaymentSuccess();
    }


    @Then("order placed success message will be displayed")
    public void AssertOrderPlacedSuccessfully() {
        waitForVisible(checkout.orderPlaced);
        checkout.AssertSuccessfulCheckout();
    }


}
