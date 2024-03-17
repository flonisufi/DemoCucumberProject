package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class LoginPage {

    public LoginPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login2")
    private WebElement loginBtn;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(css = "button[onclick='logIn()']")
    private WebElement login;

    @FindBy(id = "nameofuser")
    private WebElement user;

    public void login()
    {
        loginBtn.click();
    }

    public void enterCredentials(String username,String password)
    {
        BrowserUtilities.waitForElementToAppear(usernameField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        login.click();
    }

    public WebElement nameOfUser()
    {
        BrowserUtilities.waitForElementToAppear(user);
        return user;
    }




}
