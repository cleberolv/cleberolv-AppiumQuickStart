package application.test;

import org.junit.Before;
import org.junit.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SwipeListPage;
import junit.framework.Assert;

public class SwipeListTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	@Before
	public void menuSwipeList() {
		page.espera();
		menu.acessarMenuSwipeList();
	}
	
	@Test
	public void swipeListMais() {
		
		//Swipe opção 1 para direita
		page.swipeElementRight("Opção 1");
		
		//Clicar em "+" na opção 1
		page.clicarBotaoMais();
		
		//Verificar Opção 1 (+)
		Assert.assertTrue(menu.checkElementoTexto("Opção 1 (+)"));
	}
	
	@Test	
	public void swipeListMenos() {
		//Swipe opção 4 para direita
		page.swipeElementRight("Opção 4");
		
		//Clicar em "(-)"
		page.clicarPorTexto("(-)");
		
		//Verificar Opção 4 (-)
		Assert.assertTrue(menu.checkElementoTexto("Opção 4 (-)"));
	}
	
	@Test	
	public void swipeListRestart() {
		//Swipe opção 5 para esquerda
		page.swipeElementLeft("Opção 5 (-)");
		
		//Verificar Opção 1 (+)
		Assert.assertTrue(menu.checkElementoTexto("Opção 5"));
	}
}
