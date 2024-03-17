package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @When("User click on Log in")
    public void user_click_on_log_in()
    {
        loginPage.login();

    }

    @When("User enter Username {string} and password {string} and Log in")
    public void user_enter_username_and_password_and_log_in(String username, String password)
    {
        if (username.equalsIgnoreCase("valid"))
        {
            username = "flonisufii";
            password = "Pakokosare1";
        }
        loginPage.enterCredentials(username,password);


    }

    @Then("User validate that Account is opened")
    public void user_validate_that_account_is_opened()
    {
        Assert.assertTrue(loginPage.nameOfUser().isDisplayed());
        System.out.println(loginPage.nameOfUser().getText());
    }
}
