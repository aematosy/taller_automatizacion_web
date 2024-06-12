package com.taller.Pages;

import com.taller.Constants.InventorySDConstants;
import com.taller.Utils.Base;
import com.taller.Utils.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InventorySDPage extends Base{
	private final Logger logger = LogManager.getLogger(InventorySDPage.class.getName());

	// Constructor
	public InventorySDPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Métodos
	public static void validateInventoryPage() {
		Utilities.waitPresence(InventorySDConstants.INVENTORY_LABEL);
	}
}
