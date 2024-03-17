package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class VerifyPricePage {

    public VerifyPricePage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h5[text()='$360']")
    private WebElement priceOut;

    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    private WebElement samsung;

    @FindBy(css = ".price-container")
    private WebElement priceIn;

    public int priceDashboard()
    {
        BrowserUtilities.waitForElementToAppear(priceOut);
        int sum = 0;
        String formatedPrice = priceOut.getText().split("\\$")[1].trim();
        return sum += Integer.parseInt(formatedPrice);
    }

    public void goInsideProduct()
    {
        samsung.click();
    }

    public int priceInside()
    {
        BrowserUtilities.waitForElementToAppear(priceIn);
        int sum = 0;
        String formatedPrice = priceIn.getText().split("\\$")[1].split("\\*")[0].trim();
        return sum += Integer.parseInt(formatedPrice);
    }
}
