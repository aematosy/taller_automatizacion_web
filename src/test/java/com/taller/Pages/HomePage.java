package com.taller.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.taller.Utils.Utilities;
import com.taller.Utils.Base;
import com.taller.Constants.HomeConstants;

public class HomePage extends Base{
	private final Logger logger = LogManager.getLogger(HomePage.class.getName());

	// Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Métodos
	public void validateHomePage() {
		Utilities.waitElementToClick(HomeConstants.REGISTER_OPTION);
	}

	public void clickRegisterOption() {
		Utilities.clickElement(HomeConstants.REGISTER_OPTION);
	}
}
