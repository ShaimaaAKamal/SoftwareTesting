package Tests.Auth;

import Pages.Auth.Login_Page;
import Pages.Auth.Register_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login extends BaseTest {
    Login_Page login;
    WebDriverWait wait;
    Home_Page home;
    @BeforeMethod
    public void preCondition(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8888/opencartDemo/");
        home=new Home_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login = new Login_Page(driver);
    }

    // 🔹 Helper wait method for visibility
    public void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Test(priority = 0)
    public void loginWithEmptyEmail() {

        login.enterPassword("Test710@");
        login.submitForm();
        waitForVisible(By.cssSelector(".alert-danger"));
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginWithEmptyPassword() {
        login.enterEmail("temo@gmail.com");
        login.submitForm();
        waitForVisible(By.cssSelector(".alert-danger"));
        login.assertLoginError();
    }
//
    @Test(priority = 0)
    public void loginWithAllEmptyFields() {
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(By.cssSelector(".alert-danger"));
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginvalidEmailAndInvalidPassword() {
        login.enterEmail("temo@gmail.com");
        login.enterPassword("tejd@345");
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(By.cssSelector(".alert-danger"));
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginInvalidEmailAndvalidPassword() {
        login.enterEmail("teko@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(By.cssSelector(".alert-danger"));
        login.assertLoginError();
    }

    @Test(priority = 0)
    public void loginInvalidEmailAndInvalidPassword() {
        login.enterEmail("teko@gmail.com");
        login.enterPassword("Test810@");
        login.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(By.cssSelector(".alert-danger"));
        login.assertLoginError();
    }

    @Test(priority = 1)
    public void loginWithvalidEmailAndvalidPassword() {
        login.enterEmail("temo@gmail.com");
        login.enterPassword("Test710@");
        login.submitForm();
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("route=account/login")
        ));
    }


}
