package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SignUpPage {

    public SignUpPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin2")
    private WebElement signUpBtn;

    @FindBy(css = "#sign-username")
    private WebElement usernameField;

    @FindBy(css = "#sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='register()']")
    private WebElement signUp;



    public void signUp()
    {
        signUpBtn.click();
    }

    public void enterCredentials(String username,String password)
    {
        BrowserUtilities.waitForElementToAppear(usernameField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signUp.click();

    }


}
