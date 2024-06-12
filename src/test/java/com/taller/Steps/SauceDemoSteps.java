package com.taller.Steps;

import com.taller.Pages.SauceDemoPage;
import com.taller.Utils.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.taller.Pages.InventorySDPage;

public class SauceDemoSteps  extends Base {

    SauceDemoPage homeSaucedemo = new SauceDemoPage(returnDriver());

    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_SauceDemo_login_page() {
        homeSaucedemo.validateHomePageSauceDemo();
    }

    @When("the user enters the username {string} and the password {string}")
    public void the_user_enters_the_username_and_the_password(String username, String password) {
        SauceDemoPage.fillLoginInputs(username,password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        SauceDemoPage.clickLoginButton();
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected_to_the_inventory_page() {
        InventorySDPage.validateInventoryPage();
    }

    @Then("the inventory page should be displayed")
    public void the_inventory_page_should_be_displayed() {

    }

    @Then("an error message should be displayed saying {string}")
    public void an_error_message_should_be_displayed_saying(String errorMessage) {
        SauceDemoPage.validateErrorMessage(errorMessage);
    }
}
