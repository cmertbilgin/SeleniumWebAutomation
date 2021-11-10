package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    By cartPrice = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span[2]");
    By addProductButton = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/a[2]");
    By productQuantityField = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/input");
    By premoveProductButton = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div/a[1]/i");
    By confirmButton = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/a[1]");
    By emptyCartId = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div/div/p[1]");

    public CartPage(WebDriver driver){ super(driver); }

    public CartPage checkPrice(){

        WebElement w = webDriver.findElement(cartPrice);
        String val = w.getText();
        Assertions.assertEquals(productPrice,val);
        logger.info("Fiyatlar aynı.");
        return this;

    }

    public CartPage addProduct(){

        click(addProductButton);
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}
        return this;

    }

    public CartPage checkProductQuantity(){

        WebElement w = webDriver.findElement(productQuantityField);
        String val = w.getAttribute("data-quantity");
        Assertions.assertEquals("2",val);
        logger.info("Ürün adedi doğru");
        return this;

    }

    public CartPage removeProduct(){

        click(premoveProductButton);
        click(confirmButton);
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}
        return this;

    }

    public CartPage checkLastProduct(){
        WebElement w = webDriver.findElement(emptyCartId);
        String val = w.getText();
        Assertions.assertEquals("Sepetinizde ürün bulunmamaktadır.",val);
        logger.info("Sepet boş");
        return this;
    }

}
