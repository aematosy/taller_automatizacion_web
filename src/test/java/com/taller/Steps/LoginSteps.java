package com.taller.Steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.taller.Pages.LoginPage;
import com.taller.Utils.Base;
import io.cucumber.datatable.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.taller.Utils.Excel;
import com.taller.Utils.Reader;
import com.taller.Utils.CucumberNewUtil;
import freemarker.core.ParseException;

import static org.testng.Assert.assertTrue;

public class LoginSteps extends Base {

	LoginPage login = new LoginPage(returnDriver());

	@When("I click on {string} button")
	public void iClickOnButton(String button) {
		LoginPage.clickSignOnButton();
	}

	@And("I log in with username {string} and password {string}")
	public void iLogInWithUsernameAndPassword(String username, String password) {
		LoginPage.login(username, password);
	}

	@Then("I should see the message {string}")
	public void iShouldSeeTheMessage(String message) {
		assertTrue(LoginPage.isLoginSuccessful());
	}


	

}
