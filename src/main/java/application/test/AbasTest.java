package application.test;

import org.junit.Test;

import application.core.BaseTest;
import application.page.AbasPage;
import application.page.MenuPage;
import junit.framework.Assert;

public class AbasTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	@Test
	public void testAbas() {
		//Acessar menu Abas
		menu.acessarMenuAbas();
		
		//Verificar que está na Aba 1
		Assert.assertEquals("Este é o conteúdo da Aba 1", page.verificarAba1());
		
		//Ir até a aba 2
		page.mudarAba();
		
		//Verificar que está na Aba 2
		Assert.assertEquals("Este é o conteúdo da Aba 2", page.verificarAba2());
	}

}
