package Pages.Admin;

import Pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Dashboard_Page extends Base_Page {
    public  By pageTitle=By.xpath("//h1[contains(text(), 'Dashboard')]");
    By settingsBtn = By.cssSelector("button.btn.btn-info > i.fa-cog");
    By TopCards = By.cssSelector(".container-fluid  .tile.tile-primary");
    By bodyCards=By.cssSelector("div.card.mb-3");
   public By settingModal=By.cssSelector("div.modal-dialog");
    public By logout = By.cssSelector("#nav-logout > a");

    public Dashboard_Page(WebDriver driver){
        super(driver);
    }

    public void clickLogout(){
        scrollAndClick(logout);
    }

    private List<WebElement> GetTopCards(){
        List<WebElement> cards=driver.findElements(TopCards);
        return cards;
    }
    private List<WebElement> GeBodyCards(){
        List<WebElement> innerCards=driver.findElements(bodyCards);
        return innerCards;
    }

    private WebElement getSingleCardUsingIndex(int index,List<WebElement> cards){
        return cards.get(index);
    }

    public WebElement getSingleTopCardsUsingIndex(int index){
        return getSingleCardUsingIndex(index,GetTopCards());
    }
    public WebElement getSingleBodyCardsUsingIndex(int index){
        return getSingleCardUsingIndex(index,GeBodyCards());
    }
    public void clickSettingBtn(){
        driver.findElement(settingsBtn).click();
    }


    public void assertInDashboard(){
        Assert.assertTrue(driver.findElement(pageTitle).isDisplayed());
    }

    public void asserSettingBtnIsExist(){
        Assert.assertTrue(driver.findElement(settingsBtn).isDisplayed());
    }


    public void assertSettingModalIsExist(){
        Assert.assertTrue(driver.findElement(settingModal).isDisplayed());
    }

    public void assertOrderTopCardStrucure(){
        WebElement order= getSingleTopCardsUsingIndex(0);
        setTopCardsStructure(order,"TOTAL ORDERS",".tile-body > i.fa-shopping-cart");

    }

    public void assertOrderCardLinkNavigation(){
        topCardLinkNavigation(0);
    }

    public void assertSalesCardLinkNavigation(){
        topCardLinkNavigation(1);
    }

    public void assertCustomersCardLinkNavigation(){
        topCardLinkNavigation(2);
    }

    public void assertOnlinePeopleCardLinkNavigation(){
        topCardLinkNavigation(3);
    }

    public void asserSalesTopCardStrucure(){
        WebElement order= getSingleTopCardsUsingIndex(1);
        setTopCardsStructure(order,"TOTAL SALES",".tile-body > i.fa-credit-card");
    }


    public void asserCustomersTopCardStrucure(){
        WebElement order= getSingleTopCardsUsingIndex(2);
        setTopCardsStructure(order,"TOTAL CUSTOMERS",".tile-body > i.fa-user");
    }


    public void asserOnlinePeopleTopCardStrucure(){
        WebElement order= getSingleTopCardsUsingIndex(3);
        setTopCardsStructure(order,"PEOPLE ONLINE",".tile-body > i.fa-users");
    }

    private void setTopCardsStructure(WebElement element,String title,String locator){
        Assert.assertTrue(element.findElement(By.cssSelector(".tile-heading")).isDisplayed());
        Assert.assertTrue(element.findElement(By.cssSelector(".tile-heading")).getText().contains(title));
        Assert.assertTrue(element.findElement(By.cssSelector(".tile-body")).isDisplayed());
        Assert.assertTrue(element.findElement(By.cssSelector(locator)).isDisplayed());
        Assert.assertTrue(element.findElement(By.cssSelector(".tile-footer")).isDisplayed());
        Assert.assertTrue(element.findElement(By.cssSelector(".tile-footer > a")).isDisplayed());
        Assert.assertEquals(element.findElement(By.cssSelector(".tile-footer > a")).getText(),"View more...");
    }


    public void asserWorldWebStrucure(){
        WebElement order= getSingleBodyCardsUsingIndex(0);
        setBodyCardsStructure(order,"World Map",".card-header > i.fa-globe");
    }

    public void asserAnalyticsStrucure(){
        WebElement order= getSingleBodyCardsUsingIndex(1);
        setBodyCardsStructure(order,"Sales Analytics",".card-header > i.fa-chart-bar");
    }
    public void asserRecentActivityStrucure(){
        WebElement order= getSingleBodyCardsUsingIndex(2);
        RecentActivityStructure(order,"Recent Activity",".card-header > i.fa-calendar");
    }

    public void asserLatestOrdersStrucure(){
        WebElement order= getSingleBodyCardsUsingIndex(3);
        setLatestOrderesStructure(order,"Latest Orders",".card-header > i.fa-shopping-cart");
    }
    private void setBodyCardsStructure(WebElement element,String title,String locator) {
        commonBodyCardStructures( element, title, locator);
        Assert.assertTrue(element.findElement(By.cssSelector(".card-body")).isDisplayed());
    }

    private void setLatestOrderesStructure(WebElement element,String title,String locator) {
        commonBodyCardStructures( element, title, locator);
        Assert.assertTrue(element.findElement(By.cssSelector(".table-responsive")).isDisplayed());
    }

    private void RecentActivityStructure(WebElement element,String title,String locator) {
        commonBodyCardStructures( element, title, locator);
        Assert.assertTrue(element.findElement(By.cssSelector(".list-group.list-group-flush")).isDisplayed());
    }

    private void commonBodyCardStructures(WebElement element,String title,String locator){
        Assert.assertTrue(element.findElement(By.cssSelector(".card-header")).isDisplayed());
        Assert.assertTrue(element.findElement(By.cssSelector(".card-header")).getText().contains(title));
        Assert.assertTrue(element.findElement(By.cssSelector(locator)).isDisplayed());
    }

    private void topCardLinkNavigation(int index){
        WebElement order= getSingleTopCardsUsingIndex(index);
        order.findElement(By.cssSelector(".tile-footer > a")).click();
    }

}

