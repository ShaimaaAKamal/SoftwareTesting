package Pages.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Account_Page {
    WebDriver driver;
    public By editInformation= By.linkText("Edit your account information");
    By changePassword   = By.linkText("Change your password");
    By modifyAddress    = By.linkText("Modify your address book entries");
    By modifyWishList   = By.linkText("Modify your wish list");
    By orderHistory     = By.linkText("View your order history");
    By rewardPoints     = By.linkText("Your Reward Points");
    By returnRequests   = By.linkText("View your return requests");
    By transcations     = By.linkText("Your Transactions");
    public By affliateAccount  = By.linkText("Register for an affiliate account");
    By editAccount=By.linkText("Edit Account");
    By password=By.linkText("Password");
    By addressBook=By.linkText("Address Book");
    By wishlist =By.linkText("Wish List");
    By orders=By.linkText("Order History");
    By downloads=By.linkText("Downloads");
    By subscriptions=By.linkText("Subscriptions");
    By points=By.linkText("Reward Points");
    By returnS=By.linkText("Returns");
    By trans=By.linkText("Transactions");
    By newsLetters=By.linkText("Newsletter");
    By logout =By.linkText("Logout");
    By logo=By.xpath("//img[@title='Your Store']");
    public By editAffliate=By.linkText("Edit your affiliate information");
    By customAffliate=By.linkText("Custom Affiliate Tracking Code");
    public By updatedSuccessfully=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public Account_Page(WebDriver driver){
        this.driver=driver;
    }
    public void logout(){
        driver.findElement(logout).click();
    }

    public void clickLogo(){
        driver.findElement(logo).click();
    }
    public void navigateToNewsLetters(){
        driver.findElement(newsLetters).click();
    }

    public void navigateToTranscationsUsingSidebar(){
        driver.findElement(trans).click();
    }
    public void navigateToReturnsRequestsUsingSidebar(){
        driver.findElement(returnS).click();
    }
    public void navigateToRewardPointsUsingSidebar(){
        driver.findElement(points).click();
    }
    public void navigateToSubscriptionsUsingSidebar(){
        driver.findElement(subscriptions).click();
    }
    public void navigateToDownloadsUsingSidebar(){
        driver.findElement(downloads).click();
    }

    public void navigateToOrderHistoryUsingSidebar(){
        driver.findElement(orders).click();
    }
    public void navigateToWishlistUsingSidebar(){
        driver.findElement(wishlist).click();
    }
    public void navigateToAddressBookUsingSidebar(){
        driver.findElement(addressBook).click();
    }
    public void navigateToChangePasswordUsingSidebar(){
        driver.findElement(password).click();
    }
    public void navigateToEditAccountUsingSidebar(){
        driver.findElement(editAccount).click();
    }

    public boolean isAddAfflicateAccountExists(){
       return !driver.findElements(affliateAccount).isEmpty();
    }

    public void navigateToTranscationsUsingMainPage(){
        driver.findElement(transcations).click();
    }
    public void navigateToReturnsRequestsUsingMainPage(){
        driver.findElement(returnRequests).click();
    }
    public void navigateToRewardPointsUsingMainPage(){
        driver.findElement(rewardPoints).click();
    }

    public void navigateToOrderHistoryUsinMainPage(){
        driver.findElement(orderHistory).click();
    }
    public void navigateToWishlistUsingMainPage(){
        driver.findElement(modifyWishList).click();
    }
    public void navigateToAddressBookUsingMainPage(){
        driver.findElement(modifyAddress).click();
    }
    public void navigateToChangePasswordUsingMainPage(){
        driver.findElement(changePassword).click();
    }
    public void navigateToEditAccountUsingMainPage(){
        driver.findElement(editInformation).click();
    }
    public void navigateTAffliateAccountUsingMainPage(){
        driver.findElement(affliateAccount).click();
    }

    public void navigateToEditAffliateAccountUsingMainPage(){
        driver.findElement(editAffliate).click();
    }

    public void navigateToCustomAffliateAccountUsingMainPage(){
        driver.findElement(customAffliate).click();
    }

    public boolean editAffliateExists(){
        return driver.findElement(editAffliate).isDisplayed();
    }

    public void assertAddAffliateAccountLink(){
        Assert.assertTrue(isAddAfflicateAccountExists());
    }
}
