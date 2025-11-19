package Tests.Auth;

import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logout extends BaseTest {
    WebDriverWait wait;
    Home_Page home;
    @BeforeMethod
    public void preCondition(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        home=new Home_Page(driver);
        driver.get("http://localhost:8888/opencartDemo/");
        home.clickMyAccount();
    }

    @Test
    public void logout(){
        driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']")).click();

    }
}
