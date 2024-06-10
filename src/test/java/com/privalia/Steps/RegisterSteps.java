package com.privalia.Steps;

import com.privalia.Pages.RegisterPage;
import com.privalia.Utils.Base;
import com.privalia.Utils.Utilities;

import io.cucumber.java.en.And;

public class RegisterSteps extends Base {

	RegisterPage orderPage = new RegisterPage(returnDriver());

	@And("hace clic en la opcion pedidos")
	public void hace_clic_pedidos() throws InterruptedException {
		orderPage.irOpcPedido();
		Thread.sleep(1000);
	}

	@And("hace clic en info del numero de pedido \"([^\"]*)\"$")
	public void ingresa_nro_pedido(String nro_pedido) {
		orderPage.verPedido(nro_pedido);
	}

	@And("hace clic en la opcion ver comprobante")
	public void ver_comprobante() {
		orderPage.opcVerComprobante();
		Utilities.capturarPantalla();
	}
	

}
