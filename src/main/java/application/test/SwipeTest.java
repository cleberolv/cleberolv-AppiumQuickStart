package application.test;

import org.junit.Test;

import application.core.BasePage;
import application.core.BaseTest;
import application.page.MenuPage;
import junit.framework.Assert;

public class SwipeTest extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();

	@Test
	public void swipe() {
		//acessar menu
		page.espera();
		menu.acessarMenuSwipe();
		
		//verficar texto "A esqueda..."
		Assert.assertTrue(menu.checkElementoTexto("a esquerda"));
		
		//swipe para a direita
		menu.swipe(0.9, 0.1);
		
		//verficar texto "E veja se..."
		Assert.assertTrue(menu.checkElementoTexto("E veja se"));
		
		//clicar botão direita
		page.clicarPorTexto("›");
		
		//verficar texto "Chegar até o fim"
		Assert.assertTrue(menu.checkElementoTexto("Chegar até o fim!"));
		
		//swipe para a esquerda
		menu.swipe(0.1, 0.9);
		
		//clicar botão esquerdo
		page.clicarPorTexto("‹");
		
		//verficar texto "A esqueda..."
		Assert.assertTrue(menu.checkElementoTexto("a esquerda"));
	}
	
}
