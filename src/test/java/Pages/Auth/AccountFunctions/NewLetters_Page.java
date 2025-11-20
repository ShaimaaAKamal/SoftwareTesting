package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewLetters_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='Newsletter Subscription']");

    By continueBtn=By.xpath("//button[@type='submit']");
    By backBtn=By.xpath("//a[@class='btn btn-light']");

    public NewLetters_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }

    public void back(){
        driver.findElement(backBtn).click();
    }
}
