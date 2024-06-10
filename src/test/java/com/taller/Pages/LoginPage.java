package com.taller.Pages;

import com.taller.Constants.LoginConstants;
import com.taller.Constants.RegisterConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.taller.Utils.Utilities;
import com.taller.Utils.Base;

public class LoginPage extends Base{

	// constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void clickSignOnButton(){
		Utilities.waitElementToClick(RegisterConstants.SIGNIN_BUTTON);
		Utilities.clickElement(RegisterConstants.SIGNIN_BUTTON);
	}

	public static void login(String username, String password){
		Utilities.waitElementToClick(LoginConstants.USERNAME_INPUT);
		Utilities.sendText(LoginConstants.USERNAME_INPUT, username);
		Utilities.sendText(LoginConstants.PASSWORD_INPUT, password);
		Utilities.clickElement(LoginConstants.SUBMIT_BUTTON);
	}

	public static boolean isLoginSuccessful(){
		try {
			Utilities.waitPresence(LoginConstants.SUCCESS_MESSAGE);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
