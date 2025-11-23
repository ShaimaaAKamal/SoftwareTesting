package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TrackingCode_Page {
    WebDriver driver;
    public By pageTitle=By.xpath("//h1[text()='Affiliate Tracking']");
    By trackingCode = By.xpath("//textarea[@id='input-code']");
    By generatorInput=By.xpath("//input[@id='input-generator']");
    By trackingLink=By.xpath("//textarea[@id='input-link']");
    public By trackedItem = By.xpath("//a[text()='Canon EOS 5D']");
    By continueBtn=By.xpath("//a[@class='btn btn-primary']");
    public TrackingCode_Page(WebDriver driver){
        this.driver=driver;
    }

    public void enterTrackingCode(String code){
        driver.findElement(trackingCode).sendKeys(code);
    }

    public void enterTrackedItem(String name){
        driver.findElement(generatorInput).sendKeys(name);
    }


    public void clickGeneratorInput(){
        driver.findElement(generatorInput).click();
    }

//    public void chooseTrackedItemByIndex(int index){
//        List<WebElement> products=driver.findElement(trackedItems);
//        System.out.println(products.size());
//        products.get(index).click();
//    }

    public void chooseTrackedItemBy(){
        System.out.println(driver.findElement(trackedItem));
        driver.findElement(trackedItem).click();

    }

    public void enterTrackingLing(String link){
        driver.findElement(trackingLink).sendKeys(link);
    }

    public String getTrackingLing(){
        return driver.findElement(trackingLink).getText();
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }

    public void assertCodeValue(){
        Assert.assertFalse(driver.findElement(trackingCode).getText().isEmpty());
    }


//    public void asserLinkValue(){
//        System.out.println(driver.findElement(trackingLink).getText());
//        Assert.assertFalse(driver.findElement(trackingLink).getText().isEmpty());
//    }
public void assertLinkValue() {
    String linkValue = driver.findElement(trackingLink).getAttribute("value");
    Assert.assertFalse(linkValue.isEmpty(), "Tracking link should not be empty!");
}
}
