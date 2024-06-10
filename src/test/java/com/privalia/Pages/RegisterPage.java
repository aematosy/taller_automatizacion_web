package com.privalia.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.privalia.Utils.Utilities;

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

	// métodos
	public void GotoPersonalInformation(){
		Utilities.waitElementVisible(opcDatosPersonales);
		opcDatosPersonales.click();
	}
	
	public void irOpcPedido(){
		Utilities.waitElementVisible(opcPedidos);
		Utilities.clickElement(opcPedidos);
	}
	
	public void verPedido(String nroPedido){
		WebElement elementPedidooSeleccionar = Utilities.createWebElement(
				"//td[contains(text(),'" + nroPedido + "')]//following-sibling::td[3]");
		Utilities.waitElementToClick(elementPedidooSeleccionar);
		Utilities.clickElement(elementPedidooSeleccionar);
	}
	
	public void opcVerComprobante(){
		Utilities.waitElementVisible(opcVerComprobante);
		Utilities.clickElement(opcVerComprobante);
	}
	
}
