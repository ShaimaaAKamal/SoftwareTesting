package Pages.Admin.Customers;

import Pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v140.network.model.DataReceived;
import org.testng.Assert;

import java.sql.Driver;
import java.util.List;

public class Customers_Page extends Base_Page {


    // Locators //
    public By pageTitle=By.xpath("//h1[text()='Customers']");
    By Customers_Dropdown = By.xpath("//*[@id=\"menu-customer\"]/a");
    public By Select_Customer_Button = By.xpath("//*[@id=\"collapse-6\"]/li[1]/a");
    By  Edit_Icon = By.xpath("//*[@id=\"form-customer\"]/div[1]/table/tbody/tr[1]/td[6]/div/a");
    By CheckBox  =By.xpath("//*[@id=\"form-customer\"]/div[1]/table/tbody/tr[1]/td[1]/input");
    By  Delete_Icon =By.cssSelector(".btn-danger");
    By Filter_Icon=By.xpath("//button[@id='button-filter']");
    By Customer_Name= By.id("input-name");
    By  Filter_Button =By.id("button-filter");
    By  AddNew_Button =By.cssSelector("a.btn.btn-primary > i.fa-plus");
    By Logout_Button = By.xpath("//a[@class=\"nav-link\"]");
    By tableRows = By.cssSelector("table.table.table-bordered.table-hover tbody tr");
    public By successMessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    // Constructor //
    public Customers_Page(WebDriver driver) {

        super(driver);
    }

    //  Actions //
    public void ClickCustomersDropdown(){
        scrollAndClick(Customers_Dropdown);
    }
    public void SelectCustomerButton(){
        scrollAndClick(Select_Customer_Button);
    }
    public void ClickOnEditIcon(){
        driver.findElement(Edit_Icon).click();
    }
    public void ClickOnCheckBox(){
        driver.findElement(CheckBox).click();
    }
    public void DeleteCustomerData(){
        driver.findElement(Delete_Icon).click();
    }
    public void ClickOnFilterIcon(){
        driver.findElement(Filter_Icon).click();
    }
    public void EnterCustomerName(String CustomerName){
        driver.findElement(Customer_Name).sendKeys(CustomerName);
    }
    public void ClickFilterButton(){
        driver.findElement(Filter_Button).click();
    }
    public void ClickOnAddNewCustomerButton(){
        driver.findElement(AddNew_Button).click();
    }
    public void ClickOnLogoutButton(){
        driver.findElement(Logout_Button).click();
    }


    public int getCustomerCount() {
        List<WebElement> rows = driver.findElements(tableRows);

        // If first row contains "No results!", return 0
        if (rows.size() == 1 &&
                rows.get(0).getText().contains("No results!")) {
            return 0;
        }

        return rows.size();
    }
    // Assertion //
    public void assertNavigateToEditCustomerDetails(){
        Assert.assertTrue(driver.getCurrentUrl().contains("customer.form"),
                "URL does NOT contain customer.form!");
    }
    public void assertDeleteMessageDisplayed(){
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
    }

    public void assertFilterResult(int count){
        Assert.assertEquals(getCustomerCount(),count);
    }
    public void assertAddNewCustomer(){
        Assert.assertTrue(driver.getCurrentUrl().contains("customer.form"),
                "URL does NOT contain customer.form!");
    }

    public void  assertInCustomersPage(){
        Assert.assertEquals(driver.findElement(pageTitle).getText(),"Customers" );
    }

}