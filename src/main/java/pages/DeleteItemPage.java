package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class DeleteItemPage {

    public DeleteItemPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "cartur")
    private WebElement cartPage;

    @FindBy(xpath = "//a[text()='Delete']")
    private WebElement delete;

    @FindBy(css = ".btn-success")
    private WebElement placeOrder;

    @FindBy(css = ".text-muted")
    private WebElement text;



    public void goToCart()
    {
        cartPage.click();
    }

    public void deleteItem() throws InterruptedException {
        BrowserUtilities.waitForElementToAppear(delete);
        delete.click();
        Thread.sleep(3000);
        placeOrder.click();
    }

    public String amountText()
    {
        BrowserUtilities.waitForElementToAppear(text);
        String textSplited = text.getText().split("Card")[0]
                .split("Id")[1].substring(9).trim();
        return textSplited;
    }






}
