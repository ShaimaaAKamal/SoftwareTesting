package Pages.Admin.Orders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Orders_Page {
    WebDriver driver;
    public By pageTitle=By.xpath("//h1[text()='Orders']");
    By deleteIcon= By.xpath("//button[@id='button-delete']");
    By printInvoiceBtn = By.id("button-invoice");
    By printShippingBtn = By.id("button-shipping");
    By addNewBtn = By.cssSelector("a.btn.btn-primary > i.fa-plus");
    By orderIdInput=By.xpath("//input[@id='input-order-id']");
    By customer=By.xpath("//input[@id='input-customer']");
    By orderStore=By.xpath("//select[@id='input-store']");
    By orderStatus=By.xpath("//select[@id='input-order-status']");
    By total=By.xpath("//input[@id='input-total']");
    By dateFrom=By.xpath("//input[@id='input-date-from']");
    By dateTo=By.xpath("//input[@id='input-date-to']");
    By filterBtn=By.xpath("//button[@id='button-filter']");
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
}
