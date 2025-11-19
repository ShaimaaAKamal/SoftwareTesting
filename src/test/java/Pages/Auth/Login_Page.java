package Pages.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login_Page {
    WebDriver driver;
    By email=By.xpath("//input[@id='input-email']");
    By password=By.xpath("//input[@id='input-password']");
    By forgetPassword=By.xpath("//div[@class='col mb-3']//div[2]");
    By loginBtn=By.xpath("//button[@type='submit']");

    public Login_Page(WebDriver driver){
        this.driver=driver;
    }

    public void enterEmail(String email){
        driver.findElement(this.email).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }
    public void navigateToForgetPassword(){
        driver.findElement(forgetPassword).click();
    }
    public void submitForm(){
        driver.findElement(loginBtn).click();
    }

    public void assertLoginError(){
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed());
    }
    public void assertSuccessfulLogin(){

    }

}
