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
import pages.ProductsPage;

public class AddProdToCartTS2 extends BaseTest {
    WebDriverWait wait;
    @Test
    public void addProdToCartTS2() throws InterruptedException {
        WebDriver driver = PageDriver.getDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productPage = new ProductsPage();
        productPage.waitForProduct();
        Assert.assertEquals(productPage.getItemsSize(), 6);
        Thread.sleep(2000);
        Assert.assertEquals(productPage.getItemsSize(), 6);
        Thread.sleep(2000);
        String productName = "Sauce Labs Fleece Jacket";
        WebElement product = driver.findElement(
                By.xpath("//div[@class='inventory_item_name' and text()='"
                        + productName + "']"));
        WebElement addToCartBtn = product.findElement(
                By.xpath("./ancestor::div[@class='inventory_item']//button[text()='Add to cart']"));
        addToCartBtn.click();
        WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartIcon.click();
        Thread.sleep(2000);
        // Verify All items To Cart
        Assert.assertEquals(productPage.getCartCount(), "1");
        WebElement cartItem = driver.findElement(
                By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='"
                        + productName + "']"));
        String cartItemPrice = driver.findElement(
                By.xpath(".//div[@class='inventory_item_price']"))
                .getText();
        Assert.assertEquals(cartItemPrice, "$49.99");
        Thread.sleep(5000);
    }
}
