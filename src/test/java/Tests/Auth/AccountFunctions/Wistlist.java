package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.AddressBook_Page;
import Pages.Auth.AccountFunctions.NewAddress_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Pages.Wishlist_Page;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wistlist extends BaseTest {

    Wishlist_Page wishlist;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeTest
    public void beforeTest()  {
        driver.get("http://localhost:8888/opencartDemo/");
        home=new Home_Page(driver);
        accountPage=new Account_Page(driver);
        home.clickMyAccount();
        home.clickLogout();
    }
    @BeforeMethod
    public void preCondition() {
        driver.get("http://localhost:8888/opencartDemo/");
        wishlist = new Wishlist_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail("tete@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();
        waitForVisible(accountPage.editInformation);
        accountPage.navigateToWishlistUsingMainPage();
        waitForVisible(wishlist.pageTitle);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void continuebtn(){
        wishlist.continueBtn();
        waitForVisible(accountPage.editInformation);
    }

    @Test(priority = 0)
    public void removeItemFromWishList() throws InterruptedException {
        int count= wishlist.wishlistProductsCount();
        if(count > 1){
            wishlist.RemoveFromWishlistUsingIndex(1);
            Thread.sleep(1000);
            System.out.println(wishlist.wishlistProductsCount());
            Assert.assertEquals(wishlist.wishlistProductsCount(),count-1);
        }
    }

//    @Test(priority = 1)
//    public void addWishlistProductToCart()  {
//        int count= wishlist.wishlistProductsCount();
//        if(count >= 1){
//            wishlist.addWishlisProductToCarttUsingIndex(0);
//            waitForVisible(wishlist.successMessage);
//        }
//    }

    @Test(priority = 2)
    public void removeLastItemFromWishList(){
        int count= wishlist.wishlistProductsCount();
        if(count == 1){
            wishlist.RemoveFromWishlistUsingIndex(0);
            waitForVisible(wishlist.emptyMessage);
        }
    }

}
