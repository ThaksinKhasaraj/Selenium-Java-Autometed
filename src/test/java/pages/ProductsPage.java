package pages;

import base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public ProductsPage() {
        driver = PageDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
    By productsText = By.cssSelector(".title");
    By inventoryItems = By.cssSelector(".inventory_item");
    By addToCartButtons = By.cssSelector(".inventory_item button");
    By cartCount = By.cssSelector(".shopping_cart_badge");
    By sort_selector = By.cssSelector(".product_sort_container");
    By first_item_name = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_name");
    By first_item_price = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price");


    public void waitForProduct(){
        waitForEl(productsText);
    }

    public int getItemsSize(){
        return size(inventoryItems);
    }

    public String getCartCount(){
        return getText(cartCount);
    }

    public ProductsPage select_sortOption(String option){
        selectByOption(sort_selector, option);
        return this;
    }

    public String getFirstItemName(){
        return getText(first_item_name);
    }

    public String getFirstItemPrice(){
        return getText(first_item_price);
    }

    public void add_All_items_ToCart(){
        for(WebElement el : getEls(addToCartButtons)){
            el.click();
        }
    }




}
