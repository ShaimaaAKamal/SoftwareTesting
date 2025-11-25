package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_Page {
    WebDriver driver;
    By logout = By.cssSelector("#nav-logout > a");

    public Dashboard_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickLogout(){
        driver.findElement(logout).click();
    }

}
