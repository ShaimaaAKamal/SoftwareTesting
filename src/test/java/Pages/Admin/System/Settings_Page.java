package Pages.Admin.System;

import Pages.Base_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Settings_Page extends Base_Page {
    // Navigating to System/Localisation/Store_Location //
    public By System_Selecting = By.linkText("System");
    By Localization_Selecting = By.xpath("//a[text()='Localisation']");
    By Store_Location_Selecting = By.xpath("//a[text()='Store Location']");

    // Adding New Store Information //
    public By Store_Add_new_Icon_Selecting = By.xpath("//a[i[contains(@class,'fa-plus')]]");
    By Store_Name_field = By.xpath("//input[@id='input-name']");
    By Store_Address_field = By.xpath("//textarea[@id='input-address']");
    By Store_Telephone_field = By.xpath("//input[@id='input-telephone']");
    By Store_Geocode_field = By.xpath("//input[@id='input-geocode']");
    By Store_Image_field_Edit = By.xpath("//button[normalize-space()='Edit']");
    By Store_Image_field_Edit_SearchBar = By.id("input-search");
    By Store_Image_field_Edit_SearchButton = By.id("button-search");
    By Store_SaveButton =  By.xpath("//button[i[contains(@class,'fa-floppy-disk')]]");
    By Store_BackButton = By.xpath("//a[@aria-label='Back']");
    By Store_EditButton = By.xpath("(//td[@class='text-end']//a[@title='Edit'])[1]");

    // Navigating to System/Localisation/Languages //
//    By Languages_selectionTab = By.xpath("//li[@class='active']//a[contains(text(),'Languages')]");
    By Languages_selectionTab = By.xpath("//a[text()='Languages']");


    // Adding New Language //
    By Languages_Add_new_Icon_Selecting = By.xpath("//i[@class='fa-solid fa-plus']");
    By Language_Name_Field = By.xpath("//input[@id='input-name']");
    By Language_Code_Field = By.xpath("//input[@id='input-code']");
    By Language_Extension_Field = By.xpath("//input[@id='input-extension']");
    By Language_Locale_Field = By.xpath("//input[@id='input-locale']");
    By Language_Status_Button = By.xpath("//input[@id='input-status']");
    By Language_SortOrder_IncreaseButton = By.xpath("//input[@id='input-sort-order']");
    By Language_SortOrder_DecreaseButton = By.cssSelector("#input-sort-order");
    By Language_Save_Button = By.xpath("//button[i[contains(@class,'fa-floppy-disk')]]");
    By Language_Back_Button = By.xpath("//a[@aria-label='Back']");
    By Language_Edit_Button = By.xpath("//tbody/tr[1]//a[@title='Edit']");
    By Language_Delete_Button = By.xpath("//button[@class='btn btn-danger']");
    By Language_List = By.xpath("(//input[@type='checkbox'])[2]");

    // Navigating to System/Localisation/Currency //
    By Currencies_selectionTab =  By.xpath("//a[text()='Currencies']");

    // Adding New Currency //
    By Currency_Add_new_Button = By.xpath("//i[@class='fa-solid fa-plus']");
    By Currency_Refresh_Button = By.xpath("//i[@class='fa-solid fa-rotate']");
    By Currency_Delete_Button = By.xpath("//button[@class='btn btn-danger']");
    By Currency_Editing_Button = By.xpath("//tbody/tr[3]/td[6]/a[1]/i[1]");
    By Currency_Title = By.xpath("//input[@id='input-title']");
    By Currency_Code = By.xpath("//input[@id='input-code']");
    By Currency_Symbol_Left = By.xpath("//input[@id='input-symbol-left']");
    By Currency_Symbol_right = By.xpath("//input[@id='input-symbol-right']");
    By Currency_DecimalPlaces = By.xpath("//input[@id='input-decimal-place']");
    By Currency_Value = By.xpath("//input[@id='input-value']");
    By Currency_Status = By.xpath("//input[@id='input-status']");
    By Currency_Save_Button = By.xpath("//i[@class='fa-solid fa-floppy-disk']");
    By Currency_Back_Button = By.xpath("//a[@aria-label='Back']");
    By Currency_List = By.xpath("(//input[@type='checkbox'])[6]");

    //Navigating to System/Localisation/Stock_Statuses //

    By StockStatus_selectionTab = By.xpath("//a[text()='Stock Statuses']");

    // Adding new Stock Status //
    By Stock_Add_new_Button =By.xpath("//i[@class='fa-solid fa-plus']");
    By Stock_Delete_Button = By.xpath("//button[@class='btn btn-danger']");
    By Stock_Edit_Button = By.xpath("(//a[@title='Edit']//i[@class='fa-solid fa-pencil'])[2]");
    By Stock_Status_Name_Field_1 = By.xpath("//input[@id='input-name-1']");
//    By Stock_Status_Name_Field_2 = By.xpath("//input[@id='input-name-3']");
//    By Stock_Status_Name_Field_3 = By.xpath("//input[@id='input-name-4']");
    By Stock_Save_Button = By.xpath("//i[@class='fa-solid fa-floppy-disk']");
    By Stock_Back_Button = By.xpath("//i[@class='fa-solid fa-reply']");
    By Stock_List =By.xpath("(//input[@type='checkbox'])[6]");

    // Navigate to System/Users/Users //
    By Users_Selection = By.xpath("//li[a[text()='Users']]");
    By Users_SelectionTab = By.xpath("//li[a[text()='Users']]//ul/li/a[text()='Users']");

    // Adding New User //
    By User_Add_new_Button = By.xpath("//a/i[@class='fa-solid fa-plus']");
    By User_Delete_Button =  By.xpath("//button[@class='btn btn-danger']");
    By User_Username_Field = By.xpath("//input[@id='input-username']");
    By User_UserGroup_Bar = By.xpath("//select[@id='input-user-group']");
    By User_FirstName_Field = By.xpath("//input[@id='input-firstname']");
    By User_LastName_Field = By.xpath("//input[@id='input-lastname']");
    By User_Email_Field = By.xpath("//input[@id='input-email']");
    By User_Image_Edit_Button = By.xpath("//button[normalize-space()='Edit']");
    By User_Image_Clear_Button = By.xpath("//button[normalize-space()='Clear']");
    By User_Image_SelectLogo = By.cssSelector("//button[normalize-space()='Clear']");
    By User_Passowrd_Field = By.xpath("//input[@id='input-password']");
    By User_PasswordConfirmation_Field = By.xpath("//input[@id='input-confirm']");
    By User_Status_Button = By.xpath("//input[@id='input-status']");
    By User_Save_Icon = By.xpath("//i[@class='fa-solid fa-floppy-disk']");
    By User_Back_Icon = By.xpath("//a[@aria-label='Back']");
    By User_List= By.xpath("(//input[@type='checkbox'])[3]");
    // Navigate to System/Users/User_Group //
    By GroupUser_SelectionTab =By.xpath("//a[text()='User Groups']");

    // Adding New User_Group //
    By GroupUser_Add_Button = By.xpath("//i[@class='fa-solid fa-plus']");
    By GroupUser_Delete_Button = By.xpath("//button[@aria-label='Delete']");
    By GroupUser_Name_Field = By.xpath("//input[@id='input-name']");
    By GroupUser_Permissions_All = By.xpath("//input[@onchange=\"$('#user-group-permission input[name^=\\'permission[access]\\']').prop('checked', $(this).prop('checked'));\"]");
    By GroupUser_Extensions_All = By.xpath("//input[@onchange=\"$('#user-group-extension input[name^=\\'permission[access]\\']').prop('checked', $(this).prop('checked'));\"]");
    By GroupUser_Save_Button = By.xpath("//button[i[contains(@class,'fa-floppy-disk')]]");
    By Group_Back_Button = By.xpath("//a[@aria-label='Back']");

    // Navigating To System/Users/API //
    By API_SelectionTab = By.xpath("//a[text()='API']");

    // Adding New API //
    By API_Add_Button = By.xpath("//i[@class='fa-solid fa-plus']");
    By API_Delete_Button = By.xpath("//i[@class='fa-regular fa-trash-can']");
    By API_UserName_Field = By.xpath("//input[@id='input-username']");
    By API_Key_Field = By.xpath("//textarea[@id='input-key']");
    By API_Key_Field_Generate = By.xpath("//button[@id='button-generate']");
    By API_Status_Button = By.xpath("//input[@id='input-status']");
    By API_Save_Button =By.xpath("//button[i[contains(@class,'fa-floppy-disk')]]");
    By API_Back_Button = By.xpath("//i[@class='fa-solid fa-reply']");
    By API_IP_ADDRESS_Bar = By.xpath("//a[normalize-space()='IP Addresses']");
    By API_IP_Add_Button = By.xpath("//i[@class='fa-solid fa-plus-circle']");
    By API_IP_NumberField = By.xpath("//input[@placeholder='IP']");
    public WebDriverWait wait;


    public void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Settings_Page(WebDriver parentDriver) {
        super(parentDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Navigating_To_StoreLocation (){
        waitForVisible(System_Selecting);
        driver.findElement(System_Selecting).click();
        waitForVisible(Localization_Selecting);
        driver.findElement(Localization_Selecting).click();
        waitForVisible(Store_Location_Selecting);
        driver.findElement(Store_Location_Selecting).click();
    }
    public void Adding_NewStore (String Name, String Address, Integer Telephone, Integer Code){
        waitForVisible(Store_Add_new_Icon_Selecting);
        driver.findElement(Store_Add_new_Icon_Selecting).click();
        driver.findElement(Store_Name_field).sendKeys(Name);
        driver.findElement(Store_Address_field).sendKeys(Address);
        driver.findElement(Store_Telephone_field).sendKeys(String.valueOf(Telephone));
        driver.findElement(Store_Geocode_field).sendKeys(String.valueOf(Code));
        driver.findElement(Store_SaveButton).click();
    }

    public void Editing_Existing_StoreInformation(String Name, String Address, Integer Telephone, Integer Code){
        driver.findElement(Store_EditButton).click();
        waitForVisible(Store_Name_field);
        driver.findElement(Store_Name_field).clear();
        driver.findElement(Store_Name_field).sendKeys(Name);
        driver.findElement(Store_Address_field).clear();
        driver.findElement(Store_Address_field).sendKeys(Address);
        driver.findElement(Store_Telephone_field).clear();
        driver.findElement(Store_Telephone_field).sendKeys(String.valueOf(Telephone));
        driver.findElement(Store_Geocode_field).clear();
        driver.findElement(Store_Geocode_field).sendKeys(String.valueOf(Code));
        driver.findElement(Store_SaveButton).click();
    }
    public void Navigating_To_Languages(){
        waitForVisible(System_Selecting);
        driver.findElement(System_Selecting).click();
        waitForVisible(Localization_Selecting);
        driver.findElement(Localization_Selecting).click();
        waitForVisible(Languages_selectionTab);
        driver.findElement(Languages_selectionTab).click();
    }
    public void Language_Adding(String Name, Integer Code, String Locale,String Extension){
        waitForVisible(Languages_Add_new_Icon_Selecting);
        driver.findElement(Languages_Add_new_Icon_Selecting).click();
        driver.findElement(Language_Name_Field).sendKeys(Name);
        driver.findElement(Language_Code_Field).sendKeys(String.valueOf(Code));
        driver.findElement(Language_Extension_Field).sendKeys(Extension);
        driver.findElement(Language_Locale_Field).sendKeys(Locale);
        driver.findElement(Language_SortOrder_IncreaseButton).click();
        driver.findElement(Language_Status_Button).click();
        driver.findElement(Language_Save_Button).click();
    }
    public void Language_Editing (String Name, Integer Code, String Locale,String Extension){
        driver.findElement(Language_Edit_Button).click();
        waitForVisible(Store_Name_field);
        driver.findElement(Language_Name_Field).clear();
        driver.findElement(Language_Name_Field).sendKeys(Name);
        driver.findElement(Language_Code_Field).clear();
        driver.findElement(Language_Code_Field).sendKeys(String.valueOf(Code));
        driver.findElement(Language_Locale_Field).clear();
        driver.findElement(Language_Locale_Field).sendKeys(Locale);
        driver.findElement(Language_SortOrder_DecreaseButton).click();
        driver.findElement(Language_Save_Button).click();
    }

    public void Language_Delete (){
        waitForVisible(Language_Delete_Button);
        driver.findElement(Language_List).click();
        driver.findElement(Language_Delete_Button).click();
    }


    public void Navigate_To_currencies () {
        waitForVisible(System_Selecting);
        driver.findElement(System_Selecting).click();
        waitForVisible(Localization_Selecting);
        driver.findElement(Localization_Selecting).click();
        waitForVisible(Currencies_selectionTab);
        driver.findElement(Currencies_selectionTab).click();
    }

    public void Currency_Adding (String Title, String Code, String SymbolLeft, String SymbolRight, Double Decimal, Integer Value){
        waitForVisible(Currency_Add_new_Button);
        driver.findElement(Currency_Add_new_Button).click();
        driver.findElement(Currency_Title).sendKeys(Title);
        driver.findElement(Currency_Code).sendKeys(Code);
        driver.findElement(Currency_Symbol_Left).sendKeys(SymbolLeft);
        driver.findElement(Currency_Symbol_right).sendKeys(SymbolRight);
        driver.findElement(Currency_DecimalPlaces).sendKeys(String.valueOf(Decimal));
        driver.findElement(Currency_Value).sendKeys(String.valueOf(Value));
        driver.findElement(Currency_Status).click();
        driver.findElement(Currency_Save_Button).click();
    }


    public void Currency_Editing (String Title, String Code, String SymbolLeft, String SymbolRight, Double Decimal, Integer Value){
        waitForVisible(Currency_Editing_Button);
        driver.findElement(Currency_Editing_Button).click();
        driver.findElement(Currency_Title).clear();
        driver.findElement(Currency_Title).sendKeys(Title);

        driver.findElement(Currency_Code).clear();
        driver.findElement(Currency_Code).sendKeys(Code);

        driver.findElement(Currency_Symbol_Left).clear();
        driver.findElement(Currency_Symbol_Left).sendKeys(SymbolLeft);

        driver.findElement(Currency_Symbol_right).clear();
        driver.findElement(Currency_Symbol_right).sendKeys(SymbolRight);

        driver.findElement(Currency_DecimalPlaces).clear();
        driver.findElement(Currency_DecimalPlaces).sendKeys(String.valueOf(Decimal));

        driver.findElement(Currency_DecimalPlaces).clear();
        driver.findElement(Currency_DecimalPlaces).sendKeys(String.valueOf(Decimal));

        driver.findElement(Currency_Status).click();
        driver.findElement(Currency_Save_Button).click();
    }


    public void Currency_Deleting (){
        waitForVisible(Currency_Add_new_Button);
        driver.findElement(Currency_List).click();
        driver.findElement(Currency_Delete_Button).click();
        driver.findElement(Currency_Refresh_Button).click();
    }

    public void Navigating_To_StockStatus (){
        waitForVisible(System_Selecting);
        driver.findElement(System_Selecting).click();
        waitForVisible(Localization_Selecting);
        driver.findElement(Localization_Selecting).click();
        waitForVisible(StockStatus_selectionTab);
        driver.findElement(StockStatus_selectionTab).click();
    }

    public void Stock_Adding (String Name1, String Name2,String Name3){
        waitForVisible(Stock_Add_new_Button);
        driver.findElement(Stock_Add_new_Button).click();
        waitForVisible(Stock_Status_Name_Field_1);
        driver.findElement(Stock_Status_Name_Field_1).sendKeys(Name1);
        driver.findElement(Stock_Save_Button).click();
    }
    public void Stock_Editing (String Name1, String Name2,String Name3) {
        waitForVisible(Stock_Edit_Button);
        driver.findElement(Stock_Edit_Button).click();
        waitForVisible(Stock_Status_Name_Field_1);
        driver.findElement(Stock_Status_Name_Field_1).clear();
        driver.findElement(Stock_Status_Name_Field_1).sendKeys(Name1);
        driver.findElement(Stock_Save_Button).click();
    }
    public void Stock_Delete (){
        waitForVisible(Stock_Delete_Button);
        driver.findElement(Stock_List).click();
        driver.findElement(Stock_Delete_Button).click();
    }
    public void Navigate_To_Users () throws InterruptedException {
        waitForVisible(System_Selecting);
        driver.findElement(System_Selecting).click();
        waitForVisible(Users_Selection);
        driver.findElement(Users_Selection).click();
        waitForVisible(Users_SelectionTab);
        driver.findElement(Users_SelectionTab).click();
    }

    public void User_Adding (String UserName, String FirstName, String LastName,String Email, String Password, String Confirmation){
        waitForVisible(User_Add_new_Button);
        driver.findElement(User_Add_new_Button).click();
        waitForVisible(User_Username_Field);
        driver.findElement(User_Username_Field).sendKeys(UserName);
        driver.findElement(User_FirstName_Field).sendKeys(FirstName);
        driver.findElement(User_LastName_Field).sendKeys(LastName);
        driver.findElement(User_UserGroup_Bar).click();
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='input-user-group']")));
        dropdown.selectByIndex(1);
        driver.findElement(User_Email_Field).sendKeys(Email);
//        driver.findElement(User_Image_Edit_Button).click();
//        driver.findElement(User_Image_SelectLogo).click();
        driver.findElement(User_Passowrd_Field).sendKeys(Password);
        driver.findElement(User_PasswordConfirmation_Field).sendKeys(Confirmation);
        scrollAndClick(User_Status_Button);
        scrollAndClick(User_Save_Icon);
    }

    public void User_Delete (){
        waitForVisible(User_Delete_Button);
        driver.findElement(User_List).click();
        driver.findElement(User_Delete_Button).click();
    }
    public void scrollAndClick(By locator){
        WebElement button = driver.findElement(locator);

        // Scroll into view
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);

        // Add small delay to ensure layout stabilizes
        try { Thread.sleep(300); } catch (InterruptedException e) {}

        // Click using JS to bypass overlays
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void Navigating_UserGroup () {
        waitForVisible(System_Selecting);
        driver.findElement(System_Selecting).click();
        waitForVisible(Users_Selection);
        driver.findElement(Users_Selection).click();
        waitForVisible(GroupUser_SelectionTab);
        driver.findElement(GroupUser_SelectionTab).click();
    }
    public void GroupUser_Adding (String Name){
        waitForVisible(GroupUser_Add_Button);
        driver.findElement(GroupUser_Add_Button).click();
        waitForVisible(GroupUser_Name_Field);
        driver.findElement(GroupUser_Name_Field).sendKeys(Name);
        driver.findElement(GroupUser_Permissions_All).click();
        driver.findElement(GroupUser_Extensions_All).click();
        driver.findElement(GroupUser_Save_Button).click();
    }

    public void Navigating_API (){
        waitForVisible(System_Selecting);
        driver.findElement(System_Selecting).click();
        waitForVisible(Users_Selection);
        driver.findElement(Users_Selection).click();
        waitForVisible(API_SelectionTab);
        driver.findElement(API_SelectionTab).click();
    }

    public void API_Adding (String Username, Integer IP){
        waitForVisible(API_Add_Button);
        driver.findElement(API_Add_Button).click();
        waitForVisible(API_UserName_Field);
        driver.findElement(API_UserName_Field).sendKeys(Username);
        driver.findElement(API_Key_Field_Generate).click();
        driver.findElement(API_Status_Button).click();
        driver.findElement(API_IP_ADDRESS_Bar).click();
        driver.findElement(API_IP_Add_Button).click();
        driver.findElement(API_IP_NumberField).sendKeys(String.valueOf(IP));
        driver.findElement(API_Save_Button).click();
        driver.findElement(API_Back_Button).click();
    }


    public void Asserting_Store_Location_AddedSuccessfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified store locations!");
    }
    public void Asserting_Store_Location_EditedSuccessfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified store locations!");
    }


    public void Assert_Language_AddedSuccessfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified languages!");

    }
    public void Asserting_Language_Edited_Successfully(){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified languages!");
    }
    public void Asserting_Currency_Added_Successfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified currencies!");
    }
    public void Asserting_Currency_edited_successfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified currencies!");
    }
    public void Asserting_Currency_deleted_successfully (){

        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified currencies!");
    }
    public void Asserting_Stock_Added_successfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified stock statuses!");
    }
    public void Asserting_Stock_Edited_successfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified stock statuses!");
    }
    public void Asserting_Stock_Deleted_successfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified stock statuses!");
    }
    public void Asserting_Language_Deleted_successfully (){
        Assert.assertTrue(successMessage().isDisplayed());
    }
    public void Asserting_User_Added_successfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified Users!");
    }

    public void Asserting_User_deleted_successfully (){
        Assert.assertTrue(successMessage().isDisplayed());
    }
    public void Asserting_UserGroup_Added_successfully (){
        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified user groups!");
    }

    public void Asserting_API_Added_successfully () {

        Assert.assertTrue(successMessage().isDisplayed(), "Success: You have modified APIs!");
    }

    private WebElement successMessage(){
        By PopUpMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        waitForVisible(PopUpMessage);
        WebElement msg=driver.findElement(PopUpMessage);
        return msg;
    }
}