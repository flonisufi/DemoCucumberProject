package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class CalculationsPage {

    public CalculationsPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//td[text()='790']")
    private WebElement price1;

    @FindBy(xpath = "//td[text()='650']")
    private WebElement price2;

    @FindBy(id = "totalp")
    private WebElement totalP;

    public int priceOrProducts()
    {
        BrowserUtilities.waitForElementToAppear(price1);
        int sum = 0;
        return sum+= Integer.parseInt(price1.getText()) + Integer.parseInt(price2.getText());
    }

    public int totalPrice()
    {
        return Integer.parseInt(totalP.getText());
    }
}
