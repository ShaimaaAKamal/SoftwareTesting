//package Tests.Auth;
//
//import Pages.Auth.Register_Page;
//import Tests.BaseTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class Register extends BaseTest {
//    Register_Page register;
//
//    @BeforeMethod
//    public void preCondition(){
//        driver.get("http://localhost:8888/opencartDemo/");
//        driver.findElement(By.cssSelector(".fa-user")).click();
//        driver.findElement(By.linkText("Register")).click();
//        register=new Register_Page(driver);
//    }
//
//    //Register with Empty Fields
//
//    @Test(priority = 0)
//    public void registerWithEmptyFirstName() throws InterruptedException {
//        register.enterlastName("ahmed");
//        register.enterMail();
//        register.enterPassword("Test710@");
//        register.togglePrivacy();
//        register.submitForm();
//        Thread.sleep(1000);
//        register.asserTFirstNameError();
//    }
//
//    @Test(priority = 0)
//    public void registerWithEmptyLastName() throws InterruptedException {
//        register.enterFirstName("ahmed");
//        register.enterMail();
//        register.enterPassword("Test710@");
//        register.togglePrivacy();
//        register.submitForm();
//        Thread.sleep(1000);
//        register.asserTLasttNameError();
//    }
//
//    @Test(priority = 0)
//    public void registerWithEmptyEmail() throws InterruptedException {
//        register.enterFirstName("ahmed");
//        register.enterlastName("omar");
//        register.enterPassword("Test710@");
//        register.togglePrivacy();
//        register.submitForm();
//        Thread.sleep(1000);
//        register.asserTEmailError();
//    }
//
//    @Test(priority = 0)
//    public void registerWithEmptyPassword() throws InterruptedException {
//        register.enterFirstName("ahmed");
//        register.enterlastName("omar");
//        register.enterMail();
//        register.togglePrivacy();
//        register.submitForm();
//        Thread.sleep(1000);
//        register.asserTPasswordError();
//    }
//
//    @Test(priority = 0)
//    public void registerWithAllEmptyFields() throws InterruptedException {
//        register.submitForm();
//        Thread.sleep(1000);
//        register.assertAllEmptyFields();
//    }
//
//    //Register with valid data and without the toggle privacy button
//    @Test(priority = 0)
//    public void registerWithValidDataAndWithoutAgreeButton() throws InterruptedException{
//        register.enterFirstName("alia");
//        register.enterlastName("ahmed");
//        register.enterMail();
//        register.enterPassword("Test710@");
//        register.submitForm();
//        Thread.sleep(1000);
//        register.assertInvalidRegister();
//    }
//
//
////    @Test(priority = 0)
////    public void registerWithFirstNameExceedingMaxLength() throws InterruptedException {
////        register.enterFirstName("Superduperultramegatasticwordddd");
////        register.enterlastName("ahmed");
////        register.enterMail();
////        register.enterPassword("Test710@");
////        register.togglePrivacy();
////        register.submitForm();
////        Thread.sleep(1000);
////        register.asserTFirstNameError();
////    }
////
////    @Test(priority = 0)
////    public void registerWithLastNameExceddingMaxLength() throws InterruptedException {
////        register.enterFirstName("ahmed");
////        register.enterlastName("Superduperultramegatasticwordddd");
////        register.enterMail();
////        register.enterPassword("Test710@");
////        register.togglePrivacy();
////        register.submitForm();
////        Thread.sleep(1000);
////        register.asserTLasttNameError();
////    }
//
//    //Register with valid data
//    @Test(priority = 2)
//    public void registerWithValidData() throws InterruptedException {
//        register.enterFirstName("alia");
//        register.enterlastName("ahmed");
//        register.enterMail();
//        register.enterPassword("Test710@");
//        register.togglePrivacy();
//        register.submitForm();
//        Thread.sleep(1000);
//       register.assertSuccessfulRegister();
//    }
//}

package Tests.Auth;

import Pages.Auth.Register_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Register extends BaseTest {

    Register_Page register;
    WebDriverWait wait;

    @BeforeMethod
    public void preCondition(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8888/opencartDemo/");
        driver.findElement(By.cssSelector(".fa-user")).click();
        driver.findElement(By.linkText("Register")).click();
        register = new Register_Page(driver);
    }

    // 🔹 Helper wait method for visibility
    public void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Register with Empty Fields
    @Test(priority = 0)
    public void registerWithEmptyFirstName() {
        register.enterlastName("ahmed");
        register.enterMail();
        register.enterPassword("Test710@");
        register.togglePrivacy();
        register.submitForm();

        waitForVisible(By.id("error-firstname"));
        register.asserTFirstNameError();
    }

    @Test(priority = 0)
    public void registerWithEmptyLastName() {
        register.enterFirstName("ahmed");
        register.enterMail();
        register.enterPassword("Test710@");
        register.togglePrivacy();
        register.submitForm();

        waitForVisible(By.id("error-lastname"));
        register.asserTLasttNameError();
    }

    @Test(priority = 0)
    public void registerWithEmptyEmail() {
        register.enterFirstName("ahmed");
        register.enterlastName("omar");
        register.enterPassword("Test710@");
        register.togglePrivacy();
        register.submitForm();

        waitForVisible(By.id("error-email"));
        register.asserTEmailError();
    }

    @Test(priority = 0)
    public void registerWithEmptyPassword() {
        register.enterFirstName("ahmed");
        register.enterlastName("omar");
        register.enterMail();
        register.togglePrivacy();
        register.submitForm();

        waitForVisible(By.id("error-password"));
        register.asserTPasswordError();
    }

    @Test(priority = 0)
    public void registerWithAllEmptyFields() {
        register.submitForm();

        // Wait for any one error (first name error)
        waitForVisible(By.id("error-firstname"));

        register.assertAllEmptyFields();
    }


    //Register with valid data and without the toggle privacy button
    @Test(priority = 0)
    public void registerWithValidDataAndWithoutAgreeButton(){
        register.enterFirstName("alia");
        register.enterlastName("ahmed");
        register.enterMail();
        register.enterPassword("Test710@");
        register.submitForm();

        // Wait for URL to stay same (form reload)
        wait.until(ExpectedConditions.urlContains("route=account/register"));

        register.assertInvalidRegister();
    }

//    //Register with valid data
//    @Test(priority = 2)
//    public void registerWithValidData() {
//        register.enterFirstName("alia");
//        register.enterlastName("ahmed");
//        register.enterMail();
//        register.enterPassword("Test710@");
//        register.togglePrivacy();
//        register.submitForm();
//
//        // Wait for success message
//        waitForVisible(By.xpath("//*[@id='content']/h1"));
//
//        register.assertSuccessfulRegister();
//    }
}