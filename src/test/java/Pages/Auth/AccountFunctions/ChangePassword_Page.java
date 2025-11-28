package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChangePassword_Page {
    WebDriver driver;
    public By PageTitle=By.xpath("//h1[text()='Change Password']");
    By password=By.xpath("//input[@id='input-password']");
    By confirmPassword=By.xpath("//input[@id='input-confirm']");
    By backBtn=By.xpath("//a[@class='btn btn-light']");
    By changeBtn=By.xpath("//button[text()='Continue']");
    public By passwordError=By.xpath("//div[@id='error-password']");
    public By confirmPasswordError=By.xpath("//div[@id='error-confirm']");
    public ChangePassword_Page(WebDriver driver){
        this.driver=driver;
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String confirmPassword){
        driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
    }

    public void back(){
        driver.findElement(backBtn).click();
    }

    public void changePassword(){
        driver.findElement(changeBtn).click();
    }

    public void assertEmptyPasswordError(){
        Assert.assertTrue(driver.findElement(passwordError).isDisplayed());
        Assert.assertTrue(driver.findElement(confirmPasswordError).isDisplayed());
    }

    public void assertEmptyConfirmPassword(){
        Assert.assertTrue(driver.findElement(confirmPasswordError).isDisplayed());
    }

    public void assertBothEmpty(){
        Assert.assertTrue(driver.findElement(passwordError).isDisplayed());
        Assert.assertTrue(driver.findElement(confirmPasswordError).isDisplayed());
    }
}

