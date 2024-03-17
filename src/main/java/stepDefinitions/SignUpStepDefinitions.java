package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SignUpPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SignUpStepDefinitions {

    SignUpPage signUpPage = new SignUpPage();

    Faker faker = new Faker();

    @Given("When user is on the Demo Blaze Page")
    public void when_user_is_on_the_demo_blaze_page()
    {

    }

    @When("User click on Sign Up")
    public void user_click_on_sign_up()
    {
        signUpPage.signUp();

    }

    @When("User enter Username {string} and password {string} and SignUp")
    public void user_enter_username_and_password_and_signup(String username, String password)
    {
        if (username.equalsIgnoreCase("valid"))
        {
            username = faker.name().username();
            password = faker.name().lastName();
        }
        signUpPage.enterCredentials(username,password);
    }

    @Then("User validate that Account is created successfully")
    public void user_validate_that_account_is_created_successfully()
    {

        Assert.assertEquals(BrowserUtilities.alertHandle(),"Sign up successful.");

    }


}
