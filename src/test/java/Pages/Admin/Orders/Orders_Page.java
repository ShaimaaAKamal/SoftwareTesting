package Pages.Admin.Orders;

import Pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Orders_Page extends Base_Page {
    public By pageTitle=By.xpath("//h1[text()='Orders']");
    public By Sales = By.linkText("Sales");
    public By Orders = By.xpath("//a[text()='Orders']");
//    By deleteIcon= By.xpath("//button[@id='button-delete']");
    By deleteIcon=By.cssSelector(".btn-danger");
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
    public By successMessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    // Table locator
    By ordersTable = By.cssSelector("table.table.table-bordered.table-hover");
    By tableRows = By.cssSelector("table.table.table-bordered.table-hover tbody tr");
    By closeBtn=By.cssSelector(".btn-close");
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
        super(driver);
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
        scrollAndClick(filterBtn);
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

    public void setCloseBtn(){
        driver.findElement(closeBtn).click();
    }

    public void selectStore(String name) {
        WebElement element = driver.findElement(orderStore);
        Select dropdown = new Select(element);

        boolean found = false;

        // Loop to check if the option exists
        for (WebElement option : dropdown.getOptions()) {
            if (option.getText().trim().equalsIgnoreCase(name.trim())) {
                dropdown.selectByVisibleText(name);
                found = true;
                break;
            }
        }

        // If not found, just continue without throwing an error
        if (!found) {
            System.out.println("Order Store '" + name + "' not found → Continuing without selection.");
        }
    }


    public void selectOrderStatus(String text){
        WebElement element = driver.findElement(orderStatus);
        Select dropdown = new Select(element);

        boolean found = false;

        // Loop to check if the option exists
        for (WebElement option : dropdown.getOptions()) {
            if (option.getText().trim().equalsIgnoreCase(text.trim())) {
                dropdown.selectByVisibleText(text);
                found = true;
                break;
            }
        }

        // If not found, just continue without throwing an error
        if (!found) {
            System.out.println("Order status '" + text + "' not found → Continuing without selection.");
        }
    }

    public void selectDateFrom(String dateFr) {
        selectDate(dateFrom,dateFr);
    }

    public void selectDateTo(String dateT) {
        selectDate(dateTo,dateT);
    }
private void selectDate(By locator,String val){
    driver.findElement(locator).click();
    driver.findElement(locator).sendKeys(val);
    driver.findElement(locator).sendKeys(Keys.ENTER);
}

    public int getOrderCount() {
        List<WebElement> rows = driver.findElements(tableRows);

        // If first row contains "No results!", return 0
        if (rows.size() == 1 &&
                rows.get(0).getText().contains("No results!")) {
            return 0;
        }

        return rows.size();
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

    // Get order info for a specific row (rowIndex starts from 0)
    public String   getOrderfirstId() {
        List<String> orderData=getOrderData(0);
        System.out.println(orderData);
        System.out.println(orderData.getFirst());
        return orderData.getFirst();
    }

    // Click the "View" button for a specific row
    public void clickViewButton(int rowIndex) {
        WebElement row = driver.findElements(tableRows).get(rowIndex);
        row.findElement(By.cssSelector("a.btn.btn-primary i.fa-eye")).click();
//        row.findElement(By.cssSelector("td:nth-child(" + colAction + ") a[aria-label='View']")).click();
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

    public void assertOrderIDfILTEResult(){
        Assert.assertEquals(getOrderCount(),1);
    }

    public void assertCustomerfILTEResult(){
        Assert.assertTrue(getOrderCount() >= 1);
    }

    public void assertTotalfILTEResult(){
        Assert.assertTrue(getOrderCount() >= 1);
    }

    public void assertStatusfILTEResult(){
        Assert.assertTrue(getOrderCount() >= 1);
    }

    public void assertAllTablesData(int count){
        Assert.assertEquals(getOrderCount(),count);

    }

    public void assertShippingIconisNotClickable(){
        WebElement element = driver.findElement(shippingBtn);
        boolean isClickable = element.isEnabled();

        Assert.assertFalse(isClickable, "Shipping Button should NOT be clickable");
    }

    public void assertPrintInvoiceIconisNotClickable(){
        WebElement element = driver.findElement(printInvoiceBtn);
        boolean isClickable = element.isEnabled();

        Assert.assertFalse(isClickable, "Print Invoice Button should NOT be clickable");
    }

   public void AssertSuccessDelete(){
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
   }
}

