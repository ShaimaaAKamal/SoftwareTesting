package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBook_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='Address Book Entries']");

    By backBtn=By.xpath("//a[@class='btn btn-light']");
    By newAddress=By.xpath("//a[@class='btn btn-primary']");

    public AddressBook_Page(WebDriver driver){
        this.driver=driver;
    }

    public void back(){
        driver.findElement(backBtn).click();
    }

    public void addNewAddress(){
        driver.findElement(newAddress).click();
    }
}
