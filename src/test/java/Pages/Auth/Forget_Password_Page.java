package Pages.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Forget_Password_Page {
    WebDriver driver;
    By email=By.xpath("//input[@id='input-email']");
    By backBtn=By.xpath("//a[@class='btn btn-light']");
    By continueBtn=By.xpath("//button[@type='submit']");
    By errorMessage=By.cssSelector(".alert.alert-danger.alert-dismissible");
    public Forget_Password_Page(WebDriver driver){
        this.driver=driver;
    }

    public void enterEmailAddress(String mail){
        driver.findElement(email).sendKeys(mail);
    }

    public void Back(){
        driver.findElement(backBtn).click();
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }

    public void assertError(){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
    }
}
