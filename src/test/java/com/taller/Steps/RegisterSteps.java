package com.taller.Steps;

import com.taller.Pages.RegisterPage;
import com.taller.Utils.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps extends Base {

	RegisterPage orderPage = new RegisterPage(returnDriver());

	@When("I fill in the Contact Information with firstname {string}, lastname {string}, phone {string}, and email {string}")
	public void i_fill_in_contact_information(String firstname, String lastname, String phone, String email) {
		RegisterPage.fillContactInformation(firstname,lastname, phone, email);
	}

	@When("I fill in the Mailing Information with address {string}, city {string}, state {string}, postal code {string}, and country {string}")
	public void i_fill_in_mailing_information(String address, String city, String state, String postalCode, String country) {
		RegisterPage.fillMailingInformation(address, city, state, postalCode, country);
	}

	@When("I fill in the User Information with username {string} and password {string}")
	public void i_fill_in_user_information(String username, String password) {
		RegisterPage.fillUserInformation(username, password);
	}

	@Then("I should be on the successful registration page")
	public void iShouldBeOnTheSuccessfulRegistrationPage() {
		RegisterPage.validateSuccessfulRegistration();
	}

}
