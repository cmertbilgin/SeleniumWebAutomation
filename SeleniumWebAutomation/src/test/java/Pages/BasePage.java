package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver webDriver;
    public WebDriverWait wait;
    public static String productPrice;

    protected static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    //Click
    public void click(By by){
        waitVisibility(by).click();
    }

    //Wait
    public WebElement waitVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Write Text
    public void writeText(By by, String text){

        webDriver.findElement(by).clear();
        waitVisibility(by).sendKeys(text);
        waitVisibility(by).sendKeys(Keys.ENTER);

    }

    //Find Locator
    public WebElement find(By by){return webDriver.findElement(by);}

    //Check
    public boolean isDisplayed(By by){return find(by).isDisplayed();}
}
