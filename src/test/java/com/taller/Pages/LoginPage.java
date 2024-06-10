package com.taller.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.taller.Utils.Utilities;

public class LoginPage{

	@FindBy(id = "tab3")
	public WebElement linkmarcas;

	@FindBy(id = "btn-login-form")
	public WebElement btnEntra;
		
	@FindBy(xpath = "(//a[@id='authLogin'])[1]")
	public WebElement opcEntrar;

	@FindBy(id = "member_login_email")
	public WebElement txtemail;	
	
	@FindBy(id = "input_member_password")
	public WebElement txtpassword;

	@FindBy(xpath = "//a[@id='classification-111']")
	public WebElement nombreCategoria;
	

	// constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



}
