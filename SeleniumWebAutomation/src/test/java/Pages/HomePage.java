package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    String baseURL = "https://www.lcwaikiki.com/";
    By loginButtonClass = By.className("dropdown-toggle");
    By loginStatusId = By.className("dropdown-label");
    By searchBoxId = By.id("search_input");
    //By searchBoxButton = By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div[1]/div/button");

    public HomePage(WebDriver driver){ super(driver); }

    public HomePage goToHomepage(){
        logger.info("LC Waikiki sitesi açılıyor.");
        webDriver.get(baseURL);
        return this;
    }

    public HomePage checkHomepage(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver ;
        String ready = (String) js.executeScript("return document.readyState");
        Assertions.assertEquals("complete",ready);
        logger.info("Anasayfa açıldı.");
        return this;
    }

    public LoginPage goToLoginPage(){
        logger.info("Giriş sayfası açılıyor.");
        click(loginButtonClass);
        return new LoginPage(webDriver);
    }

    public HomePage checkLoginStatus(){

        Assertions.assertEquals(true,isDisplayed(loginStatusId));
        logger.info("Giriş başarıyla gerçekleşti.");
        return this;

    }

    public SearchPage search(String text){

        writeText(searchBoxId, text);
        //click(searchBoxButton);
        return new SearchPage(webDriver);

    }

}
