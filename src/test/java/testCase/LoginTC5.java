package testCase;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTC4 extends BaseTest {
    WebDriverWait wait;
@Test
    public void TC4LoginInvalid() {
    // go to the saucedemo.com web
    WebDriver driver = PageDriver.getDriver();
    // Input an invalid username and password valid and click the login button
    LoginPage loginPage = new LoginPage();
    loginPage.login("inn", "secret_sauce");
    // Verify that the login failed and display the error message
    WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
    String errorMessageText = errorMessage.getText();
    Assert.assertEquals(errorMessageText, "Epic sadface: Username and password do not match any user in this service",
            "Error message not displayed or incorrect.");
    // closed browser
    PageDriver.getDriver().quit();
    }
}



