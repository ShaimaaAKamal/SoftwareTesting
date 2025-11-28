package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NewAddress_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='Add Address']");
    By firstname=By.xpath("//input[@id='input-firstname']");
    By lastname=By.xpath("//input[@id='input-lastname']");
    By backBtn=By.xpath("//a[@class='btn btn-light']");
    By continueBtn=By.xpath("//button[text()='Continue']");
    By company=By.xpath("//input[@id='input-company']");
    By address_1=By.xpath("//input[@id='input-address-1']");
    By address_2=By.xpath("//input[@id='input-address-2']");
    By city=By.xpath("//input[@id='input-city']");
    By postCode=By.xpath("//input[@id='input-postcode']");
    By country=By.id("input-country");
    By region=By.id("input-zone");
    By yesDefaultt=By.xpath("//input[@id='input-default-yes']");
    By noDefault=By.xpath("//input[@id='input-default-no']");
    public By firstNameError=By.xpath("//div[@id='error-firstname']");
    public By lastNameError=By.xpath("//div[@id='error-lastname']");
    public By address_1_Error=By.xpath("//div[@id='error-address-1']");
    public By cityError=By.xpath("//div[@id='error-city']");
    public By PostCodeError=By.id("error-postcode");
    public By regionError=By.xpath("//div[@id='error-zone']");

    public NewAddress_Page(WebDriver driver){
        this.driver=driver;
    }

    public void enterFirstName(String name){
        driver.findElement(firstname).sendKeys(name);
    }

    public void enterLastName(String name){
        driver.findElement(lastname).sendKeys(name);
    }

    public void enterCompany(String comp){
        driver.findElement(company).sendKeys(comp);
    }

    public void enterAddress1(String add1){
        driver.findElement(address_1).sendKeys(add1);
    }

    public void enterAddress2(String add2){
        driver.findElement(address_2).sendKeys(add2);
    }
    public void enterCity(String city){
        driver.findElement(this.city).sendKeys(city);
    }

    public void enterCode(String code){
        driver.findElement(this.postCode).sendKeys(code);
    }

    public void setCountry(String coun){
        WebElement countryElement=driver.findElement(country);
        countryElement.click();
        Select select = new Select(countryElement);
        select.selectByValue(coun);
    }

    public void setState(String state){
        WebElement stateElement=driver.findElement(region);
        stateElement.click();
        Select select = new Select(stateElement);
        select.selectByValue(state);
    }
    public void setDefault(){
        driver.findElement(yesDefaultt).click();
    }
    public void setNoDefault(){
        driver.findElement(noDefault).click();
    }


    public void back(){
        driver.findElement(backBtn).click();
    }

    public void addAddress(){
        driver.findElement(continueBtn).click();
    }

    public void assertFirstNameError(){
        Assert.assertTrue(driver.findElement(firstNameError).isDisplayed());
    }

    public void assertLastNameError() {
        Assert.assertTrue(driver.findElement(lastNameError).isDisplayed(),
                "Last name error is NOT displayed!");
    }

    public void assertAddress1Error() {
        Assert.assertTrue(driver.findElement(address_1_Error).isDisplayed(),
                "Address 1 error is NOT displayed!");
    }

    public void assertCityError() {
        Assert.assertTrue(driver.findElement(cityError).isDisplayed(),
                "City error is NOT displayed!");
    }

    public void assertPostCodeError() {
        Assert.assertTrue(driver.findElement(PostCodeError).isDisplayed(),
                "Postcode error is NOT displayed!");
    }

    public void assertRegionError() {
        Assert.assertTrue(driver.findElement(regionError).isDisplayed(),
                "Region error is NOT displayed!");
    }

    public void assertAllEmptyErrors(){
        assertFirstNameError();
        assertLastNameError();
        assertCityError();
        assertRegionError();
        assertPostCodeError();
        assertAddress1Error();
    }
}
