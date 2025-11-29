package Pages.Auth.AccountFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AffilateAccount_Page {
    WebDriver driver;
    public By pageTitle= By.xpath("//h1[text()='Your Affiliate Information']");
    By company=By.xpath("//input[@id='input-company']");
    By website=By.xpath("//input[@id='input-website']");
    By taxId=By.xpath("//input[@id='input-tax']");
    By cheque=By.xpath("//label[@for='input-payment-cheque']");
    By paypal=By.xpath("//label[@for='input-payment-paypal']");
    By bankTransfer=By.xpath("//label[@for='input-payment-bank']");
    public By chequePayeeName=By.xpath("//input[@id='input-cheque']");
    By paypalMail=By.xpath("//input[@id='input-paypal']");
    By bankName=By.xpath("//input[@id='input-bank-name']");
    By branchNumber=By.xpath("//input[@id='input-bank-branch-number']");
    By swiftCode=By.xpath("//input[@id='input-bank-swift-code']");
    By accountName=By.xpath("//input[@id='input-bank-account-name']");
    public By accountNumber=By.xpath("//input[@id='input-bank-account-number']");
    By privacy = By.xpath("//input[@id='input-agree']");
    By continueBtn=By.xpath("//button[text()='Continue']");
    public By chequeError=By.xpath("//div[@id='error-cheque']");
    public By paypalError=By.xpath("//div[@id='error-paypal']");
    public By accountNameError=By.xpath("//div[@id='error-bank-account-name']");
    public By accountNumberError=By.xpath("//div[@id='error-bank-account-number']");
    public AffilateAccount_Page(WebDriver driver){
        this.driver=driver;
    }

    public void clickContinue(){
//        driver.findElement(continueBtn).click();
        WebElement element = driver.findElement(continueBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void enterCompantName(String name){
        driver.findElement(company).sendKeys(name);
    }

    public void clearCompanyName(){
        driver.findElement(company).clear();
    }

    public void enterWebsite(String site){
        driver.findElement(website).sendKeys(site);
    }
    public void clearWebsite(){
        driver.findElement(website).clear();
    }

    public void enterTaxId(String id){
        driver.findElement(taxId).sendKeys(id);
    }

    public void clearTaxId(){
        driver.findElement(taxId).clear();
    }

    public void enterChquePayName(String name){
        driver.findElement(chequePayeeName).sendKeys(name);
    }

    public void clearChquePayName(){
        driver.findElement(chequePayeeName).clear();
    }

    public void clickCheque(){
        driver.findElement(cheque).click();
    }

    public void clickBankTransafer(){
        driver.findElement(bankTransfer).click();
    }
    public void clickPaypal(){
        driver.findElement(paypal).click();
    }

    public void enterPaypalMail(String mail){
        driver.findElement(paypalMail).sendKeys(mail);
    }

    public void clearPaypalMail(){
        driver.findElement(paypalMail).clear();
    }

    public void enterBankName(String name){
        driver.findElement(bankName).sendKeys(name);
    }

    public void clearBankName(){
        driver.findElement(bankName).clear();
    }

    public void enterBranchNumber(String Bn){
        driver.findElement(branchNumber).sendKeys(Bn);
    }

    public void clearBranchNumber(){
        driver.findElement(branchNumber).clear();
    }

    public void enterSwiftCode(String code){
        driver.findElement(swiftCode).sendKeys(code);
    }

    public void clearSwiftCode(){
        driver.findElement(swiftCode).clear();
    }

    public void enterAccountName(String name){
        driver.findElement(accountName).sendKeys(name);
    }

    public void clearAccountName(){
        driver.findElement(accountName).clear();
    }

    public void enterAccountNumber(String num){
        driver.findElement(accountNumber).sendKeys(num);
    }

    public void clearAccountNumber(){
        driver.findElement(accountNumber).clear();
    }

    public void clickPrivacy(){
        driver.findElement(privacy).click();
    }




}
