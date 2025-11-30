package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Home_Page extends Base_Page{
    public By myAccount=By.cssSelector(".fa-user");
    By registerLink=By.linkText("Register");
    By loginLink=By.linkText("Login");
    By logoutLink=By.linkText("Logout");
    public By feature=By.xpath("//h3[text()='Featured']");
    public By accountLink=By.linkText("My Account");

    public Home_Page(WebDriver driver){
//        this.driver=driver;
        super(driver);
    }
    public void clickMyAccount(){
        scrollAndClick(myAccount);
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

    public boolean registerExists(){
        boolean exist= !driver.findElements(registerLink).isEmpty();
        return exist;
    }
}
