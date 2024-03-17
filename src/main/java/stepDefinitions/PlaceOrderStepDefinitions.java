package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PlaceOrderPage;

public class PlaceOrderStepDefinitions {

    PlaceOrderPage placeOrderPage = new PlaceOrderPage();

    @When("User click on a Phone and Add to Cart")
    public void user_click_on_a_phone_and_add_to_cart()
    {
        placeOrderPage.orderPhone();

    }

    @When("User back Home and Click on A Laptop and Add to Cart")
    public void user_back_home_and_click_on_a_laptop_and_add_to_cart()
    {
        placeOrderPage.orderLaptop();

    }

    @When("User click on Cart and Place Order")
    public void user_click_on_cart_and_place_order()
    {
        placeOrderPage.placeOrder();

    }
    @When("User enter all personal informations and Purchase")
    public void user_give_all_personal_informations_and_purchase(io.cucumber.datatable.DataTable dataTable)
    {
        placeOrderPage.enterInformations(dataTable);

    }

    @Then("Validate that the order has been sent successfully")
    public void validate_that_the_order_has_been_sent_successfully()
    {
        Assert.assertEquals(placeOrderPage.orderText(),"Thank you for your purchase!");

    }
}
