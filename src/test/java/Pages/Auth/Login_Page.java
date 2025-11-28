package Pages.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login_Page {
    WebDriver driver;
    By email=By.xpath("//input[@id='input-email']");
    public By password=By.xpath("//input[@id='input-password']");
    By forgetPassword=By.linkText("Forgotten Password");
//    By loginBtn=By.xpath("//button[@type='submit']");
    By loginBtn = By.xpath("//button[text()='Login']");

    public  By successForgetPasswordMessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By errorMessage=By.cssSelector(".alert-danger");
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
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
    }
    public void assertSuccessfulLogin(){

    }

}
