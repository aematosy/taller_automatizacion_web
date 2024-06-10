package com.privalia.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.privalia.Utils.Utilities;
import com.privalia.Utils.Base;

public class HomePage extends Base{
	private final Logger logger = LogManager.getLogger(HomePage.class.getName());

	@FindBy(xpath = "//a[@href='register.php']")
	public static WebElement register_option;

	// Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Métodos
	public void navegarWeb() {
		Utilities.waitElementToClick(register_option);
	}

	public void clickRegisterOption() {
		Utilities.waitElementToClick(register_option);
		Utilities.clickElement(register_option);
	}
}
