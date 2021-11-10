package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    By moreProductButton = By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[4]/a/p");
    By productLocator = By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]/div[96]/a/div[1]/img[1]");

    public SearchPage(WebDriver driver){ super(driver); }

    public SearchPage scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,250)","");
        return this;
    }

    public SearchPage clickMoreProduct(){

        click(moreProductButton);
        return this;

    }

    public ProductPage clickProduct(){

        click(productLocator);
        return new ProductPage(webDriver);

    }

}
