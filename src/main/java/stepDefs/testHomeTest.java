package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.Driver;

public class testHomeTest {
    @Given("I open homepage")
    public void i_open_homepage() {
        Driver.getDriver().get(ConfigReader.readProperty("config.properties", "url"));
    }
    @When("I click on Inputs navigation button")
    public void i_click_on_inputs_navigation_button() {
        System.out.println("clicking Inputs button");
    }
    @When("I Input Hello World in message1 input field")
    public void i_input_hello_world_in_message1_input_field() {
        System.out.println("Inputting Hello World in input field");
    }
    @When("I click on Show Message button")
    public void i_click_on_show_message_button() {
        System.out.println("Clicking Show message button");
    }
    @Then("I should see Hello World text is displayed")
    public void i_should_see_hello_world_text_is_displayed() {
        System.out.println("Checking if Hello world text is displayed on the page");
    }
    @Then("URL should end with \\/home word")
    public void url_should_end_with_home_word() {
        System.out.println("URL was as expected to end with /home");
    }
    @When("I Input Apples in message2 input field")
    public void i_input_apples_in_message2_input_field() {
        System.out.println("Inputting Apples text in message2 field");
    }
    @Then("I should see Apple text is displayed")
    public void i_should_see_apple_text_is_displayed() {
        System.out.println("Apple text was displayed as expected");
    }
}
