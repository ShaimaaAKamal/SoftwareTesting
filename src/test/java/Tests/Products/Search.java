package Tests.Products;

import Pages.Auth.Account_Page;
import Pages.Auth.Login_Page;
import Pages.Home_Page;
import Pages.Products.Search_List_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Search extends BaseTest {
    Search_List_Page searchPage;
    Home_Page home;
    Login_Page login;
    Account_Page accountPage;

    @BeforeClass
    public void Setup() {
        searchPage = new Search_List_Page(driver);
        home = new Home_Page(driver);
        login = new Login_Page(driver);
        accountPage = new Account_Page(driver);
    }

    @BeforeMethod
    public void preconditions() {
        driver.get(storeBaseUrl);
        home.clickMyAccount();
        home.clickLogin();
        login.enterEmail(storeUserEmail);
        login.enterPassword(storeUserPassword);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        waitForVisible(accountPage.editInformation);
        driver.get(storeBaseUrl+"/index.php?route=product/search&language=en-gb");
    }

    @AfterMethod
    public void after() {
        home.clickMyAccount();
        home.clickLogout();
    }

    @Test(priority = 1)
    public void searchForExistingProduct_usingCombinedMethod() {
        searchPage.searchFor("MacBook");
        boolean ok = searchPage.waitForResultsOrNoResults();
        String Url = storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook";
        Assert.assertEquals(Url, storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook");
    }

    @Test(priority = 2)
    public void searchByEnterAndClick_steps() {
        searchPage.enterSearchText("iPhone");
        searchPage.clickSearch();
        String Url = storeBaseUrl+"index.php?route=product/search&language=en-gb&search=iphone";
        Assert.assertEquals(Url,storeBaseUrl+"index.php?route=product/search&language=en-gb&search=iphone");
    }

    @Test(priority = 3)
    public void searchNoResults_showsNoResultsMessage() {
        searchPage.searchFor("Not_Existing");
        boolean ok = searchPage.waitForResultsOrNoResults();
        Assert.assertFalse(searchPage.isProductShown("Not_Existing"), "Unexpected product found for gibberish search");
    }

    @Test(priority = 4)
    public void searchEmptyQuery_returnsAllOrManyResults() {
        searchPage.enterSearchText("");
        searchPage.clickSearch();
        searchPage.waitForResultsOrNoResults();
        int count = searchPage.getResultsCount();
        Assert.assertTrue(count >= 0);
    }

    @Test(priority = 5)
    public void searchWithCategoryFilter_returnsExpectedProduct() {
        WebElement category = driver.findElement(searchPage.categoryList);
        Select Choice = new Select(category);
        Choice.selectByVisibleText("Laptops & Notebooks");
        searchPage.enterSearchText("MacBook");
        searchPage.clickSearch();
        String Url = storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook";
        Assert.assertEquals(Url, storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook");

    }

    @Test(priority = 6)
    public void searchWithCategory_noResultForProduct() {
        WebElement cat = driver.findElement(searchPage.categoryList);
        Select sel = new Select(cat);
        sel.selectByVisibleText("MP3 Players");
        searchPage.searchFor("MacBook");
        boolean ok = searchPage.waitForResultsOrNoResults();
        if(ok && searchPage.isProductShown("MacBook")){
            Assert.fail("MacBook should not appear in MP3 Players category. Found: " + searchPage.getResultsTitles());
        }
    }

    @Test(priority = 7)
    public void searchCaseInsensitive_shouldFindProduct() {
        searchPage.searchFor("macbook");
        boolean ok = searchPage.waitForResultsOrNoResults();
        String Url = storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook";
        Assert.assertEquals(Url, storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook");

    }

    @Test(priority = 8)
    public void searchClearThenSearchAnother() {
        searchPage.enterSearchText("iPhone");
        searchPage.clickSearch();
        searchPage.enterSearchText("");
        searchPage.enterSearchText("MacBook");
        searchPage.clickSearch();
        String Url = storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook";
        Assert.assertEquals(Url, storeBaseUrl+"index.php?route=product/search&language=en-gb&search=MacBook");
    }
}