package application.test;

import org.junit.Test;

import application.core.BaseTest;
import application.page.abasPage;
import application.page.menuPage;
import junit.framework.Assert;

public class Abas extends BaseTest {
	
	private menuPage menu = new menuPage();
	private abasPage page = new abasPage();
	
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
