package Tests.Products;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Cart_Page;
import Pages.Home_Page;
import Pages.Products.Products_List_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Product_List extends BaseTest {
    Products_List_Page productList;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;
    Cart_Page cartPage;
    @BeforeClass
    public void Setup() {
        productList = new Products_List_Page(driver);
        home = new Home_Page(driver);
        login = new Login_Page(driver);
        accountPage = new Account_Page(driver);
        cartPage = new Cart_Page(driver);
    }

    @BeforeMethod
    public void preconditions ()
    {
        driver.get(storeBaseUrl);

        // Go to login page
        home.clickMyAccount();
        home.clickLogin();
        // Login
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        waitForVisible(accountPage.editInformation);
        // Naigating to Product-List //
        driver.findElement(By.cssSelector(".nav-link.dropdown-toggle[href='http://localhost:8888/opencart/index.php?route=product/category&language=en-gb&path=20']")).click();
        By DesktopMenu = By.xpath("//div[@class='dropdown-menu dropdown-column-1 show']");
        waitForVisible(DesktopMenu);
        driver.findElement(By.xpath("//a[normalize-space()='Show All Desktops']")).click();
    }
    @AfterMethod
    public void after(){
//      driver.get("http://localhost:8888/opencart/");
        home.clickMyAccount();
        home.clickLogout();
    }
    /// ////////////////// Scrolling inside the page ////////////////////
    public void scrollToElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until the element is present in the DOM
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        // Scroll the element into view
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

        // Optional: wait until the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    @Test(priority = 1)
    public void TestingGridView (){
        waitForVisible(productList.gridView);
        productList.GridView_list();
    }
    @Test(priority = 2)
    public void TestingListView (){
        productList.ListView_list();
    }
    @Test(priority = 3)
    public void TestingSortByList(){
        productList.SortBy_list();
    }
    @Test(priority = 4)
    public void TestingQuantityList(){
        productList.Qunatity_list();
    }
    @Test(priority = 5)
    public void TestingNavigatingToForwardPage (){
        //Scrolling to the bottom of the page code
        WebElement element = driver.findElement(By.cssSelector("div[id='product-category'] li:nth-child(3) a:nth-child(1)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        productList.NextPage();
    }

    @Test(priority = 7)
    public void AddingProductToCart () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productList.AddToCart_MacBook();

        By iphone = By.cssSelector("body > div:nth-child(1) > main:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
        scrollToElement(driver, iphone);
        productList.AddToCart_iPhone();

        By SuccessMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        waitForVisible(SuccessMessage);
        productList.AssertSuccessful_AddTo_Cart();
        waitFoRInVisible(SuccessMessage);
    }
    @Test(priority = 8)
    public void AddingProductsInComparisonList (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productList.AddToComparisonList_MacBook();

        By iphone = By.cssSelector("body > div:nth-child(1) > main:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > button:nth-child(3)");
        scrollToElement(driver, iphone);
        productList.AddToComparisonList_iPhone();

        By List = By.cssSelector("#compare-total");
        scrollToElement(driver, List);
        WebElement list = wait.until(ExpectedConditions.elementToBeClickable(List));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", list);
        String CurrentUrl = "http://localhost/opencart/index.php?route=product/compare&language=en-gb";
        By ProductComparison = By.linkText("Product Comparison");
        waitForVisible(ProductComparison);
        Assert.assertEquals(CurrentUrl, "http://localhost/opencart/index.php?route=product/compare&language=en-gb");
    }
    @Test(priority = 9)
    public void AddingProductsToWishList (){
        productList.AddToWishList_iPhone();
        productList.AddToComparisonList_MacBook();
        By SuccessMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        waitForVisible(SuccessMessage);
        productList.AssertSuccessful_AddTo_WishList();
    }

}