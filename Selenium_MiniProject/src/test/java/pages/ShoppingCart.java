package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.PageFactory.initElements;

public class ShoppingCart {
    WebDriver driver;

    // Get the summary amount from the element

    @FindBy(className = "grand totals")
    static WebElement summaryElement;

    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[4]/span/span/span")
    WebElement displayedValue1;

    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[1]/td[4]/span/span/span")
    WebElement displayedValue2;

    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[2]/td/div/a[3]")
    WebElement deleteFirstItem;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]")
    WebElement noProductsInShoppingCart;

    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[2]/td/div/a[3]")
    WebElement deleteSecondItem;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public void clickFirstItemFromShoppingCartDeleteButton(){
        deleteFirstItem.click();
    }
    public boolean noProductsInShoppingCartIsVisible(){
        return noProductsInShoppingCart.isDisplayed();
    }
    public String checkNoProductsInShoppingCart(){
        return noProductsInShoppingCart.getText();
    }

}
