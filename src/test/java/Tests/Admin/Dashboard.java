package Tests.Admin;

import Pages.Admin.Admin_Login_Page;
import Pages.Admin.Customers.Customers_Page;
import Pages.Admin.Dashboard_Page;
import Pages.Admin.Orders.Orders_Page;
import Pages.Admin.Orders.Single_Order_Page;
import Pages.Admin.Reports_Page;
import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard extends BaseTest {
    Admin_Login_Page login;
    Dashboard_Page dashboard;
    Orders_Page orders;
    Customers_Page customers;
    Reports_Page reports;
    @BeforeMethod
    public void Precondition(){
        login=new Admin_Login_Page(driver);
        dashboard=new Dashboard_Page(driver);
        orders=new Orders_Page(driver);
        customers=new Customers_Page(driver);
        reports=new Reports_Page(driver);
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

    @Test(priority = 0)
    public void assertInDashboard(){
        waitForVisible(dashboard.pageTitle);
        dashboard.assertInDashboard();
    }

    @Test(priority = 1)
    public void asserSettingBtnIsExist(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserSettingBtnIsExist();
    }

    @Test(priority = 1)
    public void asserSettingBtnIsClickable(){
        waitForVisible(dashboard.pageTitle);
        dashboard.clickSettingBtn();
        waitForVisible(dashboard.settingModal);
        dashboard.assertSettingModalIsExist();
    }

    @Test(priority = 1)
    public void assertOrderCardIsDisplayed(){
        waitForVisible(dashboard.pageTitle);
        dashboard.assertOrderTopCardStrucure();
    }

    @Test(priority = 1)
    public void assertOrderCardLinKNavigation(){
        waitForVisible(dashboard.pageTitle);
        dashboard.assertOrderCardLinkNavigation();
        waitForVisible(orders.pageTitle);
        orders.assertAdminOrdersPage();
    }

    @Test(priority = 1)
    public void asserCustomersTopCardStrucure(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserCustomersTopCardStrucure();
    }

    @Test(priority = 1)
    public void assertCustomersCardLinKNavigation(){
        waitForVisible(dashboard.pageTitle);
        dashboard.assertCustomersCardLinkNavigation();
        waitForVisible(customers.pageTitle);
        customers.assertInCustomersPage();
    }



    @Test(priority = 1)
    public void asserOnlinePeopleTopCardStrucure(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserOnlinePeopleTopCardStrucure();
    }

    @Test(priority = 1)
    public void assertOnlinePeopleLinKNavigation(){
        waitForVisible(dashboard.pageTitle);
        dashboard.assertOnlinePeopleCardLinkNavigation();
        waitForVisible(reports.pageTitle);
        reports.assertInReportssPage();
    }

    @Test(priority = 1)
    public void asserSalesTopCardStrucure(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserSalesTopCardStrucure();
    }


    @Test(priority = 1)
    public void assertSalesCardLinKNavigation(){
        waitForVisible(dashboard.pageTitle);
        dashboard.assertSalesCardLinkNavigation();
        waitForVisible(orders.pageTitle);
        orders.assertAdminOrdersPage();
    }

    @Test(priority = 1)
    public void asserWorldWebStrucure(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserWorldWebStrucure();
    }

    @Test(priority = 1)
    public void asserLatestOrdersStrucure(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserLatestOrdersStrucure();
    }

    @Test(priority = 1)
    public void asserAnalyticsStrucure(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserAnalyticsStrucure();
    }


    @Test(priority = 1)
    public void asserRecentActivityStrucure(){
        waitForVisible(dashboard.pageTitle);
        dashboard.asserRecentActivityStrucure();
    }



}
