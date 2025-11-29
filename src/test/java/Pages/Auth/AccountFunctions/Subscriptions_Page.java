package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Subscriptions_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='Subscriptions']");

    By continueBtn=By.xpath("//a[@class='btn btn-primary']");

    public Subscriptions_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }

    public void assertInOrderHistoryPage(){
        Assert.assertTrue(driver.findElement(pageTitle).isDisplayed());
    }
}
