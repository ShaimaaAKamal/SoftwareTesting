package Tests.Auth;

import Pages.Auth.AccountFunctions.*;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.testng.annotations.*;

public class Account extends BaseTest {
    Login_Page login;
    Home_Page home;
    Account_Page accountPage;
    EditAccountInformation_Page editAccount;
    ChangePassword_Page changePassword;
    AddressBook_Page addressBook;
    wishlist_Page wishlist;
    Transcations_Page transcations;
    OrderHistory_Page orderHistory;
    Subscriptions_Page subscriptions;
    ReturnRequests_Page returns;
    AffilateAccount_Page account;
    NewLetters_Page newsLetters;
    RewardPoint_Page rewardPoints;
    Downloads_Page downloads;
//    @BeforeTest
//    public void beforeTest(){
//        home=new Home_Page(driver);
//        login = new Login_Page(driver);
//        accountPage=new Account_Page(driver);
//        editAccount=new EditAccountInformation_Page(driver);
//        changePassword=new ChangePassword_Page(driver);
//        addressBook=new AddressBook_Page(driver);
//        wishlist=new wishlist_Page(driver);
//        orderHistory=new OrderHistory_Page(driver);
//        subscriptions=new Subscriptions_Page(driver);
//        downloads=new Downloads_Page(driver);
//        rewardPoints=new RewardPoint_Page(driver);
//        returns=new ReturnRequests_Page(driver);
//        transcations=new Transcations_Page(driver);
//        newsLetters=new NewLetters_Page(driver);
//        account=new AffilateAccount_Page(driver);
//        accountPage.logout();
//    }
    @BeforeClass
    public void beforeTest(){
        home=new Home_Page(driver);
        login = new Login_Page(driver);
        accountPage=new Account_Page(driver);
        editAccount=new EditAccountInformation_Page(driver);
        changePassword=new ChangePassword_Page(driver);
        addressBook=new AddressBook_Page(driver);
        wishlist=new wishlist_Page(driver);
        orderHistory=new OrderHistory_Page(driver);
        subscriptions=new Subscriptions_Page(driver);
        downloads=new Downloads_Page(driver);
        rewardPoints=new RewardPoint_Page(driver);
        returns=new ReturnRequests_Page(driver);
        transcations=new Transcations_Page(driver);
        newsLetters=new NewLetters_Page(driver);
        account=new AffilateAccount_Page(driver);
        accountPage.logout();
    }
    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void navigateToEditAccountUsingMainPage(){
        accountPage.navigateToEditAccountUsingMainPage();
        waitForVisible(editAccount.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToEditAccountUsingSidebar(){
        accountPage.navigateToEditAccountUsingSidebar();
        waitForVisible(editAccount.pageTitle);
    }


    @Test(priority = 0)
    public void navigateToChangePasswordSidebar(){
        accountPage.navigateToChangePasswordUsingSidebar();
        waitForVisible(changePassword.PageTitle);
    }

    @Test(priority = 0)
    public void navigateToChangePasswordUsingMainPage(){
        accountPage.navigateToChangePasswordUsingMainPage();
        waitForVisible(changePassword.PageTitle);
    }

    @Test(priority = 0)
    public void navigateToAddressbookSidebar(){
        accountPage.navigateToAddressBookUsingSidebar();
        waitForVisible(addressBook.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToWishlistUsingMainPage(){
        accountPage.navigateToWishlistUsingMainPage();
        waitForVisible(wishlist.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToWishlistUsingSidebar(){
        accountPage.navigateToWishlistUsingSidebar();
        waitForVisible(wishlist.pageTitle);
    }
    @Test(priority = 0)
    public void navigateToOrderHistoryUsingMainPage(){
        accountPage.navigateToOrderHistoryUsinMainPage();
        waitForVisible(orderHistory.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToOrderHistorytUsingSidebar(){
        accountPage.navigateToOrderHistoryUsingSidebar();
        waitForVisible(orderHistory.pageTitle);
    }


    @Test(priority = 0)
    public void navigateToSubscriptionsUsingSidebar(){
        accountPage.navigateToSubscriptionsUsingSidebar();
        waitForVisible(subscriptions.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToDownloadsUsingSidebar(){
        accountPage.navigateToDownloadsUsingSidebar();
        waitForVisible(downloads.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToRewardPointsUsingSidebar(){
        accountPage.navigateToRewardPointsUsingSidebar();
        waitForVisible(rewardPoints.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToRewardPointsUsingMainPage(){
        accountPage.navigateToRewardPointsUsingMainPage();
        waitForVisible(rewardPoints.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToReturnsUsingSidebar(){
        accountPage.navigateToReturnsRequestsUsingSidebar();
        waitForVisible(returns.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToReturnsUsingMainPage(){
        accountPage.navigateToReturnsRequestsUsingMainPage();
        waitForVisible(returns.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToTranscationsUsingSidebar(){
        accountPage.navigateToTranscationsUsingSidebar();
        waitForVisible(transcations.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToTranscationsUsingMainPage(){
        accountPage.navigateToTranscationsUsingMainPage();
        waitForVisible(transcations.pageTitle);
    }

    @Test(priority = 0)
    public void navigateToNewLettersUsingMainPage(){
        accountPage.navigateToNewsLetters();
        waitForVisible(newsLetters.pageTitle);
    }


    @Test(priority = 0)
    public void navigateToAccountUsingMainPage(){
        if(accountPage.isAddAfflicateAccountExists()){
            accountPage.navigateTAffliateAccountUsingMainPage();
        }
        else {
            accountPage.navigateToEditAffliateAccountUsingMainPage();
        }
        waitForVisible(account.pageTitle);
    }



}
