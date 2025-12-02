package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Home_Page extends Base_Page{
    public By myAccount=By.cssSelector(".fa-user");
    By registerLink=By.linkText("Register");
    By loginLink=By.linkText("Login");
    By logoutLink=By.linkText("Logout");
    By CurrencyButton = By.xpath("//a[i[contains(@class, 'fa-caret-down')]]");
    public By currency=By.xpath("//a[text()='£ Pound Sterling']");
    public By currencyOptions = By.cssSelector("#form-currency .dropdown-menu a");
    public By displayedCurrency = By.cssSelector("#form-currency .dropdown-toggle strong");
    By Phone_Icon =By.xpath("//i[@class=\"fa-solid fa-phone\"]");
    By WishList_Icon =By.id("wishlist-total");

    By Shopping_Cart_Icon =By.xpath("//a[@title=\"Shopping Cart\"]");
    By CheckOut_Icon = By.xpath("//i[@class=\"fa-solid fa-share\"]");
    By OpenCart_lOGO =By.xpath("//img[@title=\"Your Store\"]");
    By Add_MacBook_ToWishlist = By.cssSelector("button > i.fa-heart");
    public By feature=By.xpath("//h3[text()='Featured']");
    public By accountLink=By.linkText("My Account");
    By Search_Bar = By.xpath("//input[@type=\"text\"]");
    By Magnifying_Glass_button = By.xpath("//i[@class=\"fa-solid fa-magnifying-glass\"]");
    By Shopping_Cart_DropDown_Menu = By.cssSelector(".btn-dark");
    By Categories_DropDown_Menu = By.cssSelector("#navbar-menu");
    By Desktop_Button = By.linkText("Desktops");
    By Show_All_Desktops_Button = By.linkText("Show All Desktops");
    By Laptops_Notebooks_Button = By.linkText("Laptops & Notebooks");
    By Show_All_LaptopsAndNoteBooks_Button = By.linkText("Show All Laptops & Notebooks");
    By Tablets_Button = By.linkText("Tablets");
    By Add_To_Cart_Button =By.cssSelector("button > i.fa-shopping-cart");
    By Add_To_WishList_Button =By.cssSelector("button > i.fa-heart");
    By Compare_This_Product_Button = By.cssSelector("button > i.fa-arrow-right-arrow-left");
    By Slider_Banner = By.id("carousel-banner-0");
   public By Footer_TermsAndCondition_Button =By.linkText("Terms & Conditions");
    public By Footer_Site_Map_Button =By.linkText("Site Map");
    public By Footer_Affiliate_Button =By.linkText("Affiliate");
    public By Footer_Newsletter_Button =By.linkText("Newsletter");
    public By errorMessage=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    public By successMessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By cartDropDown=By.xpath("//ul[contains(@class,'dropdown-menu') and contains(@class,'p-2')]");

    public Home_Page(WebDriver driver){
        super(driver);
    }
    public void clickMyAccount(){
        scrollAndClick(myAccount);
    }

    public void clickRegitser(){
        driver.findElement(registerLink).click();
    }

    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public void clickLogout(){
        scrollAndClick(logoutLink);
    }


    public boolean registerExists() {
        boolean exist = !driver.findElements(registerLink).isEmpty();
        return exist;
    }

        public void CheckCurrencyDropDownMenu(){
            driver.findElement(CurrencyButton).click();
        }

    public List<WebElement> getAllCurrencyOptions() {
        List<WebElement> options = driver.findElements(currencyOptions);
        return options;
    }

    public List<String> getAllCurrencyNames() {
        List<WebElement> options = driver.findElements(currencyOptions);
        List<String> names = new ArrayList<>();

        for (WebElement el : options) {
            names.add(el.getText().trim());   // e.g. "$ US Dollar"
        }
        return names;
    }

    public void selectCurrency(String currencyText) {
        // 1. Click dropdown to expand options
        WebElement dropdownToggle = driver.findElement(By.cssSelector("#form-currency .dropdown-toggle"));
        dropdownToggle.click();

        // 2. Wait until options are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(currencyOptions));

        // 3. Find and click desired option
        List<WebElement> options = driver.findElements(currencyOptions);
        for (WebElement option : options) {
            String optionText = option.getText().replace("\u00A0", " ").trim();
            String desiredText = currencyText.replace("\u00A0", " ").trim();

            System.out.println("Option: '" + optionText + "' | Desired: '" + desiredText + "'");

            if (optionText.contains(desiredText)) {
                System.out.println("Selecting currency: " + optionText);
                option.click();
                return;
            }
        }

        throw new RuntimeException("Currency not found: " + currencyText);
    }

        public void ClickOnContactUsIcon(){
            driver.findElement(Phone_Icon).click();
        }
        public void ClickOnWishListIcon(){
           scrollAndClick(WishList_Icon);
        }
        public void ClickOnShoppingCartIcon(){
            driver.findElement(Shopping_Cart_Icon).click();
        }
        public void ClickOnCheckOutIcon(){
            driver.findElement(CheckOut_Icon).click();
        }

        public void ClickOnOpenCartLogo(){
            driver.findElement(OpenCart_lOGO).click();
        }
        public void AddMacBookToWISHList(){
        scrollAndClick(Add_MacBook_ToWishlist);
        }


    public void SearchBar(String search) {
        driver.findElement(Search_Bar).sendKeys(search);
        driver.findElement(Magnifying_Glass_button).click();
    }

    public void ShoppingCartDropDownMenu() {
        driver.findElement(Shopping_Cart_DropDown_Menu).click();
    }

    public void CategoriesDropDownMenu() {
        driver.findElement(Categories_DropDown_Menu).click();
    }

    public void ShowAllDesktopsFromCategoriesMenu() {
        driver.findElement(Desktop_Button).click();
        driver.findElement(Show_All_Desktops_Button).click();
    }

    public void ShowAllLaptopsAndNoteBooksFromCategoriesMenu() {
        driver.findElement(Laptops_Notebooks_Button).click();
        driver.findElement(Show_All_LaptopsAndNoteBooks_Button).click();
    }

    public void ShowAllTabletsFromCategoriesMenu() {
        driver.findElement(Tablets_Button).click();
    }

    public void AddToCartButton() {
        scrollAndClick(Add_To_Cart_Button);
    }


    public void CompareThisProductButton() {
        scrollAndClick(Compare_This_Product_Button);
    }

    public void FooterTermsAndConditionsButton() {
        scrollAndClick(Footer_TermsAndCondition_Button);
    }
    public void FooterSiteMapButton() {
        scrollAndClick(Footer_Site_Map_Button);
    }
    public void FooterAffiliateButton() {
        scrollAndClick(Footer_Affiliate_Button);
    }
    public void FooterNewsletterButton() {
        scrollAndClick(Footer_Newsletter_Button);
    }

        ///Assertion//////
        public void assertUserNavigateToRegistrationPage(){
            Assert.assertTrue(driver.getCurrentUrl().contains("route=account/register"));
        }
        public void assertUserNavigateToLoginPage(){
            Assert.assertTrue(driver.getCurrentUrl().contains("route=account/login"));
        }
        public void assertCurrencyDropDownMenuDisplayed(){
            Assert.assertTrue(driver.findElement(currency).isDisplayed());
        }


    public void assertCurrencyIconUpdated(String currencyText) {
        String expectedSymbol = currencyText.substring(0, 1);

        WebElement icon = driver.findElement(By.xpath("//a[.//strong and contains(., '" + expectedSymbol + "')]"));

        Assert.assertTrue(icon.isDisplayed(), "Currency icon not updated for: " + currencyText);
    }
        public void assertUserNavigateToContactUsForm(){
            Assert.assertTrue(driver.findElement(By.xpath("//label[@for=\"input-name\"]")).isDisplayed());
        }
        public void assertGuestUserCanNotNavigateToWishlistPage(){
            Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        }
        public void assertRegisteredUserNavigateToWishListPage(){
            Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"wishlist\"]")).isDisplayed());
        }
        public void assertUserNavigateToCartPage(){
            Assert.assertTrue(driver.findElement(By.linkText("Shopping Cart")).isDisplayed());
        }
        public void assertUserNavigateToCheckOutPage(){
            Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));
        }
        public void assertRegisteredUserLoggedOutSuccessfully(){
            Assert.assertTrue(driver.getCurrentUrl().contains("account/logout"));
        }
        public void assertProductAdeedToWishListSuccessfully(){
            Assert.assertTrue(driver.findElement(By.linkText("My Wishlist")).isDisplayed());

        }

        public void assertOpenCartLogoClickableAndNavigateToHomePage() {
            Assert.assertTrue(driver.getCurrentUrl().contains("home"));
        }

        public void assertNavigateToSearchResultsSuccessfully() {
            Assert.assertTrue(driver.getCurrentUrl().contains("product/search"));
        }

        public void assertShoppingCartDropdownItemsDisplayed() {
//
//            Assert.assertTrue(driver.findElement(By.xpath("//*[@id='cart']//a[contains(@href,'checkout/cart')]")).isDisplayed());
            Assert.assertTrue(driver.findElement(cartDropDown).isDisplayed());

        }

        public void assertCategoriesDropDownMenuItemsDisplayed() {
            Assert.assertTrue(driver.findElement(Laptops_Notebooks_Button).isDisplayed());
            Assert.assertTrue(driver.findElement(Desktop_Button).isDisplayed());
            Assert.assertTrue(driver.findElement(Tablets_Button).isDisplayed());
        }

        public void assertNavigateToAllDesktopsFromCategoryMenu() {
            Assert.assertTrue(driver.findElement(By.linkText("Desktops")).isDisplayed());
        }

        public void assertNavigateToAllLaptopsAndNoteBooksFromCategoryMenu() {
            Assert.assertTrue(driver.findElement(By.linkText("Laptops & Notebooks")).isDisplayed());
        }

        public void assertNavigateToAllTabletsFromCategoryMenu() {
            Assert.assertTrue(driver.findElement(By.linkText("Tablets")).isDisplayed());
        }

        public void assertProductAddedToCartSuccessfully() {
            Assert.assertTrue(driver.findElement(By.linkText("Tablets")).isDisplayed());
        }

        public void assertSuccessfulMessageDisplayedAfterAddProductToCart() {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
        }

        public void assertSuccessfulMessageDisplayedAfterAddProductToWishList() {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
        }

        public void assertSuccessfulMessageDisplayedAfterClickOnCompareButton() {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).isDisplayed());
        }

        public void assertSliderBannerItemsDisplayed() {
            Assert.assertTrue(driver.findElement(Slider_Banner).isDisplayed());
        }
        public void assertNavigateToTermsAndConditionsFromFooter(){
            Assert.assertTrue(driver.findElement(Footer_TermsAndCondition_Button).isDisplayed());
        }
        public void assertNavigateToSiteMapFromFooter(){
            Assert.assertTrue(driver.getCurrentUrl().contains("sitemap"));
        }
        public void assertNavigateToAffiliateFromFooter(){
            Assert.assertTrue(driver.getCurrentUrl().contains("affiliate"));
        }
        public void assertNavigateToNewsLetterFromFooter(){
            Assert.assertTrue(driver.getCurrentUrl().contains("newsletter"));
        }

        public void assertGuestCanNotNavigateToAffiliateFromFooter(){
            Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        }

        public void assertGuestCanNotNavigateToNewsLetterFromFooter(){
            Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        }

        public void assertGuestCanNotAddItemToWishList(){
            Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());

        }
}



