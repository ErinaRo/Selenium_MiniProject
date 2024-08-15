package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;
    Actions action;

    @FindBy(linkText = "Create an Account")
    WebElement AccountLink;
    //login link
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement LoginLink;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    //Click Create Account Link
    public void clickAccountLink() {
        AccountLink.click();
    }

    public void clickLoginLink () {
        LoginLink.click();
    }
}


