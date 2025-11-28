
package Pages.Admin.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Products_Page {

    WebDriver driver;

    public Products_Page(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- Locators ----------
    public By Catalog = By.linkText("Catalog");
    public By productsSection = By.xpath("//a[text()='Products']");
    public By pageTitle=By.xpath("//h1[text()='Products']");
    By addBtn = By.cssSelector("a.btn.btn-primary > i.fa-plus");
    By copyBtn = By.cssSelector("button.btn.btn-light > i.fa-copy");
    By deleteBtn = By.cssSelector(".btn-danger");
    By filterNameInput = By.id("input-name");
    By filterBtn = By.id("button-filter");

    public By successAlert =By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By firstRowCheckbox = By.cssSelector("table tbody tr:first-child input[type='checkbox']");
    By firstRowEditBtn =By.xpath("//*[@id=\"form-product\"]/div[1]/table/tbody/tr[1]/td[7]/div/a");

    // ---------- Actions ----------
    public  void openCatalog(){
        driver.findElement(Catalog).click();
    }
    public void openProductSection() {
        driver.findElement(productsSection).click();
    }

    public void clickAddNew() {
        driver.findElement(addBtn).click();
    }

    public void clickCopy() {
        driver.findElement(copyBtn).click();
    }

    public void clickDelete() {
        driver.findElement(deleteBtn).click();
        driver.switchTo().alert().accept();
    }

    public void filterByName(String productName) {
        WebElement name = driver.findElement(filterNameInput);
        name.clear();
        name.sendKeys(productName);
        driver.findElement(filterBtn).click();
    }

    public void selectFirstProduct() {
        driver.findElement(firstRowCheckbox).click();
    }

    public void openFirstProductForEdit() {
        driver.findElement(firstRowEditBtn).click();
    }

    public boolean successMessageVisible() {
        return driver.findElement(successAlert).isDisplayed();
    }

    public String getSuccessMessage() {
        return driver.findElement(successAlert).getText();
    }


    public void assertOpenProductScreen(){
        Assert.assertTrue(driver.getCurrentUrl().contains("product"));
    }

    public void assertNavigateToNewProductScreen(){
        Assert.assertTrue(driver.getCurrentUrl().contains("product.form"));
    }

    public void assertFilterFunctions(){
        Assert.assertTrue(driver.getCurrentUrl().contains("iphone"));
    }

    public void assertFirstProductSelection(){
        Assert.assertTrue(driver.findElement(By.cssSelector("table tbody tr:first-child input[type='checkbox']")).isSelected());
    }

    public void assertSuccess(){
        Assert.assertTrue(successMessageVisible());
    }

    public void assertOpenEdit(){
        Assert.assertTrue(driver.getCurrentUrl().contains("product.form"));
    }

}