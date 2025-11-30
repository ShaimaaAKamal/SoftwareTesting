package Tests.Auth.AccountFunctions;

import Pages.Auth.AccountFunctions.AffilateAccount_Page;
import Pages.Auth.AccountFunctions.NewLetters_Page;
import Pages.Auth.AccountFunctions.TrackingCode_Page;
import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Tests.BaseTest;
import net.datafaker.providers.entertainment.TheExpanse;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AffliateAccount extends BaseTest {
    AffilateAccount_Page account;
    Home_Page home;
    Account_Page accountPage;
    Login_Page login;
    TrackingCode_Page trackingCode;
    @BeforeMethod
    public void preCondition() {
        driver.get(storeBaseUrl);
        account = new AffilateAccount_Page(driver);
        accountPage=new Account_Page(driver);
        trackingCode=new TrackingCode_Page(driver);
        home=new Home_Page(driver);
        login=new Login_Page(driver);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        login.submitForm();
        waitForVisible(accountPage.editInformation);
    }

    @AfterMethod
    public void after(){
        accountPage.logout();
    }

    @Test(priority = 0)
    public void addAffliateExists(){
        if (!accountPage.isAddAfflicateAccountExists()) {
            throw new SkipException("Cannot run addAffliateExists() because no orders exist.");
        }
        accountPage.assertAddAffliateAccountLink();
 //        waitForVisible(accountPage.affliateAccount);
    }

    @Test(priority = 0, dependsOnMethods = "addAffliateExists")
    public void enterChequeWithAllEmptyFiedls(){
        accountPage.navigateTAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickContinue();
        waitForVisible(account.chequeError);
    }
    @Test(priority = 0, dependsOnMethods = "addAffliateExists")
    public void enterPayPalWithAllEmptyFiedls(){
        accountPage.navigateTAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickPaypal();
        account.clickContinue();
        waitForVisible(account.paypalError);
    }
    @Test(priority = 0 , dependsOnMethods = "addAffliateExists")
    public void enterBankTransferWithAllEmptyFiedls(){
        accountPage.navigateTAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickBankTransafer();
        account.clickContinue();
        waitForVisible(account.accountNameError);
    }
    @Test(priority = 0, dependsOnMethods = "addAffliateExists")
    public void enterBankTransferWithEmptyAccountName(){
        accountPage.navigateTAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickBankTransafer();
        account.enterAccountNumber("82013703930");
        account.clickContinue();
        waitForVisible(account.accountNameError);
    }
    @Test(priority = 0 , dependsOnMethods = "addAffliateExists")
    public void enterBankTransferWithEmptyAccountNumber(){
        accountPage.navigateTAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickBankTransafer();
        account.enterAccountName("test");
        account.clickContinue();
        waitForVisible(account.accountNumberError);
    }


    @Test(priority = 1, dependsOnMethods = "addAffliateExists")
    public void addWithValidChequeData(){
            accountPage.navigateTAffliateAccountUsingMainPage();
            waitForVisible(account.pageTitle);
            account.enterCompantName("temo");
            account.enterWebsite("https://www.temo.com");
            account.enterTaxId("123456789012");
            account.enterChquePayName("shaimaa");
            account.clickPrivacy();
            account.clickContinue();
            waitForVisible(accountPage.updatedSuccessfully);
    }

    @Test(priority = 1 )
    public void editAffliateExists(){
        waitForVisible
                (accountPage.editAffliate);
    }

    @Test(priority = 2, dependsOnMethods = "editAffliateExists")
    public void editChequeWithEmptyRequiredFields(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickCheque();
        account.clearChquePayName();
        account.clickContinue();
        waitForVisible(account.chequeError);
    }
    @Test(priority = 2, dependsOnMethods = "editAffliateExists")
    public void editPayPalWithEmptyRequiredFields(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickPaypal();
        account.clearPaypalMail();
        account.clickContinue();
        waitForVisible(account.paypalError);
    }
    @Test(priority = 2 , dependsOnMethods = "editAffliateExists")
    public void editBankTransferWithEmptyRequiredFields(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickBankTransafer();
        account.clearAccountName();
        account.clearAccountNumber();
        account.clickContinue();
        waitForVisible(account.accountNameError);
    }
    @Test(priority = 2, dependsOnMethods = "editAffliateExists")
    public void editBankTransferWithEmptyAccountName(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();        waitForVisible(account.pageTitle);
        account.clickBankTransafer();
        account.clearAccountName();
        account.clickContinue();
        waitForVisible(account.accountNameError);
    }
    @Test(priority = 2 , dependsOnMethods = "editAffliateExists")
    public void editBankTransferWithEmptyAccountNumber(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clickBankTransafer();
        account.clearAccountNumber();
        account.clickContinue();
        waitForVisible(account.accountNumberError);
    }

    @Test(priority = 2, dependsOnMethods = "editAffliateExists")
    public void editWithValidChequeData(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clearCompanyName();
        account.enterCompantName("teko");
        account.clearWebsite();
        account.enterWebsite("https://www.teko.com");
        account.clearTaxId();
        account.enterTaxId("9876543210234");
        account.clickCheque();
        account.clearChquePayName();
        account.enterChquePayName("Teko");
        account.clickContinue();
        waitForVisible(accountPage.updatedSuccessfully);
    }

    @Test(priority = 3, dependsOnMethods = "editAffliateExists")
    public void editWithValidPaypalData(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clearCompanyName();
        account.enterCompantName("teko");
        account.clearWebsite();
        account.enterWebsite("https://www.teko.com");
        account.clearTaxId();
        account.enterTaxId("9876543210234");
        account.clickPaypal();
        account.clearPaypalMail();
        account.enterPaypalMail("TEKO@gmail.com");
        account.clickContinue();
        waitForVisible(accountPage.updatedSuccessfully);
    }

    @Test(priority = 4 ,dependsOnMethods = "editAffliateExists")
    public void editWithValidBankTransferData(){
        accountPage.navigateToEditAffliateAccountUsingMainPage();
        waitForVisible(account.pageTitle);
        account.clearCompanyName();
        account.enterCompantName("teko");
        account.clearWebsite();
        account.enterWebsite("https://www.teko.com");
        account.clearTaxId();
        account.enterTaxId("9876543210234");
        account.clickBankTransafer();
        account.clearBankName();
        account.enterBankName("teko");
        account.clearBranchNumber();
        account.enterBranchNumber("987654321");
        account.clearSwiftCode();
        account.enterSwiftCode("23PICEPQWINEI");
        account.clearAccountName();
        account.enterAccountName("tekotekop");
        account.clearAccountNumber();
        account.enterAccountNumber("9898323");
        account.clickContinue();
        waitForVisible(accountPage.updatedSuccessfully);
    }


    @Test(priority = 5 ,dependsOnMethods = "editAffliateExists")
    public void displayTracingCode(){
        accountPage.navigateToCustomAffliateAccountUsingMainPage();
        waitForVisible(trackingCode.pageTitle);
        trackingCode.assertCodeValue();
    }

    @Test(priority = 5 ,dependsOnMethods = "editAffliateExists")
    public void generateTrackingLink() throws InterruptedException {
        accountPage.navigateToCustomAffliateAccountUsingMainPage();
        waitForVisible(trackingCode.pageTitle);
        trackingCode.clickGeneratorInput();
        waitForVisible(trackingCode.trackedItem);
        trackingCode.chooseTrackedItemBy();
        trackingCode.assertLinkValue();
//        trackingCode.clickContinue();
//        waitForVisible(accountPage.editInformation);
    }


    @Test(priority = 5 ,dependsOnMethods = "editAffliateExists")
    public void finsihTracking() throws InterruptedException {
        accountPage.navigateToCustomAffliateAccountUsingMainPage();
        waitForVisible(trackingCode.pageTitle);
        trackingCode.clickGeneratorInput();
        waitForVisible(trackingCode.trackedItem);
        trackingCode.chooseTrackedItemBy();
        trackingCode.assertLinkValue();
        trackingCode.clickContinue();
        waitForVisible(accountPage.editInformation);
    }


}
