package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EditAccountInformation_Page {
    WebDriver driver;
   public  By pageTitle= By.xpath("//h1[text()='My Account Information']");
    By firstName=By.xpath("//input[@id='input-firstname']");
    By lastName=By.xpath("//input[@id='input-lastname']");
    By emailAddress=By.xpath("//input[@id='input-email']");
    By backBtn=By.xpath("//a[@class='btn btn-light']");
    By continueBtn=By.xpath("//button[text()='Continue']");

    public EditAccountInformation_Page(WebDriver driver){
        this.driver=driver;
    }
    public void enterFirstName(String firstName){
        driver.findElement(this.firstName).sendKeys(firstName);
    }
    public void clearFirstName(){
        driver.findElement(this.firstName).clear();
    }
    public void enterLastName(String lastName){
        driver.findElement(this.lastName).sendKeys(lastName);
    }
    public void clearLastName(){
        driver.findElement(this.lastName).clear();
    }
    public void enterEmailAddress(String email){
        driver.findElement(this.emailAddress).sendKeys(email);
    }
    public void clearEmailAddress(){
        driver.findElement(emailAddress).clear();
    }

    public void back(){
        driver.findElement(backBtn).click();
    }

    public void changeInformation(){
        driver.findElement(continueBtn).click();
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

    public void assertAllEmptyFields(){
        asserTFirstNameError();
        asserTLasttNameError();
        asserTEmailError();
    }
}
