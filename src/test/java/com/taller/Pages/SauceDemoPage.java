package com.taller.Pages;

import com.taller.Constants.RegisterConstants;
import com.taller.Constants.SauceDemoConstants;
import com.taller.Utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SauceDemoPage{

	// Constructor
	public SauceDemoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Métodos
	public void validateHomePageSauceDemo() {
		Utilities.waitForElement(SauceDemoConstants.USERNAME_INPUT);
	}

	public static void fillLoginInputs(String username, String password){
		Utilities.sendText(SauceDemoConstants.USERNAME_INPUT, username);
		Utilities.sendText(SauceDemoConstants.PASSWORD_INPUT, password);
	}

	public static void clickLoginButton(){
		Utilities.waitElementToClick(SauceDemoConstants.LOGIN_BUTTON);
		Utilities.clickElement(SauceDemoConstants.LOGIN_BUTTON);
	}

	public static void validateErrorMessage(String expectedMessage){
		try {
			String actualMessage = Utilities.getText(SauceDemoConstants.ERROR_MESSAGE);
			System.out.println("MENSAJEEEEEEEEEEEEEEEEEEEEEEEEEEE "+actualMessage);
			Assert.assertTrue(actualMessage.contains(expectedMessage),
					"El mensaje de error no es el esperado.");
		} catch (Exception e) {
			Assert.fail("El mensaje de error no es el esperado.");
		}
	}

}
