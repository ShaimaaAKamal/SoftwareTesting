package Pages.Auth;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public Register_Page(WebDriver parentDriver){
        driver=parentDriver;
        firstName=driver.findElement(By.id("input-firstname"));
        lastName=driver.findElement(By.id("input-lastname"));
        mail=driver.findElement(By.id("input-email"));
        password=driver.findElement(By.id("input-password"));
        privacy = driver.findElement(By.xpath("//input[@name='agree']"));
        newsLetter=driver.findElement(By.xpath("//input[@id='input-newsletter']"));
        submit = driver.findElement(By.xpath("//button[@type='submit']"));
    }

    public  void enterFirstName(String name){
        firstName.sendKeys(name);
    }
    public  void enterlastName(String name){
        lastName.sendKeys(name);
    }

    public  void enterMail(){
        String mail=generateFakeEmail();
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

}
