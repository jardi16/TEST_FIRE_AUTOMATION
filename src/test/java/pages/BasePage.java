package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    static String chromepath = "src\\drivers\\chromedriver.exe";

    static {
        System.setProperty("webdriver.chrome.driver",chromepath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,3);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,3);
    }

    public WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void navigateTo(String url){
        driver.get(url);
    }
    public static void closeBrowser(){
        driver.quit();
    }
    public void click(String locator){
        Find(locator).click();
    }

    public void write(String locator,String data){
        Find(locator).sendKeys(data);
    }

    public String getTextFromElement(String locator){
        return Find(locator).getText();
    }

    public void dropDown(String locator,String valueToSelect){
        Select dropDown = new Select(Find(locator));
        dropDown.selectByValue(valueToSelect);
    }

}
