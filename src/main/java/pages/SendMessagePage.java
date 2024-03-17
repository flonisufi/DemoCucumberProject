package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SendMessagePage {

    Faker faker = new Faker();

    public SendMessagePage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a[data-target='#exampleModal']")
    private WebElement contactBtn;

    @FindBy(id = "recipient-email")
    private WebElement emailField;

    @FindBy(css = "#recipient-name")
    private WebElement nameField;

    @FindBy(css = "#message-text")
    private WebElement messageField;

    @FindBy(xpath = "//button[@onclick='send()']")
    private WebElement sendMsgBtn;

    public void goToContact()
    {
        contactBtn.click();
    }

    public void enterInformations(String email,String name)
    {
        BrowserUtilities.waitForElementToAppear(emailField);
        emailField.sendKeys(email);
        nameField.sendKeys(name);
    }

    public void sentMessage(String message)
    {
        messageField.sendKeys(message);
        sendMsgBtn.click();
    }

}
