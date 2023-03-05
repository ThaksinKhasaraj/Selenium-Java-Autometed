package pages;

import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.ID;

public class LoginPage {
    WebDriver driver;
    public LoginPage() {
        driver = PageDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (how = ID, using = "user-name")
    public WebElement userName;
    @FindBy (how = ID, using = "password")
    @CacheLookup
    public WebElement password;
    @FindBy (how = ID, using = "login-button")
    public WebElement btnLogin;

    public void login(String username, String Password) {
        userName.sendKeys(username);
        password.sendKeys(Password);
        btnLogin.click();
    }


}
