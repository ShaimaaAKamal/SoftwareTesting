package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class wishlist_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='My Wishlist']");

    By continueBtn=By.xpath("//a[@class='btn btn-primary']");

    public wishlist_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }
}
