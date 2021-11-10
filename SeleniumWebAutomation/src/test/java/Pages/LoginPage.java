package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By userNameId = By.id("LoginEmail");
    By passwordId = By.id("Password");
    By loginButtonId = By.id("loginLink");

    public LoginPage(WebDriver driver){ super(driver); }

    public HomePage loginToWebSite(String username, String password){

        logger.info("Giriş yapılıyor.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        return new HomePage(webDriver);

    }

}
