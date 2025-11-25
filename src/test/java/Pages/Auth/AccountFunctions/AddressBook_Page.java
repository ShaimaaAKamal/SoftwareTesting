package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressBook_Page {
    WebDriver driver;
    public By pageTitle = By.xpath("//h1[text()='Address Book Entries']");

    By backBtn = By.xpath("//a[@class='btn btn-light']");
    By newAddress = By.xpath("//a[text()='New Address']");
    By trashIcon = By.cssSelector("a[title='Delete']");
    By editIcon = By.cssSelector("a[title='Edit']");
    public By errorMessage=By.cssSelector(".alert.alert-danger.alert-dismissible");
    public AddressBook_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void back() {
        WebElement button = driver.findElement(backBtn);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // Add small delay to ensure layout stabilizes
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        // Click using JS to bypass overlays
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
//        driver.findElement(backBtn).click();
    }

    public void addNewAddress() {
        WebElement button = driver.findElement(newAddress);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // Add small delay to ensure layout stabilizes
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        // Click using JS to bypass overlays
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
//        driver.findElement(newAddress).click();
    }


    public int addressesCount() {
        List<WebElement> trashs = driver.findElements(trashIcon);
        return trashs.size();
    }

    public void deleteOnlyAddress() {
        List<WebElement> trashs = driver.findElements(trashIcon);
        trashs.getFirst().click();
    }
    public void deleteAddressUsingIndex(int index) {
        List<WebElement> trashs = driver.findElements(trashIcon);
        trashs.get(index).click();
    }
}
