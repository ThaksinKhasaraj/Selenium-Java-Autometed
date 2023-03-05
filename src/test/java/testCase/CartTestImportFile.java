package testCase;

import base.ExcelReader;
import base.PageDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
public class CartTestImportFile {
    WebDriverWait wait;
    LoginPage loginPage;
    @Test
    public void Test_TestProductItems() throws Exception {
        WebDriver driver = PageDriver.getDriver();

        ProductsPage productPage = new ProductsPage();
        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);

        productPage.waitForProduct();
        Thread.sleep(2000);
        Assert.assertEquals(productPage.getItemsSize(), 6);

        Thread.sleep(2000);
        Assert.assertEquals(productPage.getItemsSize(), 6);

        productPage.add_All_items_ToCart();
        Assert.assertEquals(productPage.getCartCount(), "6");
        Thread.sleep(2000);

        ExcelReader excelreader = new ExcelReader();
        excelreader.setExcelFile("./products_data.xlsx", "products");

        Object obj[][] = excelreader.to2DArray();

        Thread.sleep(30);

        //productPage.select_sortOption("name (Z to A)");
        Assert.assertEquals(
                productPage.select_sortOption("Name (Z to A)").getFirstItemName()
                ,"Test.allTheThings() T-Shirt (Red)"
        );
        Thread.sleep(3000);
        Assert.assertEquals(
                productPage.select_sortOption("Price (low to high)").getFirstItemName()
                ,"Sauce Labs Onesie"
        );
        Thread.sleep(3000);
    }

}
