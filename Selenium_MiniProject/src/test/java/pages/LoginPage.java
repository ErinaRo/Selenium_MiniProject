package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(linkText ="Sign In ")
    WebElement loginLink;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailLogin;

    @FindBy(xpath = "//*[@id=\"pass\"]")
    WebElement passwordLogin;

    @FindBy(xpath = "//*[@id=\"send2\"]")
    WebElement loginButton;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password ){
        emailLogin.sendKeys(email);
        passwordLogin.sendKeys(password);
        loginButton.click();
    }

}
