package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    By productSize;
    By addToCartButton = By.id("pd_add_to_cart");
    By cartButton = By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a");
    By productDiscountCartPrice = By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div[2]/div[2]");
    By productCartPrice = By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[1]/div[3]/span");

    int [] productSizeArray = {1,2,3,4,5,6,7,8,9,10,11};

    public ProductPage(WebDriver driver){ super(driver); }

    public ProductPage addToCart(){

        for(int i=0;i<10;i++){
            if(isDisplayed(By.xpath("//*[@id=\"option-size\"]/a["+productSizeArray[i]+"]")) == true){
                productSize = By.xpath("//*[@id=\"option-size\"]/a["+productSizeArray[i]+"]");
                click(productSize);
            }
        }

        click(addToCartButton);

        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}

        if(isDisplayed(productDiscountCartPrice) == true){
            setProductPrice(productDiscountCartPrice);
        } else {
            setProductPrice(productCartPrice);
        }
        return this;

    }

    public CartPage goToCart(){

        click(cartButton);
        return new CartPage(webDriver);

    }

    public ProductPage setProductPrice(By by){
        WebElement w = webDriver.findElement(by);
        String val = w.getText();
        productPrice = val;
        return this;
    }
}
