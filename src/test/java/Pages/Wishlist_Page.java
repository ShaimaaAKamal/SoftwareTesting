package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Wishlist_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='My Wishlist']");
    By RemoveBtn=By.xpath("//button[@class='btn btn-danger']");
    By addToCartBtn=By.xpath("//i[@class='fa-solid fa-cart-shopping fa-fw']");
    By continuebtn=By.xpath("//a[@class='btn btn-primary']");
    public By successMessage=By.xpath("alert alert-success");
    public By emptyMessage=By.xpath("//p[text()='Your wish list is empty.']");
    public Wishlist_Page(WebDriver driver){
        this.driver=driver;
    }
    public int wishlistProductsCount(){
        List<WebElement> products=driver.findElements(RemoveBtn);
        System.out.println(products.size());
        return products.size();
    }

    public void RemoveFromWishlistUsingIndex(int index){
        List<WebElement> productsRemoveIcon=driver.findElements(RemoveBtn);
        productsRemoveIcon.get(index).click();
    }
    public void addWishlisProductToCarttUsingIndex(int index){
        List<WebElement> productsCartIcon=driver.findElements(addToCartBtn);
        System.out.println(productsCartIcon.size());
        productsCartIcon.get(index).click();
    }
   public void continueBtn(){
        driver.findElement(continuebtn).click();
   }
}
