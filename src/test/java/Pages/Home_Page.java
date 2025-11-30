package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Home_Page extends Base_Page{
    public By myAccount=By.cssSelector(".fa-user");
    By registerLink=By.linkText("Register");
    By loginLink=By.linkText("Login");
    By logoutLink=By.linkText("Logout");
    By CurrencyButton = By.xpath("//a[i[contains(@class, 'fa-caret-down')]]");
    public By CurrencyDropDownMenu =By.xpath("//ul[@class=\"dropdown-menu show\"]");
    public By currency=By.xpath("//a[text()='£ Pound Sterling']");
    By EuroButton = By.xpath("//a[@href=\"EUR\"]");
    By Pound_Sterling_Button = By.xpath("//a[@href=\"GBP\"]");
    By UsDollar_Button = By.xpath("//a[@href=\"USD\"]");
    By Phone_Icon =By.xpath("//i[@class=\"fa-solid fa-phone\"]");
    By WishList_Icon =By.xpath("//a[@title=\"Wish List (0)\"]");
    By Shopping_Cart_Icon =By.xpath("//a[@title=\"Shopping Cart\"]");
    By CheckOut_Icon = By.xpath("//i[@class=\"fa-solid fa-share\"]");
    By OpenCart_lOGO =By.xpath("//img[@title=\"Your Store\"]");
    By Add_MacBook_ToWishlist = By.cssSelector("button > i.fa-heart");
    public By feature=By.xpath("//h3[text()='Featured']");
    public By accountLink=By.linkText("My Account");

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
//        driver.findElement(logoutLink).click();
    }

    public void clickAccountLink(){
        driver.findElement(accountLink).click();

    }

    public boolean registerExists() {
        boolean exist = !driver.findElements(registerLink).isEmpty();
        return exist;
    }

        public void CheckCurrencyDropDownMenu(){
            driver.findElement(CurrencyButton).click();
        }
        public void SelectEuroChoice(){
            driver.findElement(EuroButton).click();
        }
        public void SelectPoundSterlingChoice(){
            driver.findElement(Pound_Sterling_Button).click();
        }
        public void SelectUsDollarChoice(){
            driver.findElement(UsDollar_Button).click();
        }
        public void ClickOnContactUsIcon(){
            driver.findElement(Phone_Icon).click();
        }
        public void ClickOnWishListIcon(){
            driver.findElement(WishList_Icon).click();
        }
        public void ClickOnShoppingCartIcon(){
            driver.findElement(Shopping_Cart_Icon).click();
        }
        public void ClickOnCheckOutIcon(){
            driver.findElement(CheckOut_Icon).click();
        }
        public void ClickOnLogOutButton(){
            driver.findElement(logoutLink).click();
        }
        public void ClickOnOpenCartLogo(){
            driver.findElement(OpenCart_lOGO).click();
        }
        public void AddMacBookToWISHList(){
        scrollAndClick(Add_MacBook_ToWishlist);
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
        public void assertEuroIconDisplayed(){
            Assert.assertTrue(driver.findElement(By.xpath("//a[.//strong[text()='€']]")).isDisplayed());
        }
        public void assertPoundSterlingIconDisplayed(){
            Assert.assertTrue(driver.findElement(By.xpath("//a[.//strong[text()='£']]")).isDisplayed());
//            Assert.assertTrue(driver.findElement(By.linkText("£")).isDisplayed());
        }
        public void assertUsDollarIconDisplayed(){
            Assert.assertTrue(driver.findElement(By.xpath("//a[.//span[text()='US Dollar']]")).isDisplayed());

//            Assert.assertTrue(driver.findElement(By.linkText("$")).isDisplayed());
        }
        public void assertUserNavigateToContactUsForm(){
            Assert.assertTrue(driver.findElement(By.xpath("//label[@for=\"input-name\"]")).isDisplayed());
        }
        public void assertGuestUserNavigateToWishlistPage(){
            Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"breadcrumb-item\"]")).isDisplayed());
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


}



