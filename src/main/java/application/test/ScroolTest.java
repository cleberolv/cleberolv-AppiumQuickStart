package application.test;

import org.junit.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import junit.framework.Assert;

public class ScroolTest extends BaseTest {	
	
	//Obs.: Todas as chamadas foram feitas atraves de outras pages
	private MenuPage menu = new MenuPage();
	
	@Test
	public void scrool() {
		
		//Wait Formulário
		menu.esperaMenu();
		
		menu.scrollDown();
		
		//clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPorTexto("OK");
		
	}
}
