package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class PlaceOrderPage {

    Faker faker = new Faker();

    public PlaceOrderPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "img[src='imgs/Nexus_6.jpg']")
    private WebElement iphoneProd;

    @FindBy(css = "a[onclick='addToCart(3)']")
    private WebElement addToCart1;

    @FindBy(xpath = "//a[text()='Home ']")
    private WebElement backHome;

    @FindBy(css = "img[src='imgs/sony_vaio_5.jpg']")
    private WebElement laptopProd;

    @FindBy(css = "a[onclick='addToCart(8)']")
    private WebElement addToCart2;

    @FindBy(id = "cartur")
    private WebElement cartPage;

    @FindBy(css = ".btn-success")
    private WebElement placeOrder;

    @FindBy(css = "#name")
    private WebElement name;

    @FindBy(css = "#country")
    private WebElement country;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#card")
    private WebElement card;

    @FindBy(css = "#month")
    private WebElement month;

    @FindBy(css = "#year")
    private WebElement year;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    private WebElement purchase;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement confirmText;

    public void orderPhone()
    {
        BrowserUtilities.waitForElementToAppear(iphoneProd);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",iphoneProd);
        iphoneProd.click();
        BrowserUtilities.waitForElementToAppear(addToCart1);
        addToCart1.click();
        BrowserUtilities.alertHandle();
    }

    public void orderLaptop()
    {
        backHome.click();
        BrowserUtilities.waitForElementToAppear(laptopProd);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",laptopProd);
        laptopProd.click();
        BrowserUtilities.waitForElementToAppear(addToCart2);
        addToCart2.click();
        BrowserUtilities.alertHandle();
    }

    public void placeOrder()
    {
        BrowserUtilities.waitForElementToAppear(cartPage);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",cartPage);
        cartPage.click();
        BrowserUtilities.waitForElementToAppear(placeOrder);
        placeOrder.click();

    }

    public void enterInformations(io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String,String>>data = dataTable.asMaps(String.class, String.class);

        for (Map<String,String>row : data)
        {
            String elementName = row.get("Element");
            String information = row.get("Information");

            switch (elementName)
            {
                case "Name":
                    BrowserUtilities.waitForElementToAppear(name);
                    name.sendKeys(faker.name().fullName());
                    break;
                case "Country":
                    country.sendKeys(faker.address().state());
                    break;
                case "City":
                    city.sendKeys(faker.address().city());
                    break;
                case "Credit Cart":
                    card.sendKeys(information);
                    break;
                case "Month":
                    month.sendKeys(information);
                    break;
                case "Year":
                    year.sendKeys(information);
                    break;
            }
        }
        purchase.click();
    }

    public String orderText()
    {
        BrowserUtilities.waitForElementToAppear(confirmText);
        String text =  confirmText.getText();
        return text;
    }


}
