package application.test;

import org.junit.Test;


import application.core.BaseTest;
import application.page.AlertPage;
import application.page.MenuPage;
import junit.framework.Assert;

public class ScroolTest extends BaseTest {	
	
	private MenuPage menu = new MenuPage();
	private AlertPage alert = new AlertPage();
	
	@Test
	public void scrool() {
		
		//Wait Formulário
		menu.waitMenu();
		
		menu.scrollDown();
		
		//clicar menu
		menu.clickByText("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", alert.getMessageAlert());
		
		//sair
		menu.clickByText("OK");
		
	}
}
