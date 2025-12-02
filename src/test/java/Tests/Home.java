package Tests;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Auth.Register_Page;
import Pages.Home_Page;
import Pages.Wishlist_Page;
import jdk.jfr.Timestamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test(priority = 0)
    public void VerifyChoosingAllCurrencies() {
        homepage.CheckCurrencyDropDownMenu();

        List<String> currencyTexts = homepage.getAllCurrencyNames();

        for (String currency: currencyTexts) {
            homepage.CheckCurrencyDropDownMenu();

            homepage.selectCurrency(currency);

            homepage.assertCurrencyIconUpdated(currency);
        }
    }



    @Test (priority = 0)
    public void VerifyUserNavigateToContactUsPage(){
        homepage.ClickOnContactUsIcon();
        homepage.assertUserNavigateToContactUsForm();
    }
    @Test (priority = 0)
    public void VerifyGuestUserCanNotNavigateToWishListPage(){
        homepage.ClickOnWishListIcon();
        homepage.assertGuestUserCanNotNavigateToWishlistPage();
    }

    @Test (priority = 0)
    public void VerifyGuestUserNavigateToCartPage(){
        homepage.ClickOnShoppingCartIcon();
        homepage.assertUserNavigateToCartPage();
    }

    @Test (priority = 0)
    public void VerifyOpenCartLogoIsClickableAndNavigateToHomePage(){
        homepage.ClickOnOpenCartLogo();
        homepage.assertOpenCartLogoClickableAndNavigateToHomePage();
    }

    @Test (priority = 0)
    public void VerifyNavigateToTermsAndConditionsFromFooter(){
        homepage.FooterTermsAndConditionsButton();
        waitForVisible(homepage.Footer_TermsAndCondition_Button);
        homepage.assertNavigateToTermsAndConditionsFromFooter();
    }
    @Test (priority = 0)
    public void VerifyNavigateToSiteMapFromFooter(){
        homepage.FooterSiteMapButton();
        waitUrlContains("sitemap");
        homepage.assertNavigateToSiteMapFromFooter();
    }

    @Test (priority = 0)
    public void VerifyUserCanSearchBySearchBar(){
        homepage.SearchBar("Samsung Galaxy Tab");
        waitUrlContains("product/search");
        homepage.assertNavigateToSearchResultsSuccessfully();
    }


    @Test (priority = 0)
    public void VerifyShoppingCartDropdownItemsDisplayed(){
        homepage.ShoppingCartDropDownMenu();
        waitForVisible(homepage.cartDropDown);
        homepage.assertShoppingCartDropdownItemsDisplayed();
    }
    @Test (priority = 0)
    public void VerifyCategoriesDropDownMenuItemsDisplayed(){
        homepage.CategoriesDropDownMenu();
        homepage.assertCategoriesDropDownMenuItemsDisplayed();
    }
    @Test (priority = 0)
    public void VerifyNavigateToAllDesktopsFromCategoryMenu(){
        homepage.ShowAllDesktopsFromCategoriesMenu();
        homepage.assertNavigateToAllDesktopsFromCategoryMenu();
    }
    @Test (priority = 0)
    public void VerifyNavigateToAllLaptopsAndNoteBooksFromCategoryMenu(){
        homepage.ShowAllLaptopsAndNoteBooksFromCategoriesMenu();
        homepage.assertNavigateToAllLaptopsAndNoteBooksFromCategoryMenu();
    }
    @Test (priority = 0)
    public void VerifyNavigateToAllTabletsFromCategoryMenu(){
        homepage.ShowAllTabletsFromCategoriesMenu();
        homepage.assertNavigateToAllTabletsFromCategoryMenu();
    }
    @Test (priority = 0)
    public void VerifyUserAddProductToCartSuccessfullyAfterClickOnAddToCartIcon(){
        homepage.AddToCartButton();
        homepage.assertProductAddedToCartSuccessfully();
    }

    @Test (priority = 0)
    public void VerifyUserAddIemToCompareAfterClickOnCompareButton(){
        homepage.CompareThisProductButton();
        waitForVisible(homepage.successMessage);
        homepage.assertSuccessfulMessageDisplayedAfterClickOnCompareButton();
    }
    @Test (priority = 0)
    public void VerifySliderBannerItemsDisplayed(){
        homepage.assertSliderBannerItemsDisplayed();
    }

    @Test (priority = 0)
    public void VerifyGuestCanNotNavigateToAffiliateFromFooter(){
        homepage.FooterAffiliateButton();
        waitUrlContains("login");
        homepage.assertGuestCanNotNavigateToAffiliateFromFooter();
    }
    @Test (priority = 0)
    public void VerifyGuestCanNotNavigateToNewsletterFromFooter(){
        homepage.FooterNewsletterButton();
        waitUrlContains("login");
        homepage.assertGuestCanNotNavigateToNewsLetterFromFooter();
    }

    @Test (priority = 0)
    public void VerifyGuestCanNotAddItemToWishList(){
        homepage.ClickOnOpenCartLogo();
        homepage.AddMacBookToWISHList();
        waitForVisible(homepage.errorMessage);
        homepage.assertGuestCanNotAddItemToWishList();
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

    @Test (priority = 2)
    public void VerifyRegisteredUserAddToWishListSuccessfully() {
        homepage.AddMacBookToWISHList();
        homepage.ClickOnWishListIcon();
        homepage.assertProductAdeedToWishListSuccessfully();
    }

    @Test (priority = 2)
    public void VerifyNavigateToAffiliateFromFooter(){
        homepage.FooterAffiliateButton();
        waitUrlContains("affiliate");
        homepage.assertNavigateToAffiliateFromFooter();
    }
    @Test (priority = 2)
    public void VerifyNavigateToNewsletterFromFooter(){
        homepage.FooterNewsletterButton();
        waitUrlContains("newsletter");
        homepage.assertNavigateToNewsLetterFromFooter();
    }

    @Test (priority = 4)
    public void VerifyRegisteredUserNavigateToLogOutPage() {
        driver.get(storeBaseUrl);
        homepage.clickMyAccount();
        homepage.clickLogout();
        homepage.assertRegisteredUserLoggedOutSuccessfully();
    }




}