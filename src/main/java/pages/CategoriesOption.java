package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class CategoriesOption {

    public CategoriesOption()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a[onclick=\"byCat('monitor')\"]")
    private WebElement monitorOptionDashboard;

    @FindBy(xpath = "//a[text()='Apple monitor 24']")
    private WebElement appleMonitorProduct;

    public void monitorOption()
    {
        monitorOptionDashboard.click();
    }

    public WebElement appleMonitor()
    {
        BrowserUtilities.waitForElementToAppear(appleMonitorProduct);
        return appleMonitorProduct;
    }


}
