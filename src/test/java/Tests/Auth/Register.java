package Tests.Auth;

import Pages.Auth.Register_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Register extends BaseTest {

    Register_Page register;
    Home_Page home;
    @BeforeMethod
    public void preCondition(){
        driver.get(storeBaseUrl);
        home =new Home_Page(driver);
        home.clickMyAccount();
        if(!home.registerExists())
            home.clickLogout();
        home.clickRegitser();
        register = new Register_Page(driver);
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
//        wait.until(ExpectedConditions.urlContains("route=account/register"));
        register.assertInvalidRegister();
    }


    //Register with valid data
    @Test(priority = 2 )
    public void registerWithValidData() throws InterruptedException {
        register.enterFirstName("alia");
        register.enterlastName("ahmed");
        register.enterMail();
        register.enterPassword("Test710@");
        register.togglePrivacy();
        register.submitForm();
        wait.until(ExpectedConditions.urlContains("route=account/success"));
        waitForVisible(By.xpath("//*[@id='content']/h1"));
        register.assertSuccessfulRegister();
    }


    @Test(priority = 1)
    public void registerWithFirstNameExceedingMaxLength() throws InterruptedException {
        register.enterFirstName("Superduperultramegatasticwordddd");
        register.enterlastName("ahmed");
        register.enterMail();
        register.enterPassword("Test710@");
        register.togglePrivacy();
        register.submitForm();
        waitForVisible(By.id("error-firstname"));
        register.asserTFirstNameError();
    }

    @Test(priority =1)
    public void registerWithLastNameExceddingMaxLength() throws InterruptedException {
        register.enterFirstName("ahmed");
        register.enterlastName("Superduperultramegatasticwordddd");
        register.enterMail();
        register.enterPassword("Test710@");
        register.togglePrivacy();
        register.submitForm();
        waitForVisible(By.id("error-lastname"));
        register.asserTLasttNameError();
    }
}