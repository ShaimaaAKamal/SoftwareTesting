package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cart_Page {
    WebDriver driver;

    // Constructor //
    public Cart_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators //
    By MyAccount_Icon = By.cssSelector(".fa-user");
    By Login_Icon = By.linkText("Login");
    By AddToCart_Button = By.xpath("//a[@title='Shopping Cart']");
    public By Success_Message = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");
    By Cart_Icon = By.xpath("//button[@data-bs-toggle=\"dropdown\"]");
    public By ViewCart_Icon =By.xpath("//a[@href=\"http://localhost:8080/opencartDemo/index.php?route=checkout/cart&language=en-gb\"]");
//    public By productCartIcon =By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/button[1]");
   public By productCartIcon = By.xpath("//div[@id='content']//div[1]//div[1]//div[2]//form[1]//div[1]//button[1]");
//By productCartIcon = By.xpath("(//h3[text()='Featured']/following::button[@aria-label='Add to Cart'])[1]");
    By Total_Cart_value = By.xpath("//td[@class=\"text-end\"]");
    By Remove_Button=By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/form[1]/div[1]/button[2]");
    By Modify_Quantity =By.name("quantity");
    public By Modify_Message = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By Update_Button = By.xpath("//i[@class=\"fa-solid fa-rotate\"]");
    public By OutOfStock_Message =By.xpath("//i[@class=\"fa-solid fa-circle-exclamation\"]");
   public By emptyCartMessage=By.xpath("//p[text()='Your shopping cart is empty!']");

    //  Actions //
    public void ClickAddToCartButton(){
        WebElement button = driver.findElement(productCartIcon);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // Add small delay to ensure layout stabilizes
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        // Click using JS to bypass overlays
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }


    public void AddToCart(){
        driver.findElement(AddToCart_Button).click();
    }
    public void ClickMyAccountIcon(){
        driver.findElement(MyAccount_Icon).click();
    }
    public void ClickLoginIcon(){
        driver.findElement(Login_Icon).click();
    }
    public String getSuccessMessage(){
        return driver.findElement(Success_Message).getText();
    }

    public void ClickOnCartIcon(){
        driver.findElement(Cart_Icon).click();
    }

    public void ClickViewCartIcon(){
        driver.findElement((ViewCart_Icon)).click();
    }

    public String getCartTotal(){
        return driver.findElement(Total_Cart_value).getText();
    }
    public void RemoveFromCart(){
        driver.findElement(Remove_Button).click();
    }
    public void ModifyQuantity(String quantityNum){
        driver.findElement(Modify_Quantity).clear();
        driver.findElement(Modify_Quantity).sendKeys(quantityNum);
    }
    public void ClickUpdateButton(){
        driver.findElement(Update_Button).click();
    }


    // Assertion //
    public void assertSuccessMessageDisplay() {
        Assert.assertTrue(driver.findElement(Success_Message).isDisplayed());
    }

//    public void assertRemoveMessageDispaly(){
//        Assert.assertTrue(driver.findElement(Remove_Message).isDisplayed());
//    }
    public void assertModifyQuantityMessageDisplay(){
        Assert.assertTrue(driver.findElement((Modify_Message)).isDisplayed());
    }
    public void assertOutOfStockMessage(){
        Assert.assertTrue(driver.findElement(OutOfStock_Message).isDisplayed());
    }

        public void assertEmptyCartMessageDispaly(){
        Assert.assertTrue(driver.findElement(emptyCartMessage).isDisplayed());
    }

}