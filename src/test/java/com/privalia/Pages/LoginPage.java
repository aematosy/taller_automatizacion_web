package com.privalia.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.privalia.Utils.Utilities;

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

	// métodos para el login del usuario a Privalia
    public boolean loginLoad() {
        WebElement we = Utilities.waitElementToClick(opcEntrar);
        if (we != null) {
            return opcEntrar.isDisplayed();
        }
        return false;
    }
	
	public void GotoLogin(){
		Utilities.waitElementVisible(opcEntrar);
		Utilities.clickElement(opcEntrar);
	}

	public void setEmail(String email) {
		Utilities.waitElementVisible(txtemail);
		Utilities.sendText(txtemail, email);
	}

	public void setPassword(String password) {
		Utilities.waitElementVisible(txtpassword);
		Utilities.scrollPageTo(txtpassword);
		Utilities.sendText(txtpassword, password);
	}
	
	public void IniciarSesion() {
		Utilities.waitElementVisible(btnEntra);
		Utilities.clickOnElementJS(btnEntra);
	}
	
	public String nombreCategoria() {
		Utilities.waitElementToClick(nombreCategoria);
		String nombreCateg = nombreCategoria.getText();
		return nombreCateg;
	}

}
