package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AffilateAccount_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='Your Affiliate Information']");

    By continueBtn=By.xpath("//button[@type='submit']");

    public AffilateAccount_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }
}
