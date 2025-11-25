package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public static ChromeOptions options;
    public WebDriverWait wait;

    @BeforeSuite
    public void setUp(){
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setCapability("unhandledPromptBehavior", "accept");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void beforeClass(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){
//        if(driver != null){
            driver.quit();
//        }
    }

    public void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitFoRInVisible(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }


    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

//    public void waitForClickable(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
//    }
//
//    public void safeClick(By locator) {
//        WebElement element = driver.findElement(locator);
//
//        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].scrollIntoView({block: 'center'}); window.scrollBy(0, -200);",
//                element
//        );
//
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
//        element.click();
//    }

}
