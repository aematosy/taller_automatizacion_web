package com.taller.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.taller.Utils.Utilities;

public class RegisterPage {
	
	@FindBy(xpath = "//a[contains(text(),'Datos personales')]")
	public WebElement opcDatosPersonales;
	
	@FindBy(xpath = "//a[contains(text(),'Pedidos')]")
	public WebElement opcPedidos;
	
	@FindBy(xpath = "//a[contains(text(),'Ver comprobante')]")
	public WebElement opcVerComprobante;
	
	// constructor
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}
