package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin_Login_Page {
    WebDriver driver;
    By adminUsername= By.xpath("//input[@id='input-username']");
    By password=By.xpath("//input[@id='input-password']");
    By loginBtn=By.xpath("//button[@type='submit']");
    public By errorMessage=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    public Admin_Login_Page(WebDriver driver){
        this.driver=driver;
    }

    public void enterUsername(String mail){
        driver.findElement(adminUsername).sendKeys(mail);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clearUsername(){
        driver.findElement(adminUsername).clear();
    }

    public void clearPassword(){
        driver.findElement(password).clear();
    }

    public void clearAll(){
        clearPassword();
        clearUsername();
    }
    public void submitForm(){
        driver.findElement(loginBtn).click();
    }


}
