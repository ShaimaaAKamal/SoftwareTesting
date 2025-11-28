package Pages.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Forget_Password_Page {
    WebDriver driver;
    public By email=By.xpath("//input[@id='input-email']");
    public By backBtn=By.cssSelector("a[class='btn btn-light']");
    public By continueBtn=By.xpath("//button[text()='Continue']");
    public By errorMessage=By.cssSelector(".alert.alert-danger.alert-dismissible");

    Login_Page loginPage;
    public Forget_Password_Page(WebDriver driver){
        this.driver=driver;
        loginPage=new Login_Page(driver);
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

    public void assertBackToLogin(){
        Assert.assertTrue(driver.findElement(loginPage.email).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.password).isDisplayed());
    }

    public void assertSuccessMessage(){
        Assert.assertTrue(driver.findElement(loginPage.successForgetPasswordMessage).isDisplayed());
    }
}
