package application.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import application.core.BaseTest;
import application.page.CliquesPage;
import application.page.MenuPage;

public class CliquesTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Before
	public void menu() {
		menu.acessarMenuCliques();
	}
	
	@Test
	public void cliqueLongo() {
		//Realizar clique longo
		page.cliqueLongo();
		
		//Verficar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void cliqueDuplo() {
		//Realizar clique longo
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		//Verficar texto
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}
	
	
	
}
