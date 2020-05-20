package application.test;

import org.junit.Before;
import org.junit.Test;

import application.core.baseTest;
import application.page.alertPage;
import application.page.menuPage;
import junit.framework.Assert;

public class alertTest extends baseTest {
	
	private menuPage menu = new menuPage();
	private alertPage page = new alertPage();
	
	@Before
	public void menu() {
		menu.acessarMenuAlert();
	}
	
	
	@Test
	public void testAlert() {
		
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
	
	@Test
	public void clicarForaAlert() {
		
		//Clicar no alerta simples
		page.clicarAlertSimples();
		
		//Clicar fora da caixa
		page.clicarForadaCaixa();
		
		//Validar que o alert desapareceu da tela
		Assert.assertFalse(page.checkElementoTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
