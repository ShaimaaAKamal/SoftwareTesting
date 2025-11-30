package Pages.Admin;

import Pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_Page extends Base_Page {
    public By logout = By.cssSelector("#nav-logout > a");

    public Dashboard_Page(WebDriver driver){
        super(driver);
    }

    public void clickLogout(){
        scrollAndClick(logout);
    }

}
