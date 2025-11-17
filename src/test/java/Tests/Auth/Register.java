package Tests.Auth;

import Pages.Auth.Register_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register extends BaseTest {
    Register_Page register;
//    @BeforeTest
//    public void Before(){
//        register=new Register_Page(driver);
//    }
    @BeforeMethod
    public void preCondition(){
        driver.get("http://localhost:8888/opencartDemo/");
        driver.findElement(By.cssSelector(".fa-user")).click();
        driver.findElement(By.linkText("Register")).click();
        register=new Register_Page(driver);
    }

    //Register with valid data
    @Test(priority = 0)
    public void registerWithAllEmptyFields() throws InterruptedException {
        register.submitForm();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.id("error-firstname")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("error-lastname")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("error-email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("error-password")).isDisplayed());
    }

    //Register with valid data and without the toggle privacy button
    @Test(priority = 1)
    public void registerWithValidDataAndWithoutAgreeButton() throws InterruptedException{
        register.enterFirstName("alia");
        register.enterlastName("ahmed");
        register.enterMail();
        register.enterPassword("Test710@");
        register.submitForm();
        Thread.sleep(1000);
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"http://localhost:8888/opencartDemo/index.php?route=account/register&language=en-gb");
    }

    //Register with valid data
    @Test(priority = 2)
    public void registerWithValidData() throws InterruptedException {
        register.enterFirstName("alia");
        register.enterlastName("ahmed");
        register.enterMail();
        register.enterPassword("Test710@");
        register.togglePrivacy();
        register.submitForm();
        Thread.sleep(1000);
        String successMessage=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        Assert.assertEquals(successMessage,"Your Account Has Been Created!");
    }
}
