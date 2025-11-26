package Pages.Admin.Orders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Orders_Page {
    WebDriver driver;
    public By pageTitle=By.xpath("//h1[text()='Orders']");
    public By Sales = By.linkText("Sales");
    public By Orders = By.xpath("//a[text()='Orders']");
    By deleteIcon= By.xpath("//button[@id='button-delete']");
    By printInvoiceBtn = By.id("button-invoice");
    By shippingBtn = By.id("button-shipping");
    By addNewBtn = By.cssSelector("a.btn.btn-primary > i.fa-plus");
    By orderIdInput=By.xpath("//input[@id='input-order-id']");
    By customer=By.xpath("//input[@id='input-customer']");
    By orderStore=By.xpath("//select[@id='input-store']");
    By orderStatus=By.xpath("//select[@id='input-order-status']");
    By total=By.xpath("//input[@id='input-total']");
    By dateFrom=By.xpath("//input[@id='input-date-from']");
    By dateTo=By.xpath("//input[@id='input-date-to']");
    By filterBtn=By.xpath("//button[@id='button-filter']");
    By noResultMessage=By.xpath("//td[text()='No results!']");
    By tableCount=By.xpath("//div[@class='col-sm-6 text-end']");

    // Table locator
    By ordersTable = By.cssSelector("table.table.table-bordered.table-hover");
    By tableRows = By.cssSelector("table.table.table-bordered.table-hover tbody tr");

    // Column indexes based on your table (starting from 1)
    int colCheckbox = 1;
    int colOrderID = 2;
    int colStore = 3;
    int colCustomer = 4;
    int colStatus = 5;
    int colTotal = 6;
    int colDateAdded = 7;
    int colDateModified = 8;
    int colAction = 9;

    // Calendar month label
    public By calendarMonth = By.cssSelector(".table-condensed th.month");

    // Calendar Next button
    public By nextButton = By.cssSelector(".table-condensed th.next");

    // Calendar Previous button
    public By prevButton = By.cssSelector(".table-condensed th.prev");

    // Generic locator for selecting a day
    public By dayCell(String day) {
        return By.xpath("//table[contains(@class,'table-condensed')]//td[normalize-space()='" + day + "']");
    }
    public Orders_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickSales(){
        driver.findElement(Sales).click();
    }
    public void clickOrders(){
        driver.findElement(Orders).click();
    }
    public void clickDeleteIcon(){
        driver.findElement(deleteIcon).click();
    }
    public void clickPrintInvoiceIcon(){
        driver.findElement(printInvoiceBtn).click();
    }
    public void clickShippingIcon(){
        driver.findElement(shippingBtn).click();
    }
    public void clickAddNewIcon(){
        driver.findElement(addNewBtn).click();
    }

    public void clickFilterBtn(){
        driver.findElement(filterBtn).click();
    }

    public void enterOrderIdFilter(String Id){
        driver.findElement(orderIdInput).sendKeys(Id);
    }

    public void enterCustomerFilter(String Cust){
        driver.findElement(customer).sendKeys(Cust);
    }

    public void enterTotalFilter(String total){
        driver.findElement(this.total).sendKeys(total);
    }

    public void selectStoreByIndex(int index){
       WebElement stores= driver.findElement(orderStore);
       Select storeElement=new Select(stores);
       storeElement.selectByIndex(index);
    }

    public void selectOrderStatusByIndex(int index){
        WebElement statuses= driver.findElement(orderStatus);
        Select orderStatus=new Select(statuses);
        orderStatus.selectByIndex(index);
    }

    public void selectDateFrom(String targetMonth, String targetYear, String targetDay) {
        // Open the calendar by clicking the input
        driver.findElement(dateFrom).click();

        while (true) {
            String monthYear = driver.findElement(calendarMonth).getText(); // e.g. "Oct 2025"

            if (monthYear.equals(targetMonth + " " + targetYear)) {
                break; // correct calendar view
            }

            // Navigate next
            driver.findElement(nextButton).click();
        }

        // Select the day
        driver.findElement(dayCell(targetDay)).click();
    }

    public void selectDateTo(String targetMonth, String targetYear, String targetDay) {
        // Open the calendar by clicking the input
        driver.findElement(dateFrom).click();

        while (true) {
            String monthYear = driver.findElement(calendarMonth).getText(); // e.g. "Oct 2025"

            if (monthYear.equals(targetMonth + " " + targetYear)) {
                break; // correct calendar view
            }

            // Navigate next
            driver.findElement(nextButton).click();
        }

        // Select the day
        driver.findElement(dayCell(targetDay)).click();
    }

//    public void openDateFromMenu(){
//        driver.findElement(dateFrom).click();
//    }
//    public void openDateToMenu(){
//        driver.findElement(dateTo).click();
//    }
//
//    public void openDateFromMenu(){
//        driver.findElement(dateFrom).click();
//    }
//    public void openDateToMenu(){
//        driver.findElement(dateTo).click();
//    }






    // Get total number of orders
    public int getOrderCount() {
        return driver.findElements(tableRows).size();
    }

    // Get order info for a specific row (rowIndex starts from 0)
    public List<String> getOrderData(int rowIndex) {
        List<String> data = new ArrayList<>();
        WebElement row = driver.findElements(tableRows).get(rowIndex);

        for (int i = 2; i <= 8; i++) { // columns 2 to 8 contain visible data
            data.add(row.findElement(By.cssSelector("td:nth-child(" + i + ")")).getText().trim());
        }
        return data;
    }

    // Click the "View" button for a specific row
    public void clickViewButton(int rowIndex) {
        WebElement row = driver.findElements(tableRows).get(rowIndex);
        row.findElement(By.cssSelector("td:nth-child(" + colAction + ") a[aria-label='View']")).click();
    }

    // Select checkbox for a specific row
    public void selectOrderCheckbox(int rowIndex) {
        WebElement row = driver.findElements(tableRows).get(rowIndex);
        row.findElement(By.cssSelector("td:nth-child(" + colCheckbox + ") input[type='checkbox']")).click();
    }

    // Get all order IDs in the table
    public List<String> getAllOrderIDs() {
        List<String> orderIDs = new ArrayList<>();
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            orderIDs.add(row.findElement(By.cssSelector("td:nth-child(" + colOrderID + ")")).getText().trim());
        }
        return orderIDs;
    }



    public void assertAdminOrdersPage(){
        Assert.assertTrue(driver.findElement(pageTitle).isDisplayed());
        Assert.assertTrue(driver.findElement(deleteIcon).isDisplayed());
        Assert.assertTrue(driver.findElement(addNewBtn).isDisplayed());
        Assert.assertTrue(driver.findElement(shippingBtn).isDisplayed());
        Assert.assertTrue(driver.findElement(ordersTable).isDisplayed());
        Assert.assertTrue(driver.findElement(printInvoiceBtn).isDisplayed());
        Assert.assertTrue(driver.findElement(orderStatus).isDisplayed());
        Assert.assertTrue(driver.findElement(orderIdInput).isDisplayed());
        Assert.assertTrue(driver.findElement(customer).isDisplayed());
        Assert.assertTrue(driver.findElement(orderStore).isDisplayed());
        Assert.assertTrue(driver.findElement(dateFrom).isDisplayed());
        Assert.assertTrue(driver.findElement(dateTo).isDisplayed());
        Assert.assertTrue(driver.findElement(total).isDisplayed());
    }

    public void assertEmptyOrders(){
        Assert.assertEquals(driver.findElement(noResultMessage).getText(),"No results!");
    }

}

