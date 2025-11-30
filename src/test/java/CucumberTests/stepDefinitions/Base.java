package CucumberTests.stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class Base {

//    public static WebDriver driver;
//    public static ChromeOptions options;
//    public WebDriverWait wait;
//    public String storeBaseUrl="http://localhost:8888/opencart/";
//    public String storeUserEmail="tete@gmail.com";
//    public String storeUserPassword="Test710@";
//
//
//    public Base(){
//
//        options = new ChromeOptions();
//        options.addArguments("--incognito");
//        options.setCapability("unhandledPromptBehavior", "accept");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//import org.openqa.selenium.support.ui.ExpectedConditions;
//    }
//
//
//
//    public void waitForVisible(By locator){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    public void waitFoRInVisible(By locator){
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//
//    }

       public static WebDriver driver;
        public static WebDriverWait wait;
        public static ChromeOptions options;

        // Test data
        public static String storeBaseUrl = "http://localhost:8888/opencart/";
        public static String storeUserEmail = "tete@gmail.com";
        public static String storeUserPassword = "Test710@";

        // Initialize driver once before all scenarios
//        @BeforeSuite
    @BeforeAll
        public static void before_all() {
            options = new ChromeOptions();
            options.addArguments("--incognito");
            options.setCapability("unhandledPromptBehavior", "accept");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // Quit driver after all scenarios
//        @AfterSuite
    @AfterAll
        public static void after_all() {
            if (driver != null) {
                driver.quit();
            }
        }

        // Helper methods
        public static void waitForVisible(By locator) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public static void waitForInvisible(By locator) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }

        public void scrollIntoView(By locator) {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }




}
