package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[2]/a[1]")
    WebElement addFisrtElementToWishlist;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[4]/div/div[2]/a[1]")
    WebElement addSecondElementToWishlist;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement SuccesfullMessage1;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement SuccesfullMessage2;

    @FindBy(xpath = "//*[@id=\"ui-id-4\"]")
    WebElement WomanFilter;

    @FindBy(id = "ui-id-11")
    WebElement Jackets;

    @FindBy(xpath = "//*[@id=\"wishlist-view-form\"]/div[2]/div[1]/button[3]")
    WebElement AddAllToCardButton;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a/span[2]")
    WebElement shoppingCard;

    @FindBy(linkText = "here")
    WebElement ClickHerelink;

    @FindBy(linkText = "View and Edit Cart")
    WebElement ViewAndEditShoppingCard;

    @FindBy(xpath ="//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement SuccessMessageAddToShoppingCard;
    Actions action;

    public WishlistPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Actions action;
    }

    public String checkTheSuccesfulMessage1() {
        return SuccesfullMessage1.getText();
    }
    public String checkTheSuccesfulMessage2() {
        return SuccesfullMessage2.getText();
    }
    public String checkTheSuccessfullShoppingMessage() {
        return SuccessMessageAddToShoppingCard.getText();
    }

    public void goBackToItems() {
        WomanFilter.click();
        Jackets.click();
    }

    public void addAllElementsToCard() {
        AddAllToCardButton.click();

    }
    public void goToShoppingCard() {
        shoppingCard.click();
        ViewAndEditShoppingCard.click();
    }

    public void clickHereLink() {
        ClickHerelink.click();
    }
}


