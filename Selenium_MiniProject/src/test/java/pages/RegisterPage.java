package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.openqa.selenium.support.PageFactory.*;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id = "firstname")
    WebElement FirstName;

    @FindBy(id = "lastname")
    WebElement LastName;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(id = "password-confirmation")
    WebElement ConfirmPassword;

    @FindBy(xpath = "//*[@id=\"email_address\"]")
    WebElement Email;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement SubmitButton;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }


    public void addFirstName(String firstname) {
        FirstName.sendKeys(firstname);
    }

    public void addLastName(String lastname) {
        LastName.sendKeys(lastname);
    }

    public void addEmail(String email) {
        Email.sendKeys(email);
    }

    public void addPassword(String password) {
        Password.sendKeys(password);
    }

    public void addConfirmPassword(String confirmpassword) {
        ConfirmPassword.sendKeys(confirmpassword);
    }

    public void clickSubmitButton() {
        SubmitButton.click();
    }

    // functions

    public void createNewAccount(String firstname, String lastname, String email,String confirmpassword, String password)
    {
        addFirstName(firstname);
        addLastName(lastname);
        addEmail(email);
        addPassword(password);
        addConfirmPassword(confirmpassword);
        clickSubmitButton();

    }
}


