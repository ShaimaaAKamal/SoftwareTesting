package Tests.Admin.System;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.System.Settings_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.TestRunner.PriorityWeight.priority;

public class Settings extends BaseTest {
    Settings_Page settingsPage;
    Admin_Login_Page login;
    Dashboard_Page dashboard;
    @BeforeMethod
    public void Precondition(){
        settingsPage = new Settings_Page(driver);
        login=new Admin_Login_Page(driver);
        dashboard=new Dashboard_Page(driver);
        driver.get(adminPanelBaseUrl);
        login.enterUsername(adminUsername);
        login.enterPassword(adminPassword);
        login.submitForm();
        wait.until(ExpectedConditions.urlContains("user_token"));
    }

    @AfterMethod
    public void after(){
     dashboard.clickLogout();
    }



    @Test(priority = 1)
    public void Adding_New_Store_location (){
        waitForVisible(settingsPage.System_Selecting);
        settingsPage.Navigating_To_StoreLocation();
        settingsPage.Adding_NewStore("project","Cairo,Egypt",10000, 123123);
        settingsPage.Asserting_Store_Location_AddedSuccessfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }

    @Test(priority = 2 )
    public void Editing_Store_location (){
        settingsPage.Navigating_To_StoreLocation();
        settingsPage.Editing_Existing_StoreInformation("TheProject","Giza,Egypt", 40000, 987987);
        settingsPage.Asserting_Store_Location_EditedSuccessfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
    @Test(priority = 3)
    public void Adding_New_Language_Successfully (){
        waitForVisible(settingsPage.System_Selecting);
        settingsPage.Navigating_To_Languages();
        settingsPage.Language_Adding("Arabic", 33 , "No_Extension", "ar-EG");
        settingsPage.Assert_Language_AddedSuccessfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
    @Test(priority = 4)
    public void Editing_Language_Successfully (){
        settingsPage.Navigating_To_Languages();
        settingsPage.Language_Editing("Arabic", 34, "No_Extension", "ar-EG");
        settingsPage.Asserting_Language_Edited_Successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }

    @Test(priority = 5)
    public void Deleted_Language_Successfully (){
        settingsPage.Navigating_To_Languages();
        settingsPage.Language_Delete();
        settingsPage.Asserting_Language_Deleted_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
    @Test(priority = 6)
    public void Adding_Currency_Successfully (){
        waitForVisible(settingsPage.System_Selecting);
        settingsPage.Navigate_To_currencies();
        settingsPage.Currency_Adding("EgyptainPoud", "LEu", "", "LEu", 0.01 , 1);
        settingsPage.Asserting_Currency_Added_Successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
    @Test(priority = 7)
    public void Editing_Currency_Successfully () {
        settingsPage.Navigate_To_currencies();
        settingsPage.Currency_Editing("SaudiRayal", "R8Y", "", "R8Y", 0.06, 12);
        settingsPage.Asserting_Currency_edited_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
    @Test(priority = 8)
    public void Deleting_Currency_Successfully (){
        settingsPage.Navigate_To_currencies();
        settingsPage.Currency_Deleting();
        settingsPage.Asserting_Currency_deleted_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }

    @Test(priority = 11)
    public void Adding_StockStatuses_Successfully (){
        waitForVisible(settingsPage.System_Selecting);
        settingsPage.Navigating_To_StockStatus();
        settingsPage.Stock_Adding("Full", "Stock","ihiowr");
        settingsPage.Asserting_Stock_Added_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
    @Test(priority = 12)
    public void Editing_StockStatuses_Successfully (){
        settingsPage.Navigating_To_StockStatus();
        settingsPage.Stock_Editing("Pve", "Ordered","ojef");
        settingsPage.Asserting_Stock_Edited_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }

    @Test(priority = 13)
    public void Deleted_StockStatuses_Successfully (){
        settingsPage.Navigating_To_StockStatus();
        settingsPage.Stock_Delete();
        settingsPage.Asserting_Stock_Deleted_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
    @Test(priority = 9)
    public void Adding_User_Successfully () throws InterruptedException {
        waitForVisible(settingsPage.System_Selecting);
        settingsPage.Navigate_To_Users();
        settingsPage.User_Adding("Moamen_Mohamed","Moamen", "Mohamed", "moamen_mohamed997@hotmail.com", "Test710@", "Test710@");
        settingsPage.Asserting_User_Added_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }

    @Test(priority = 10)
    public void Deleted_User_Successfully () throws InterruptedException {
        settingsPage.Navigate_To_Users();
        settingsPage.User_Delete();
        settingsPage.Asserting_User_deleted_successfully();
        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    }
   @Test(priority =14 )
    public void Adding_UserGroup_Successfully (){
       waitForVisible(settingsPage.System_Selecting);
       settingsPage.Navigating_UserGroup();
        settingsPage.GroupUser_Adding("Influncers");
        settingsPage.Asserting_UserGroup_Added_successfully();
       waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
   }
//    @Test(priority = 10)
//    public void Adding_API_successfully (){
//        waitForVisible(settingsPage.System_Selecting);
//        settingsPage.Navigating_API();
//        settingsPage.API_Adding("TheWebsite", 123456);
//        settingsPage.Asserting_API_Added_successfully();
//        waitFoRInVisible(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//    }
}