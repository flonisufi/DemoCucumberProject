package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DeleteItemPage;

public class DeleteItemStepDef {

    DeleteItemPage deleteItemPage = new DeleteItemPage();

    @When("User click on Cart")
    public void user_click_on_cart()
    {
        deleteItemPage.goToCart();

    }

    @When("User delete the item from Cart and Place Order")
    public void user_delete_the_item_from_cart() throws InterruptedException
    {
        deleteItemPage.deleteItem();
    }

    @Then("Validate that item is deleted")
    public void validate_that_item_is_deleted()
    {
        Assert.assertEquals(deleteItemPage.amountText(),"Amount: 0 USD");

    }


}
