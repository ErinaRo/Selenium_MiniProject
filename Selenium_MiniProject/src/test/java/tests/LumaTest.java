package tests;

import generics.Hooks;
import generics.TestData;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import pages.MyAccountPage;
import utils.EmailGenerator;
import utils.WebElemntMapper;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class LumaTest extends Hooks {


    RegisterPage registerPage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;
    WishlistPage wishList;
    ShoppingCart shoppingCart;
    MainPage mainPage;

    private static String email;
    private String password = "Test1234!@#";


    @BeforeAll
    public static void setupTestData() {
        email = EmailGenerator.generateRandomEmail();
    }



    @Test
    @Order(1)
    @Description(" Create an Account  ")
   // @Given ("I navigate to the Magento homepage")


    public void createNewAccount() throws InterruptedException {

       // @Given ("I navigate to the Magento homepage")
        driver.get("https://magento.softwaretestingboard.com/");

        // @When ("I click on the "Create an Account" link")
        mainPage = new MainPage(driver);
        mainPage.clickAccountLink();

        // @Then ("I should see the account creation page title")
        assertEquals(driver.getTitle(), "Create New Customer Account");

        // @When ("I fill in the account creation form")
        // @And ("I click the "Create an Account" button")
        registerPage = new RegisterPage(driver);
        registerPage.createNewAccount("erina", "roshi", email, password, password);

        // @Then ("I should see a successful account creation message")
        myAccountPage = new MyAccountPage(driver);
        Thread.sleep(1000);
        assertEquals(myAccountPage.checkWelcomeMessage(), "Thank you for registering with Main Website Store.");

        // @And ("I should sign out")
        myAccountPage.signOut();

    }



    @Order(2)
    @Test
    @Description(" Sign In    ")
    public void loginTest() throws InterruptedException {

       // @Given ("I navigate to the Magento homepage")
        driver.get("https://magento.softwaretestingboard.com/");

        // @When ("I click on the "Sign In" link")
        mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        // @And ("I log in with valid credentials")
        loginPage = new LoginPage(driver);
        loginPage.login(email,password);

        // @Then ("I should see my username displayed on the page")
        myAccountPage = new MyAccountPage(driver);

        //WebDriverWait wait = new WebDriverWait(driver,20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")));
        Thread.sleep(1000);
        assertEquals(myAccountPage.checkUserNameIsCoorect(), "Welcome, erina roshi!");

        // @When ("I sign out")
        myAccountPage.signOut();
    }


    @Order(3)
    @Test
    @Description(" Check page filters  ")
    public void checkPageFilters() {

        // @Given ("I navigate to the Magento homepage")
        driver.get("https://magento.softwaretestingboard.com/");


        mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        // Login with the credentials created from Test 1.
        loginPage = new LoginPage(driver);
        loginPage.login(email,password);

        //1. On store menu click on Women dropdown.
        myAccountPage = new MyAccountPage(driver);

        //2. Hover over Tops dropdown on the open pop up and click on Jacket menu
        //option.
        myAccountPage.hoverOverWomanFilter();
        //3. From Shopping Options panel click on Color dropdown and choose one of the
        //colors.
        //4. Click on Price dropdown and select the first option ($50.00 - $59.99).
        myAccountPage.clickColorAndPriceInFilter();

        //5. For each product displayed, check that the price matches the defined criteria.
       //myAccountPage.verifyPriceMatch();

        }

    @Order(4)
    @Test
    @Description(" Wish List test ")
    public void wishList() throws InterruptedException {
        //1.Precondition: Test 3

        //1. Remove Price filter.
        Thread.sleep(2000);
       myAccountPage = new MyAccountPage(driver);
       myAccountPage.clickRemovePriceFilter();

       Thread.sleep(2000);
        //2. Set in filter size xs
        myAccountPage.clickSizeFilerAndNumber();

        Thread.sleep(2000);
        //3. Check the items number displayed is increased.
       assertEquals("6 Items", myAccountPage.checkTheItemsNumberDisplayedIsIncreased());


        //4. Add the two first item in the Wish List.
        Thread.sleep(2000);
        myAccountPage.add1ElementsToWishList();
        //5. Check successful message text
        wishList = new WishlistPage(driver);
        assertEquals(wishList.checkTheSuccesfulMessage1(), "Olivia 1/4 Zip Light Jacket has been added to your Wish List. Click here to continue shopping.");
        wishList.clickHereLink();
        Thread.sleep(2000);
        // Check successful message text
        myAccountPage.add2ElementsToWishList();
        assertEquals(wishList.checkTheSuccesfulMessage2(), "Juno Jacket has been added to your Wish List. Click here to continue shopping.");

        //6. Click on User Profile, and check the correct number of items is displayed (My Wish List (2 items)).
        myAccountPage.clickUserProfile();
        assertEquals(myAccountPage.checkTheCorrectNumberOfItemsIsDisplayed(), "2 items");

    }

    @Order(5)
    @Test
    @Description(" Shopping Cart test ")
    public void ShoppingCartTest(){
       //1Precondition: Test 3

        // 2.Add all displayed items to the Shopping Cart.
        wishList=new WishlistPage(driver);
        wishList.addAllElementsToCard();

        //3.Check successful message text
        assertEquals(wishList.checkTheSuccessfullShoppingMessage(), "2 product(s) have been added to shopping cart: \"Olivia 1/4 Zip Light Jacket\", \"Juno Jacket\".");

        //4.Open the Shopping Cart
         wishList.goToShoppingCard();

        //5.Verify that we have navigate to Shopping Cart Page
        shoppingCart= new ShoppingCart(driver);
        assertEquals(driver.getTitle(), "Shopping Cart");

   /*   //6. Verify that the prices sum for all items is equal to Order Total price in the Summary section.
        Integer summary  = WebElemntMapper.webElementWithCurrencyValueToNumber(driver.findElement(By.xpath("//*[@id="cart-totals"]/div/table/tbody/tr[3]/td/strong/span"))));
        WebElement displayedValue1 = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[1]/td[4]/span/span/span"));
        WebElement displayedValue2 = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[1]/td[4]/span/span/span"));

        Integer sumOfAllSales = WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue1) +
                WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue2);

        assertEquals(summary, sumOfAllSales);*/

        //7.close driver*/
    }

    @Test
    @Order(6)
    @Description("Empty Shopping Cart Test")
    public void emptyShoppingCartTest() throws InterruptedException {
        // Precondition: Test 3 & Test 4

        //1.	Delete the first item on shopping cart
        shoppingCart = new ShoppingCart(driver);
        shoppingCart.clickFirstItemFromShoppingCartDeleteButton();

        //2.	Verify that the number of elements in Shopping Cart table is decreased by 1
        myAccountPage = new MyAccountPage(driver);

        Thread.sleep(1000);
       assertEquals("1", myAccountPage.checkShoppingCartItemQuantityOnMenuBar());

        //3.	Repeat steps 1&2 until the last item is deleted
        shoppingCart.clickFirstItemFromShoppingCartDeleteButton();

        //4.	Verify that Shopping Cart is empty
        Thread.sleep(1000);
        assertEquals("You have no items in your shopping cart.", shoppingCart.checkNoProductsInShoppingCart());

        //5. Sign out
       myAccountPage.signOut();
    }
}







