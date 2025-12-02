package Tests.Auth.AccountFunctions;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Pages.Wishlist_Page;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class Wistlist extends BaseTest {

    Wishlist_Page wishlist;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;

    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        home=new Home_Page(driver);
        accountPage=new Account_Page(driver);
        wishlist = new Wishlist_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
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
        if(count >= 1){
            wishlist.RemoveFromWishlistUsingIndex(1);
            Thread.sleep(1000);
            Assert.assertEquals(wishlist.wishlistProductsCount(),count-1);
        }
    }


}
