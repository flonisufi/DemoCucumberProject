package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalculationsPage;

public class CalculationsStepDefinitions {

    CalculationsPage calculationsPage = new CalculationsPage();

    int calcPrice;
    int totalPrice;

    @When("User grab the prices of Products")
    public void user_grab_the_prices_of_products()
    {
        calcPrice = calculationsPage.priceOrProducts();

    }
    @Then("User validate that Calculations of prices are the same as Total price")
    public void user_validate_that_calculations_of_prices_are_the_same_as_total_price()
    {
        totalPrice = calculationsPage.totalPrice();
        Assert.assertEquals(calcPrice,totalPrice);
        System.out.println("Calculation of prices is " + calcPrice
                + " and Total price is " + totalPrice);

    }
}
