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

public class AddProdToCartTS5 extends BaseTest {
    WebDriverWait wait;
    @Test
    public void addProdToCartTS5() throws InterruptedException {
    WebDriver driver = PageDriver.getDriver();
    LoginPage loginPage = new LoginPage();
    loginPage.login("standard_user", "secret_sauce");
    ProductsPage productPage = new ProductsPage();
    productPage.waitForProduct();
    Assert.assertEquals(productPage.getItemsSize(), 6);
    Thread.sleep(2000);
    Assert.assertEquals(productPage.getItemsSize(), 6);
    Thread.sleep(2000);
        Assert.assertEquals(
                productPage.select_sortOption("Name (Z to A)").getFirstItemName()
                ,"Test.allTheThings() T-Shirt (Red)"
        );
        Thread.sleep(2000);
        String[] productNames = {"Sauce Labs Backpack", "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"};
        for (String productName : productNames) {
            WebElement product = driver.findElement(
                    By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
            WebElement addToCartBtn = product.findElement(
                    By.xpath("./ancestor::div[@class='inventory_item']//button[text()='Add to cart']"));
            addToCartBtn.click();
        }
        Assert.assertEquals(productPage.getCartCount(), "3");
        Thread.sleep(2000);
        Assert.assertEquals(
                productPage.select_sortOption("Price (low to high)").getFirstItemName()
                ,"Sauce Labs Onesie"
        );
        Thread.sleep(2000);
        String[] productNames2 = {"Sauce Labs Fleece Jacket", "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"};
        for (String productName2 : productNames2) {
            WebElement product = driver.findElement(
                    By.xpath("//div[@class='inventory_item_name' and text()='" + productName2 + "']"));
            WebElement addToCartBtn = product.findElement(
                    By.xpath("./ancestor::div[@class='inventory_item']//button[text()='Add to cart']"));
            addToCartBtn.click();
        }
        Thread.sleep(2000);
        WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartIcon.click();
        Assert.assertEquals(productPage.getCartCount(), "6");
        Thread.sleep(5000);
    }
}

