package testCase;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 extends BaseTest {
    WebDriverWait wait;


        @Test(priority = 2)
        public void testLoginInvalid() {
            // go to the saucedemo.com web
            WebDriver driver = PageDriver.getDriver();
            // Enter an invalid username and/or password and click the login button
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.sendKeys("invalid_user");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("invalid_password");
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
            // Verify that the login failed and display the error message
            WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
            String errorMessageText = errorMessage.getText();
            Assert.assertEquals(errorMessageText, "Epic sadface: Username and password do not match any user in this service",
                    "Error message not displayed or incorrect.");
            // closed the saucedemo.com web
            PageDriver.getDriver().quit();
        }
    }



