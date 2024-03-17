package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.VerifyPricePage;

public class VerifyPriceStepDefinitions {

    VerifyPricePage verifyPricePage = new VerifyPricePage();

    int priceOut;
    int priceIn;


    @When("User grab the price of a Product on Dashboard")
    public void user_grab_the_price_of_a_product_on_dashboard()
    {
        priceOut = verifyPricePage.priceDashboard();

    }
    @When("User click on that Product")
    public void user_click_on_that_product()
    {
        verifyPricePage.goInsideProduct();

    }
    @Then("User validate that the price is same on Dashboard and inside the product")
    public void user_validate_that_the_price_is_same_on_dashboard_and_inside_the_product()
    {
        priceIn = verifyPricePage.priceInside();
        Assert.assertEquals(priceOut,priceIn);
        System.out.println("Price on Dashboard is " + priceOut +
                " and price inside Produtc is " + priceIn);

    }
}
