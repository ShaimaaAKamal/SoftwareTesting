package Pages.Admin.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Single_Product_Page {

    WebDriver driver;

    public Single_Product_Page(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- Locators ----------
    public   By productNameInput = By.id("input-name-1");
    public By metaTitleInput = By.id("input-meta-title-1");

    // Description iframe
    public By descriptionIframe = By.cssSelector("iframe.cke_wysiwyg_frame");
    public By descriptionBody = By.tagName("body");

    // Tabs
    By dataTab = By.xpath("//a[text()='Data']");

    // Data Tab Inputs
    public By modelInput = By.id("input-model");
    public By priceInput = By.id("input-price");
    public By quantityInput = By.id("input-quantity");

    // Save Button
    By saveBtn = By.cssSelector("button.btn.btn-primary > i.fa-floppy-disk");
    public By successAlert =By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By errorAlert =By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    public  By seoInput=By.id("input-keyword-0-1");
    By seoTab = By.xpath("//a[text()='SEO']");

    // ---------- Actions ----------
    public void enterProductName(String name) {
        WebElement el = driver.findElement(productNameInput);
        el.clear();
        el.sendKeys(name);
    }

    public void enterMetaTitle(String title) {
        WebElement el = driver.findElement(metaTitleInput);
        el.clear();
        el.sendKeys(title);
    }

    public void enterDescription(String text) {
        WebElement frame = driver.findElement(descriptionIframe);
        driver.switchTo().frame(frame);
        WebElement body = driver.findElement(descriptionBody);
        body.clear();
        body.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void openDataTab() {
        driver.findElement(dataTab).click();
    }
    public void openSEOab() {
        driver.findElement(seoTab).click();
    }

    public void enterSeoData(String key) {
        WebElement el = driver.findElement(seoInput);
        el.clear();
        el.sendKeys(key);
    }

    public void enterModel(String model) {
        WebElement el = driver.findElement(modelInput);
        el.clear();
        el.sendKeys(model);
    }

    public void enterPrice(String price) {
        WebElement el = driver.findElement(priceInput);
        el.clear();
        el.sendKeys(price);
    }

    public void enterQuantity(String quantity) {
        WebElement el = driver.findElement(quantityInput);
        el.clear();
        el.sendKeys(quantity);
    }

    public void clickSave() {
        driver.findElement(saveBtn).click();
    }

    public void assertSuccess(){
        Assert.assertTrue(driver.findElement(successAlert).isDisplayed());
    }

    public void assertError(){
        Assert.assertTrue(driver.findElement(errorAlert).isDisplayed());
    }

    public void assertDataFields(){
        Assert.assertEquals(driver.findElement(modelInput).getAttribute("value"), "TP-001");
        Assert.assertEquals(driver.findElement(priceInput).getAttribute("value"), "99.99");
        Assert.assertEquals(driver.findElement(quantityInput).getAttribute("value"), "10");
    }

    public void assertName(){
        Assert.assertEquals(driver.findElement(productNameInput).getAttribute("value"), "Test Product");
        Assert.assertEquals(driver.findElement(metaTitleInput).getAttribute("value"), "Test Meta Title");
    }

    public void assertDescription(String desc){
        Assert.assertEquals(desc, "This is a test description.");

    }
}