package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Cart_Page extends Base_Page {

    // Constructor //
    public Cart_Page(WebDriver driver) {
        super(driver);
    }

    // Locators //
    public By pageTitle = By.xpath("//h1[contains(text(), 'Shopping Cart')]");
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
    By Remove_Button=By.xpath("(//a[@class='btn btn-danger'])[1]");
    By Modify_Quantity =By.name("quantity");
    public By Modify_Message = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By Update_Button = By.xpath("//i[@class=\"fa-solid fa-rotate\"]");
    public By OutOfStock_Message =By.xpath("//i[@class=\"fa-solid fa-circle-exclamation\"]");
   public By emptyCartMessage=By.xpath("//p[text()='Your shopping cart is empty!']");
    By Navigate_To_Product_Page = By.xpath("(//tr//a[contains(@href, 'product_id')])[1]");
    By Shopping_Cart_icon =By.xpath("//i[@class=\"fa-solid fa-cart-shopping\"]");
    By Click_CheckOut_Button =By.xpath("//a[@class=\"btn btn-primary\"]");
    By ClickOn_AnOptioned_Product = By.linkText("Canon EOS 5D");
    By Select_Dropdown_Button = By.id("input-option-226");
    By Select_Option = By.xpath("//option[@value=\"16\"]");
    By Click_Product_AddToCartButton =By.id("button-cart");
    By closeBtn=By.cssSelector(".btn-close");
    //  Actions //

    public void close(){
        scrollAndClick(closeBtn);
    }
    public void ClickAddToCartButton(){
        scrollAndClick(productCartIcon);
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

    public void NavigateToProductPage(){
        scrollAndClick(Navigate_To_Product_Page);
    }
    public void ClickOnShoppingCartIcon(){
        scrollAndClick(Shopping_Cart_icon);
    }



    public void ClickCheckOutButton(){
        scrollAndClick(Click_CheckOut_Button);
    }

    public void ClickOnAnOptionedProduct(){
        scrollAndClick(ClickOn_AnOptioned_Product);
    }
    public void SelectDropdownButton(){
        WebElement dropDown= driver.findElement(Select_Dropdown_Button);
        dropDown.click();
        Select options=new Select(dropDown);
        options.selectByVisibleText("Red");
    }


    public  void ClickProductAddToCartButton(){
        scrollAndClick(Click_Product_AddToCartButton);
    }


    // Assertion //
    public void assertSuccessMessageDisplay() {
        Assert.assertTrue(driver.findElement(Success_Message).isDisplayed());
    }

    public void assertModifyQuantityMessageDisplay(){
        Assert.assertTrue(driver.findElement((Modify_Message)).isDisplayed());
    }
    public void assertOutOfStockMessage(){
        Assert.assertTrue(driver.findElement(OutOfStock_Message).isDisplayed());
    }

        public void assertEmptyCartMessageDispaly(){
        Assert.assertTrue(driver.findElement(emptyCartMessage).isDisplayed());
    }

    public void assertNavigateToProductPageFromCart(){
        Assert.assertTrue(driver.getCurrentUrl().contains("product_id"),
                "URL does NOT contain product_id!");    }


    public void assertTotalDisplayTaxDetails(){
        Assert.assertTrue(driver.findElement(By.xpath("//td[@colspan=\"4\"]")).isDisplayed());
    }
    public void assertOptionedProductAddedToCartSuccessfully(){
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class=\"text-start text-wrap\"]")).isDisplayed());
    }
    public void assertUserNavigateToCheckOutPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"),
                "URL does NOT contain checkout!");
    }


}