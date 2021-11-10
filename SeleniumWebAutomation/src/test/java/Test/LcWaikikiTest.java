package Test;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LcWaikikiTest extends BaseTest {

    @Test
    public void test(){

        homePage
                .goToHomepage()
                .checkHomepage()
                .goToLoginPage()
                .loginToWebSite("alllegro103@gmail.com","a123456")
                .checkLoginStatus()
                .search("pantolon")
                .scrollDown()
                .clickMoreProduct()
                .clickProduct()
                .addToCart()
                .goToCart()
                .checkPrice()
                .addProduct()
                .checkProductQuantity()
                .removeProduct()
                .checkLastProduct();

    }

}
