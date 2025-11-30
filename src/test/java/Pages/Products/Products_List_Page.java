package Pages.Products;


import org.openqa.selenium.*;
        import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Products_List_Page {
    public WebDriver driver;
    public WebDriverWait wait;


    public Products_List_Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public By gridView = By.id("button-grid");
    public By listView = By.id("button-list");
    public By sortBy = By.id("input-sort");
    public By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public By macbookAddToCompare = By.xpath("//div[7]//div[1]//div[2]//form[1]//div[1]//button[3]");
    public By iphoneAddToCompare = By.cssSelector("body > div:nth-child(1) > main:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > button:nth-child(3)");
    public By macbookAddToCart = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[7]/div[1]/div[2]/form[1]/div[1]/button[1]");
    public By iphoneAddToCart = By.cssSelector("body > div:nth-child(1) > main:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
    public By macbookAddToWishList = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[4]/div[7]/div[1]/div[2]/form[1]/div[1]/button[2]");
    public By iphoneAddToWishList = By.cssSelector("body > div:nth-child(1) > main:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > button:nth-child(2)");
    public By pageTwo = By.cssSelector("ul.pagination li:nth-child(3) a");


    public void GridView_list(){
        wait.until(ExpectedConditions.elementToBeClickable(gridView)).click();
    }


    public void ListView_list(){
        wait.until(ExpectedConditions.elementToBeClickable(listView)).click();
    }


    public void SortBy_list(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortBy));
        Select select = new Select(driver.findElement(sortBy));
        if(select.getOptions().size() > 1){
            select.selectByIndex(1);
        }
    }


    public void Qunatity_list(){
        try {
            WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-thumb:first-of-type input[name='quantity']")));
            qty.clear();
            qty.sendKeys("2");
            WebElement add = driver.findElement(By.cssSelector("div.product-thumb:first-of-type button[onclick*='cart.add']"));
            scrollTo(add);
            add.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        }catch(Exception ignored){}
    }


    public void NextPage(){
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(pageTwo));
        scrollTo(next);
        next.click();
    }


    public void AddToComparisonList_MacBook(){
        addToCartFromTestLocator(macbookAddToCompare, "MacBook");
    }


    public void AddToComparisonList_iPhone(){
        addToCompareFromTestLocator(iphoneAddToCompare,"iPhone");
    }


    private void addToCompareFromTestLocator(By locator, String name) {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
            scrollTo(btn);
            btn.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        } catch (Exception e){
            addToCompare(name);
        }
    }


    public void AddToWishList_iPhone(){
        addToWishlistFromTestLocator(iphoneAddToWishList,"iPhone");
    }
    public void AddToWishList_Macbook(){
        addToWishlistFromTestLocator(macbookAddToWishList,"iPhone");
    }


    public void AddToCart_iPhone(){
        addToCartFromTestLocator(iphoneAddToCart, "iPhone");
    }


    public void AddToCart_MacBook(){
        addToCartFromTestLocator(macbookAddToCart, "MacBook");
    }



    public void AssertSuccessful_AddTo_Cart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }


    public void AssertSuccessful_AddTo_WishList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }


    private void addToCartFromTestLocator(By locator, String name){
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
            scrollTo(btn);
            btn.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        }catch(Exception e){
            addToCart(name);
        }
    }


    private void addToCart(String product){
        WebElement productBox = findProduct(product);
        WebElement btn = productBox.findElement(By.xpath(".//button[contains(@onclick,'cart.add')]"));
        scrollTo(btn);
        btn.click();
    }


    private void addToCompare(String product){
        WebElement productBox = findProduct(product);
        WebElement btn = productBox.findElement(By.xpath(".//button[contains(@onclick,'compare.add')]"));
        scrollTo(btn);
        btn.click();
    }


    private void addToWishlistFromTestLocator(By locator, String name){
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
            scrollTo(btn);
            btn.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        }catch(Exception e){
            addToWishlist(name);
        }
    }
    private void addToWishlist(By locator) {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(locator));
        scrollTo(btn);
        btn.click();
    }
    private void addToWishlist(String product){
        WebElement productBox = findProduct(product);
        WebElement btn = productBox.findElement(By.xpath(".//button[contains(@onclick,'wishlist.add')]"));
        scrollTo(btn);
        btn.click();
    }


    private WebElement findProduct(String name){
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'product-thumb')]//a[normalize-space()='" + name + "']/ancestor::div[contains(@class,'product-thumb')]")));
    }


    private void scrollTo(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({behavior:'instant', block:'center'})", element);
    }
}
