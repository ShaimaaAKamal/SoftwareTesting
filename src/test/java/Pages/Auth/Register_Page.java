package Pages.Auth;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Register_Page {
    WebDriver driver;
    WebElement firstName;
    WebElement lastName;
    WebElement mail;
    WebElement password;
    WebElement privacy ;
    WebElement newsLetter;
    WebElement submit;
    Faker faker = new Faker();
    public static String currentEmail="";

    public Register_Page(WebDriver parentDriver){
        driver=parentDriver;
        firstName=driver.findElement(By.id("input-firstname"));
        lastName=driver.findElement(By.id("input-lastname"));
        mail=driver.findElement(By.id("input-email"));
        password=driver.findElement(By.id("input-password"));
        privacy = driver.findElement(By.xpath("//input[@name='agree']"));
        newsLetter=driver.findElement(By.xpath("//input[@id='input-newsletter']"));
        submit = driver.findElement(By.xpath("//button[text()='Continue']"));
    }

    public  void enterFirstName(String name){
        firstName.sendKeys(name);
    }
    public  void enterlastName(String name){
        lastName.sendKeys(name);
    }

    public  void enterMail(){
        String mail=generateFakeEmail();
        currentEmail=mail;
        this.mail.sendKeys(mail);
    }
    public  void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public  void togglePrivacy(){
        privacy.click();
    }
    public  void toggleNewsLetters(){
        newsLetter.click();
    }
    public  void submitForm(){
        submit.click();
    }


    public String generateFakeEmail() {
        return faker.internet().emailAddress();
    }

    public void asserTFirstNameError(){
        Assert.assertTrue(driver.findElement(By.id("error-firstname")).isDisplayed());
    }
    public void asserTLasttNameError(){
        Assert.assertTrue(driver.findElement(By.id("error-lastname")).isDisplayed());
    }
    public void asserTEmailError(){
        Assert.assertTrue(driver.findElement(By.id("error-email")).isDisplayed());
    }
    public void asserTPasswordError(){
        Assert.assertTrue(driver.findElement(By.id("error-password")).isDisplayed());
    }
    public void assertAllEmptyFields(){
        asserTFirstNameError();
        asserTLasttNameError();
        asserTEmailError();
        asserTPasswordError();
    }
    public void assertInvalidRegister(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"http://localhost:8888/opencart/index.php?route=account/register&language=en-gb");
    }

    public void assertSuccessfulRegister(){
        String successMessage=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        Assert.assertEquals(successMessage,"Your Account Has Been Created!");
    }


}
