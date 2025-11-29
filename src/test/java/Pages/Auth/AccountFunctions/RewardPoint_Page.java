package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RewardPoint_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='Your Reward Points']");

    By continueBtn=By.xpath("//a[@class='btn btn-primary']");

    public RewardPoint_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }

    public void assertInOrderHistoryPage(){
        Assert.assertTrue(driver.findElement(pageTitle).isDisplayed());
    }
}
