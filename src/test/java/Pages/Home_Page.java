package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Home_Page {
    WebDriver driver;
    public By myAccount=By.cssSelector(".fa-user");
    By registerLink=By.linkText("Register");
    By loginLink=By.linkText("Login");
    By logoutLink=By.linkText("Logout");
    public By feature=By.xpath("//h3[text()='Featured']");
    public By accountLink=By.linkText("My Account");

    public Home_Page(WebDriver driver){
        this.driver=driver;
    }
    public void clickMyAccount(){
        scrollAndClick(myAccount);
//        driver.findElement(myAccount).click();
    }

    public void clickRegitser(){
        driver.findElement(registerLink).click();
    }

    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public void clickLogout(){
        driver.findElement(logoutLink).click();
    }

    public void clickAccountLink(){
        driver.findElement(accountLink).click();

    }

    public void scrollAndClick(By locator){
        WebElement button = driver.findElement(locator);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // Add small delay to ensure layout stabilizes
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        // Click using JS to bypass overlays
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public boolean registerExists(){
        boolean exist= !driver.findElements(registerLink).isEmpty();
        return exist;
    }
}
