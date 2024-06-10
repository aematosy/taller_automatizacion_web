package com.privalia.Steps;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.privalia.Pages.LoginPage;
import com.privalia.Utils.Base;
import io.cucumber.datatable.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.privalia.Utils.Excel;
import com.privalia.Utils.Reader;
import com.privalia.Utils.CucumberNewUtil;
import freemarker.core.ParseException;
 
public class LoginSteps extends Base {
	Excel reader;
	private WebDriver driver;
	private Properties prop;
	private Base driverBase;
	LoginPage login = new LoginPage(returnDriver());
	

	@Given("el usuario se encuentra en la pagina de inicio de sesion de Privalia")
	public void el_usuario_esta_en_la_pagina_de_inicio_de_sesion_de_privalia() throws InterruptedException {
		login.loginLoad();
		login.GotoLogin();
	}

	@When("ingresa su correo electronico \"([^\"]*)\" y su contrasena \"([^\"]*)\"$")
	public void ingresa_su_correo_electronico_y_su_contraseña(String email, String password) throws Exception {
		login.setEmail(email);
		login.setPassword(password);
	}
	
	@When("ingresa su correo electronico y su contrasena$")
	public void ingresa_su_correo_y_password(DataTable usercredentials)  throws Throwable {
		List<List<String>> testData = usercredentials.cells();
		String email= testData.get(1).get(0);
		String password= testData.get(1).get(1);
		login.setEmail(email);
		login.setPassword(password);
	}

	@When("hace clic en el boton Entra")
	public void hace_clic_en_el_boton_entra() throws InterruptedException {
		login.IniciarSesion();
	}

	@Then("debe ser redirigido a la pagina de inicio de Privalia")
	public void debe_ser_redirigido_a_la_página_de_inicio_de_privalia() {
		String textoEsperado = "Invita y gana";
		WebElement linkInvitaYgana = new WebDriverWait(returnDriver(), Duration.ofSeconds(TIME_OUT)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[contains(text(),'Invita y gana')])[1]")));
		String textoObtenido = linkInvitaYgana.getText();
		Assert.assertEquals(textoObtenido, textoEsperado,
				"El texto de la opcion de Invita y Gana no coincide con el valor esperado");
	}
	
	@Then("se valida mensaje de error por credenciales incorrectas \"([^\"]*)\"$")
	public void se_valida_mensaje_error(String mensaje_error) throws InterruptedException {
		String textoEsperado = mensaje_error;
		WebElement mensajeError = new WebDriverWait(returnDriver(), Duration.ofSeconds(TIME_OUT)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Tu email o contraseña no son correctos')]")));
		String textoObtenido = mensajeError.getText();
		Assert.assertEquals(textoObtenido, textoEsperado,
				"El texto del mensaje de error no coincide con el valor esperado");

	}
	
	@Given("Yo accedo a Privalia y obtengo datos desde un excel")
	public void yo_accedo_a_privalia_y_obtengo_datos_desde_un_excel(DataTable table)
			throws InterruptedException, IOException, ParseException {

		String projectPath = System.getProperty("user.dir");
		String rutaExcel = projectPath + "/src/test/resources/files/";
		CucumberNewUtil.ConvertDataTableToDict(table);
		String archivoExcel = rutaExcel + CucumberNewUtil.GetCellValueWithRowIndex("archivo", 1);
		String hojaExcel = CucumberNewUtil.GetCellValueWithRowIndex("hoja", 1);

		// Leer Excel
		try {
			reader = new Excel(archivoExcel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		for (int rowNum = 2; rowNum <= reader.getRowCount(hojaExcel); rowNum++) {	
			String valorDriver = "" + returnDriver();
			
			if(valorDriver.contains("null")) {
				prop = Reader.getAllProperties();
				driverBase = new Base();
				driver = driverBase.loadDriver(prop.getProperty("browser"));
		        driver.get(prop.getProperty("url"));
		        LoginPage login = new LoginPage(returnDriver());
				login.GotoLogin();
				String email = reader.getCellData(hojaExcel, "email", rowNum);
				String password = reader.getCellData(hojaExcel, "password", rowNum);				
				login.setEmail(email);
				login.setPassword(password);
				
				//Escribir resultado y valores en Excel
				String nombreCateg = login.nombreCategoria();
				reader.setCellData(hojaExcel, "Nombre_Categoria", rowNum, nombreCateg);

			}else {
				login.GotoLogin();
				String email = reader.getCellData(hojaExcel, "email", rowNum);
				String password = reader.getCellData(hojaExcel, "password", rowNum);				
				login.setEmail(email);
				login.setPassword(password);
				
				//Escribir resultado y valores en Excel
				String nombreCateg = login.nombreCategoria();
				reader.setCellData(hojaExcel, "Nombre_Categoria", rowNum, nombreCateg);
			}		
			returnDriver().quit();	
			}
	}
	

}
