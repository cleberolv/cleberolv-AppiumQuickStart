package application.test;

import org.junit.Assert;
import org.junit.Test;

import application.core.BaseTest;
import application.page.CliquesPage;
import application.page.MenuPage;

public class CliquesTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Test
	public void cliqueLongo() {
		//Acessar Menu
		menu.acessarMenuCliques();
		
		//Realizar clique longo
		page.cliqueLongo();
		
		//Verficar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
}
