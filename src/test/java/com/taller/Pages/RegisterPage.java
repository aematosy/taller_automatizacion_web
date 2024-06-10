package com.taller.Pages;

import com.taller.Constants.RegisterConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.taller.Utils.Utilities;
import org.testng.Assert;

public class RegisterPage {
	
	// constructor
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	static String fullName;

	public static void fillContactInformation(String firstname, String lastname, String phone, String email) {
		fullName = firstname + " " + lastname;
		Utilities.waitPresence(RegisterConstants.FIRSTNAME_INPUT);
		Utilities.sendText(RegisterConstants.FIRSTNAME_INPUT, firstname);
		Utilities.sendText(RegisterConstants.LASTNAME_INPUT, lastname);
		Utilities.sendText(RegisterConstants.PHONE_INPUT, phone);
		Utilities.sendText(RegisterConstants.EMAIL_INPUT, email);
	}

	public static void fillMailingInformation(String address, String city, String state, String postalCode, String country) {
		Utilities.waitElementToClick(RegisterConstants.ADDRESS_INPUT);
		Utilities.sendText(RegisterConstants.ADDRESS_INPUT, address);
		Utilities.sendText(RegisterConstants.CITY_INPUT, city);
		Utilities.sendText(RegisterConstants.STATE_INPUT, state);
		Utilities.sendText(RegisterConstants.POSTALCODE_INPUT, postalCode);
		Utilities.setDropdownByValue(RegisterConstants.COUNTRY_SELECT, country);
	}

	public static void fillUserInformation(String username, String password) {
		Utilities.waitPresence(RegisterConstants.USERNAME_INPUT);
		Utilities.sendText(RegisterConstants.USERNAME_INPUT, username);
		Utilities.sendText(RegisterConstants.PASSWORD_INPUT, password);
		Utilities.sendText(RegisterConstants.CONFIRM_PASSWORD_INPUT, password);
		Utilities.waitElementToClick(RegisterConstants.ENVIAR_BUTTON);
		Utilities.clickElement(RegisterConstants.ENVIAR_BUTTON);
	}

	public static void validateSuccessfulRegistration(){
		try {
			String expectedMessage = "Dear " + fullName + ",";
			String actualMessage = Utilities.getText(RegisterConstants.SUCCESS_MESSAGE);
			Assert.assertTrue(actualMessage.contains(expectedMessage),
					"El mensaje de registro exitoso no es el esperado.");
		} catch (Exception e) {
			Assert.fail("El mensaje de registro exitoso no es el esperado.");
		}
	}

}
