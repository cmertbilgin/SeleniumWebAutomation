package Test;

import Pages.HomePage;
import Pages.LoginPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public WebDriver webDriver;
    public HomePage homePage;
    protected static Logger logger = Logger.getLogger(BaseTest.class);

    public WebDriver getDriver(){
        return webDriver;
    }

    @BeforeAll
    public void classSetup(){

        logger.info("Test Başlıyor.");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        homePage = new HomePage(webDriver);

    }

    @AfterAll
    public void tearDown(){

        webDriver.quit();
        logger.info("Test bitti");

    }
}
