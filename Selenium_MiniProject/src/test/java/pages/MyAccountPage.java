package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;
    Actions action;

    //Thank you message
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement resultLabel;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement userProfile;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
    WebElement verifyUserNameInPanel;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a/span")
    WebElement myWishListItems;
    //Filter
    @FindBy(xpath = "//*[@id=\"ui-id-4\"]")
    WebElement WomanFilter;

    @FindBy(id = "ui-id-9")
    WebElement WomanTops;

    @FindBy(xpath = "//*[@id=\"ui-id-11\"]")
    WebElement Jackets;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[4]/div[1]")
    WebElement ColorDropdown;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[4]/div[2]/div/div/a[2]/div")
    WebElement Color;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[10]/div[1]")
    WebElement PriceDropdown;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[10]/div[2]/ol/li[1]/a")
    WebElement Price;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[2]/div[1]")
    WebElement SizeFilter;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[2]/div[2]/div/div/a[1]/div")
    WebElement SizeNumber;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement welcomeLabel;

    //Arrow to log out
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement arrow;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    WebElement signOut;

    @FindBy(xpath = "//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li[2]/a")
    WebElement removePriceFilter;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[1]/div[2]/a[1]")
    WebElement addFisrtElementToWishlist;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[4]/div[1]/div[2]/a[1]")
    WebElement addSecondElementToWishlist;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
    WebElement userNameIsCorrect;

    @FindBy(css = ".price")
    WebElement priceElement;

    @FindBy(className = "counter-label")
    WebElement shoppingCartItemQuantityOnMenuBar;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[2]/a[1]")
    WebElement firstElement;

    @FindBy(xpath = "//img[@alt='Juno Jacket-XS-Blue']")
    WebElement secondElement;

    @FindBy(id = "toolbar-amount")
    WebElement totalNumberIncrease;

    @FindBy(xpath = "//*[@id=\"mode-list\"]")
    WebElement ListFilter;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);  // Initialize Actions
    }

    public String returnResultMessage() {
        return resultLabel.getText();
    }

    public String checkWelcomeMessage() {
        return welcomeLabel.getText();
    }

    public String checkUserNameIsCoorect() {
        return userNameIsCorrect.getText();
    }
/*
    public String priceText = priceElement.getText();

    // Get the text from the price element and convert it to a numerical value
    public String priceTextReplace = priceElement.getText().replace("$", "").replace(",", "").trim();
    double priceValue = Double.parseDouble(priceText);
    // Define the range
    double minPrice = 50.00;
    double maxPrice = 59.99;

    // Define the expected values
    public String[] expectedPrices = {"($50.00)", "($59.99)"};
*/

    public void hoverOverWomanFilter() {
        action.moveToElement(WomanFilter);
        action.moveToElement(WomanTops);
        action.moveToElement(Jackets);
        action.click().build().perform();
    }

    public void clickUserProfile() {
        userProfile.click();
    }

    public String checkTheCorrectNumberOfItemsIsDisplayed() {
        return myWishListItems.getText();
    }

    public void clickColorAndPriceInFilter() {
        ColorDropdown.click();
        Color.click();
        PriceDropdown.click();
        Price.click();
    }

    public void clickSizeFilerAndNumber() {
        SizeFilter.click();
        SizeNumber.click();
    }

    public void clickRemovePriceFilter() {
        removePriceFilter.click();
    }

    public String checkTheItemsNumberDisplayedIsIncreased() {
        return totalNumberIncrease.getText();
    }
/*
    public void hoverOverFirstElement ()
    {  // action.moveToElement(firstElement);
        action.moveToElement(addFisrtElementToWishlist);
        action.click().build().perform();
    }

    public void hoverOverSecondElement ()
    {
        //action.moveToElement(secondElement);
        action.moveToElement(addSecondElementToWishlist);
        action.click().build().perform();
    }

 */
    public void add1ElementsToWishList() {
        ListFilter.click();
        addFisrtElementToWishlist.click();
    }

    public void add2ElementsToWishList() {
        addSecondElementToWishlist.click();
    }


    public void addFirstElementsToWishList() {
        addFisrtElementToWishlist.click();
    }

    public void addSecondElementsToWishList() {
        addSecondElementToWishlist.click();
    }

    public void signOut() {
        arrow.click();
        signOut.click();
    }

    /*
        public void verifyPriceMatch() {
            boolean isPriceValid = false;
            for (String expectedPrice : expectedPrices) {
                if (priceText.equals(expectedPrice)) {
                    isPriceValid = true;
                    break;
                }
            }
        }

     */
    public String checkShoppingCartItemQuantityOnMenuBar() {
        return shoppingCartItemQuantityOnMenuBar.getText();
    }
}










