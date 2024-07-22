package org.practice.dsa.cucumber_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.practice.dsa.cucumber_test.some_fake_services.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserStepDefinitions {
    private UserService userService;
    private String registrationMessage;
    private String loginMessage;

    public  UserStepDefinitions(){
        this.userService = new UserService();
    }
    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        // navigate to the browser
    }

    @When("I have registered with username {string} and password {string}")
    public void iHaveRegisteredWithUsernameAndPassword(String username, String password) {
        registrationMessage = userService.register(username, password);
    }

    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        assertEquals("Registration Successful", registrationMessage);
    }
}
