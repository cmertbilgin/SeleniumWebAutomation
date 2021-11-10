package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    By productSize = By.xpath("//*[@id=\"option-size\"]/a[1]");
    By addToCartButton = By.id("pd_add_to_cart");
    By cartButton = By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a");
    By productCartPrice = By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div[2]");

    public ProductPage(WebDriver driver){ super(driver); }

    public ProductPage addToCart(){

        click(productSize);
        click(addToCartButton);
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}
        WebElement w = webDriver.findElement(productCartPrice);
        String val = w.getText();
        productPrice = val;
        return this;

    }

    public CartPage goToCart(){

        click(cartButton);
        return new CartPage(webDriver);

    }

}
