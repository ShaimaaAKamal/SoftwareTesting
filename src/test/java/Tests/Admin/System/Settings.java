package Tests.Admin.System;

import Pages.Admin.System.Settings_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.TestRunner.PriorityWeight.priority;

public class Settings extends BaseTest {
    Settings_Page settingsPage;

    //    public void waitForVisible(By locator){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
    @BeforeMethod
    public void Precondition(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        settingsPage = new Settings_Page(driver);
        driver.get("http://localhost/opencart/TESTING/index.php?route=common/login");
        settingsPage.LoggingIntoAdmin("admin", "admin");
        waitForVisible(settingsPage.System_Selecting);

    }

    @Test
    public void Adding_New_Store_location (){
        settingsPage.Navigating_To_StoreLocation();
        settingsPage.Adding_NewStore("project","Cairo,Egypt",10000, 123123);
        settingsPage.Asserting_Store_Location_AddedSuccessfully();
    }

    @Test
    public void Editing_Store_location (){
        settingsPage.Navigating_To_StoreLocation();
        settingsPage.Editing_Existing_StoreInformation("TheProject","Giza,Egypt", 40000, 987987);
        settingsPage.Asserting_Store_Location_EditedSuccessfully();
    }
    @Test
    public void Adding_New_Language_Successfully (){
        settingsPage.Navigating_To_Languages();
        settingsPage.Language_Adding("Arabic", 22 , "No_Extension", "Ar-sa");
        settingsPage.Assert_Language_AddedSuccessfully();
    }
    @Test
    public void Editing_Language_Successfully (){
        settingsPage.Navigating_To_StoreLocation();
        settingsPage.Language_Editing("French", 31, "No_Extension", "Fr-Eu");
        settingsPage.Asserting_Language_Edited_Successfully();
    }
    @Test
    public void Adding_Currency_Successfully (){
        settingsPage.Navigate_To_currencies();
        settingsPage.Currency_Adding("EgyptainPound", "LE", "", "LE", 0.01 , 1);
        settingsPage.Asserting_Currency_Added_Successfully();
    }
    @Test
    public void Editing_Currency_Successfully () {
        settingsPage.Navigate_To_currencies();
        settingsPage.Currency_Editing("SaudiRayal", "RY", "", "RY", 0.06, 12);
        settingsPage.Asserting_Currency_edited_successfully();
    }
    @Test
    public void Deleting_Currency_Successfully (){
        settingsPage.Navigate_To_currencies();
        settingsPage.Currency_Deleting();
        settingsPage.Asserting_Currency_deleted_successfully();
    }

    @Test
    public void Adding_StockStatuses_Successfully (){
        settingsPage.Navigating_To_StockStatus();
        settingsPage.Stock_Adding("Full", "Stock");
        settingsPage.Asserting_Stock_Added_successfully();
    }
    @Test
    public void Editing_StockStatuses_Successfully (){
        settingsPage.Navigating_To_StockStatus();
        settingsPage.Stock_Editing("Pre", "Ordered");
        settingsPage.Asserting_Stock_Edited_successfully();
    }
    @Test
    public void Deleted_StockStatuses_Successfully (){
        settingsPage.Navigating_To_StockStatus();
        settingsPage.Stock_Delete();
        settingsPage.Asserting_Stock_Deleted_successfully();
    }
    @Test
    public void Adding_User_Successfully () throws InterruptedException {
        settingsPage.Navigate_To_Users();
        settingsPage.User_Adding("Moamen_Mohamed","Moamen", "Mohamed", "moamen_mohamed997@hotmail.com", "SecretPasword", "SecretPassword");
        settingsPage.Asserting_User_Added_successfully();
    }
    @Test
    public void Adding_UserGroup_Successfully (){
        settingsPage.Navigating_UserGroup();
        settingsPage.GroupUser_Adding("Influncers");
        settingsPage.Asserting_UserGroup_Added_successfully();
    }
    @Test
    public void Adding_API_successfully (){
        settingsPage.Navigating_API();
        settingsPage.API_Adding("TheWebsite", 123456);
        settingsPage.Asserting_API_Added_successfully();
    }
}