package pages;

import org.openqa.selenium.WebDriver;
import base.PagesDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import base.PagesDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage() {
        driver = PagesDriver.getDriver();
    }
    public WebElement userName = driver.findElement(By.id("user-name"));
    public WebElement password = driver.findElement(By.id("password"));
    public WebElement btnLogin = driver.findElement(By.id("login-button"));

    public void login(String username, String Password) {
        userName.sendKeys(username);
        password.sendKeys(Password);
        btnLogin.click();
    }
}
