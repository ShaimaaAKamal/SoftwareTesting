package Pages.Admin;

import Pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Reports_Page extends Base_Page {

     public By pageTitle=By.xpath("//h1[text()='Online Report']");

     public Reports_Page(WebDriver driver){
         super(driver);
     }


    public void  assertInReportssPage(){
        Assert.assertEquals(driver.findElement(pageTitle).getText(),"Online Report" );
    }

}
