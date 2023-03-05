package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    WebDriver driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        String browserName = System.getProperty("browser", "chrome");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com/");
        PageDriver.setDriver(driver);
    }
    @AfterClass
    public void tearDown(){
        PageDriver.getDriver().quit();
    }

}
