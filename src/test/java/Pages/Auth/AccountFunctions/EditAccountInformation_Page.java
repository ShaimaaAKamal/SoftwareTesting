package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountInformation_Page {
    WebDriver driver;
   public  By pageTitle= By.xpath("//h1[text()='My Account Information']");
    By firstName=By.xpath("//input[@id='input-firstname']");
    By lastName=By.xpath("//input[@id='input-lastname']");
    By emailAddress=By.xpath("//input[@id='input-email']");
    By backBtn=By.xpath("//a[@class='btn btn-light']");
    By continueBtn=By.xpath("//button[@type='submit']");

    public EditAccountInformation_Page(WebDriver driver){
        this.driver=driver;
    }
    public void enterFirstName(String firstName){
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(this.lastName).sendKeys(lastName);
    }
    public void enterEmailAddress(String email){
        driver.findElement(this.emailAddress).sendKeys(email);
    }

    public void back(){
        driver.findElement(backBtn).click();
    }

    public void changeInformation(){
        driver.findElement(continueBtn).click();
    }
}
