package testCase;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTC1 extends BaseTest {
    WebDriverWait wait;
    @Test
    public void TC1LoginValid() throws InterruptedException {
        // go to the saucedemo.com and open browser
        WebDriver driver = PageDriver.getDriver();
        // Input valid username and password valid and click the login button
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");
        // Verify login success and products page opened
        ProductsPage productPage = new ProductsPage();
        productPage.waitForProduct();
        // closed browser
        PageDriver.getDriver().quit();
    }

}



