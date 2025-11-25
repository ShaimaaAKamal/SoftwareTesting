package Pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Single_Product_Page {
    WebDriver driver;
    // these locators for "iphone" product
    By productTitle = By.cssSelector("div[class=\"col-sm\"] h1");
    By productPrice = By.xpath("//h2/span[@class=\"price-new\"]");
    By wishlistBtn = By.xpath("//div/button[1][@class=\"btn btn-light btn-lg\"]");
    By compareBtn = By.xpath("//div/button[2][@class=\"btn btn-light btn-lg\"]");
    By aTCBtn = By.cssSelector("[id=button-cart]");
    By quantityTxtBox = By.id("input-quantity");
    By descriptionBtn = By.cssSelector("[class=nav-link active]");
    By reviewsBtn = By.cssSelector("[class=nav-link]");
    By yourNameTxtBox = By.id("input-author");
    By yourReviewTxtBox = By.cssSelector("[id=input-text]");
    By rateRadioBtn1 = By.xpath("//*[@id=\"input-rating\"]/input[1]");
    By rateRadioBtn2 = By.xpath("//*[@id=\"input-rating\"]/input[2]");
    By rateRadioBtn3 = By.xpath("//*[@id=\"input-rating\"]/input[3]");
    By rateRadioBtn4 = By.xpath("//*[@id=\"input-rating\"]/input[4]");
    By rateRadioBtn5 = By.xpath("//*[@id=\"input-rating\"]/input[5]");
    By continueReviewBtn = By.cssSelector("[id=button-review]");
    By reviewSuccessMsg = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");
    By wishListErrorMsg = By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]");
    public By wishListSuccessMsg = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");
    By aTCSuccessMsg = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");

    public By iphoneProduct = By.linkText("iPhone");

    public void productPage() { driver.findElement(iphoneProduct).click(); }

    public Single_Product_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText(); }

    public String getProductPrice() {return driver.findElement(productPrice).getText(); }

    public void addToWishList() {
        driver.findElement(wishlistBtn).click();
    }

    public void compareProduct() {
        driver.findElement(compareBtn).click();
    }

    public void addToCart() {
        driver.findElement(aTCBtn).click();
    }

    public void editQuantity(int number) {
        driver.findElement(quantityTxtBox).clear();
        driver.findElement(quantityTxtBox).sendKeys(String.valueOf(number));
    }

    public void description() {
        driver.findElement(descriptionBtn).click();
    }

    public void reviews() {
        driver.findElement(reviewsBtn).click();
    }

    public void review_YourName(String name) {
        driver.findElement(yourNameTxtBox).sendKeys(name);
    }

    public void review_YourReview(String name) {
        driver.findElement(yourReviewTxtBox).sendKeys(name);
    }

    public void rateRadioBtn() {
        //  driver.findElement(rateRadioBtn1).click();
        //  driver.findElement(rateRadioBtn2).click();
        //  driver.findElement(rateRadioBtn3).click();
        //  driver.findElement(rateRadioBtn4).click();
        driver.findElement(rateRadioBtn5).click();
    }

    public void continueBtn() {
        driver.findElement(continueReviewBtn).click();
    }


    public void assertWishListError() {
        Assert.assertTrue(driver.findElement(wishListErrorMsg).isDisplayed());
    }

    public void assertWishListSuccess() {
        String successMsg = driver.findElement(wishListSuccessMsg).getText();
        Assert.assertEquals(successMsg,"Success: You have added iPhone to your wish list!");
    }

    public void assertATCSuccess() {
        String successMsg = driver.findElement(aTCSuccessMsg).getText();
        Assert.assertEquals(successMsg,"Success: You have added iPhone to your shopping cart!");
    }

    public void assertReviewSuccess() {
        String successMsg = driver.findElement(reviewSuccessMsg).getText();
        Assert.assertEquals(successMsg,"Thank you for your review. It has been submitted to the webmaster for approval.");
    }
}