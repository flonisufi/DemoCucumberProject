package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SendMessagePage;
import utilities.BrowserUtilities;

public class SendMessageStepDefinitions {


    Faker faker = new Faker();

    SendMessagePage sendMessagePage = new SendMessagePage();


    @When("User click on Contact")
    public void user_click_on_contact()
    {
        sendMessagePage.goToContact();

    }

    @When("User enter email {string} and name {string}")
    public void user_enter_email_and_name(String email, String name)
    {
        if (email.equalsIgnoreCase("valid"))
        {
            email = faker.internet().emailAddress();
            name = faker.name().fullName();
        }
        sendMessagePage.enterInformations(email,name);

    }

    @When("User send a message {string} and Submit the message")
    public void user_send_a_message_and_submit_the_message(String message)
    {
        if (message.equalsIgnoreCase("message"))
        {
            message = faker.chuckNorris().fact();
        }
        sendMessagePage.sentMessage(message);
        System.out.println(message);

    }

    @Then("User validate the message has been sent")
    public void user_validate_the_message_has_been_sent()
    {
        Assert.assertEquals(BrowserUtilities.alertHandle(),"Thanks for the message!!");

    }


}
