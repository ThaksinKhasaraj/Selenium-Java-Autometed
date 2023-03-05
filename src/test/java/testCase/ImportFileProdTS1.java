package testCase;

import base.BaseTest;
import base.ExcelReader;
import base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
public class ImportFileProdTS1 extends BaseTest {
    WebDriverWait wait;
    @Test
    public void ImportFileProdTS1() throws Exception {
        // go to the saucedemo.com and open browser
        WebDriver driver = PageDriver.getDriver();
        // Input valid username and password valid and click the login button
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");
        // Verify login success and products page opened
        ProductsPage productPage = new ProductsPage();
        productPage.waitForProduct();
        Assert.assertEquals(productPage.getItemsSize(), 6);
        Thread.sleep(5000);
        Assert.assertEquals(productPage.getItemsSize(), 6);
        // Verify add_All_items_ToCart
        productPage.add_All_items_ToCart();
        Assert.assertEquals(productPage.getCartCount(), "6");
        Thread.sleep(5000);
        // ExcelReader
        ExcelReader excelreader = new ExcelReader();
        excelreader.setExcelFile("./products_data.xlsx", "products");
        //Object obj[][] = excelreader.to2DArray();
        Thread.sleep(60);
        //productPage.select_sortOption("name (Z to A)"); and Validate FirstItemName Product
        Assert.assertEquals(
                productPage.select_sortOption("Name (Z to A)").getFirstItemName()
                ,"Test.allTheThings() T-Shirt (Red)"
        );
        Thread.sleep(5000);
        //productPage.select_sortOption("Price (low to high)")
        Assert.assertEquals(
                productPage.select_sortOption("Price (low to high)").getFirstItemName()
                ,"Sauce Labs Onesie"
        );
        Thread.sleep(5000);
        WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartIcon.click();
        // Verify All items To Cart
        Assert.assertEquals(productPage.getCartCount(), "6");
        Thread.sleep(5000);

    }

}
