package Pages.Products;

import org.openqa.selenium.*;
        import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Search_List_Page {
    public WebDriver driver;
    public WebDriverWait wait;

    public Search_List_Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Primary locators (common OpenCart defaults)
    public By searchInput = By.name("search");
    public By categoryList = By.name("category_id");
    public By searchButton = By.cssSelector("button.btn.btn-primary");

    // Multiple possible result selectors (try all)
    private By[] resultsCandidates = new By[] {
            By.cssSelector("div.product-thumb"),
            By.cssSelector("div.product-layout"),
            By.cssSelector("div.product-list"),
            By.cssSelector("div.product-card"),
            By.cssSelector("div.product")
    };

    private void scrollTo(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, -120);");
    }

    private void safeClick(WebElement e){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(e)).click();
        }catch(Exception ex){
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", e);
        }
    }

    private WebElement findSearchInputCandidate(){
        By[] candidates = new By[] {
                By.name("search"),
                By.cssSelector("input[name='search']"),
                By.cssSelector("input[type='search']"),
                By.cssSelector("input[id*='search']"),
                By.cssSelector("input[class*='search']")
        };
        for(By c : candidates){
            List<WebElement> list = driver.findElements(c);
            if(list.size() > 0) return list.get(0);
        }
        return null;
    }

    public void enterSearchText(String text){
        WebElement input = findSearchInputCandidate();
        if(input == null){
            input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        }
        input.clear();
        input.sendKeys(text);
    }

    public void clickSearch(){
        try{
            WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
            scrollTo(btn);
            safeClick(btn);
            waitShort();
            if(!waitForResultsOrNoResults()){
                WebElement input = findSearchInputCandidate();
                if(input != null){
                    input.sendKeys(Keys.ENTER);
                }
                waitShort();
                waitForResultsOrNoResults();
            }
        }catch(Exception e){
            try {
                WebElement input = findSearchInputCandidate();
                if(input != null){
                    input.sendKeys(Keys.ENTER);
                    waitShort();
                    waitForResultsOrNoResults();
                }
            } catch(Exception ignored){}
        }
    }

    public void searchFor(String text){
        enterSearchText(text);
        clickSearch();
    }

    public boolean waitForResultsOrNoResults(){
        int tries = 0;
        while(tries < 30){ // total roughly up to ~15 seconds
            if(getResultsCount() > 0) return true;
            // check for common "no results" text
            List<WebElement> no = driver.findElements(By.xpath("//p[contains(text(),'There is no product that matches') or contains(.,'No results')]"));
            if(no.size() > 0 && no.get(0).isDisplayed()) return false;
            waitShort();
            tries++;
        }
        return getResultsCount() > 0;
    }

    public int getResultsCount(){
        for(By c : resultsCandidates){
            List<WebElement> list = driver.findElements(c);
            if(list.size() > 0) return list.size();
        }
        return 0;
    }

    public List<String> getResultsTitles(){
        List<String> titles = new ArrayList<>();
        List<By> titleCandidates = new ArrayList<>();
        titleCandidates.add(By.cssSelector("div.product-thumb a"));
        titleCandidates.add(By.cssSelector("div.product-layout a"));
        titleCandidates.add(By.cssSelector("div.product-card a"));
        titleCandidates.add(By.cssSelector("div.product-list a"));
        titleCandidates.add(By.cssSelector("div.product a"));
        for(By t : titleCandidates){
            List<WebElement> els = driver.findElements(t);
            if(els.size() > 0){
                for(WebElement e : els){
                    String txt = e.getText().trim();
                    if(!txt.isEmpty() && !titles.contains(txt)) titles.add(txt);
                }
            }
        }
        return titles;
    }

    public boolean isProductShown(String productName){
        if(productName == null) return false;
        String expect = productName.trim().toLowerCase();
        List<String> titles = getResultsTitles();
        for(String t : titles){
            String low = t.toLowerCase();
            if(low.equals(expect) || low.contains(expect)) return true;
        }
        return false;
    }

    private void waitShort(){
        try { Thread.sleep(400); } catch (Exception ignored) {}
    }
}