package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CategoriesOption;

public class CategoriesOptionStepDef {

    CategoriesOption categoriesOption = new CategoriesOption();

    @When("User click a Categories option on Dashboard")
    public void user_click_a_categories_option_on_dashboard()
    {
        categoriesOption.monitorOption();

    }

    @Then("Validate that Categories option work")
    public void validate_that_categories_option_work()
    {
        Assert.assertTrue(categoriesOption.appleMonitor().isDisplayed());
        System.out.println(categoriesOption.appleMonitor().getText());

    }
}
