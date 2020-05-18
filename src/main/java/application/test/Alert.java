package application.test;

import org.junit.Test;

import application.core.BaseTest;
import application.page.alertPage;
import application.page.menuPage;
import junit.framework.Assert;

public class Alert extends BaseTest {
	
	private menuPage menu = new menuPage();
	private alertPage page = new alertPage();
	
	@Test
	public void testAlert() {
		//Acessar Menu Alert
		menu.acessarMenuAlert();
		
		//clicar no botão alert confirm
		page.btnAlertConfirm();
		
		//Validar PopUp Alert
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		//clicar no botão confirmar
		page.confirmar();
		
		//verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		//sair
		page.sair();
	}

}
