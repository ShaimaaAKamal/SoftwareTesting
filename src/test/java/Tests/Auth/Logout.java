package Tests.Auth;

import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout extends BaseTest {
    Home_Page home;
    @BeforeMethod
    public void preCondition(){
        home=new Home_Page(driver);
        driver.get(storeBaseUrl);
        home.clickMyAccount();
    }

    @Test
    public void logout(){
        driver.findElement(By.xpath("//a[@class='dropdown-item'][text()='Logout']")).click();
    }
}
