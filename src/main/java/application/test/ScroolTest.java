package application.test;

import org.junit.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import junit.framework.Assert;

public class ScroolTest extends BaseTest {	
	
	//Obs.: Todas as chamadas foram feitas atraves de outras pages
	private MenuPage menu = new MenuPage();
	
	@Test
	public void swipeDown() {
		
		//Wait Formulário
		menu.espera();
		
		//scroll down de 90% a 10% da tela
		menu.scroll(0.9, 0.1);
		
		//clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPorTexto("OK");
		
	}
}
