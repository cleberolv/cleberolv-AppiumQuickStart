package application.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.core.BasePage;
import application.core.BaseTest;
import application.page.MenuPage;

public class SwipeTest extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();

	@Test
	public void interativeSwipe() {
		//acessar menu
		page.waitMenu();
		menu.swipe();
		
		assertTrue(menu.checkTextElement("a esquerda"));
		
		menu.SwipeRight();
		assertTrue(menu.checkTextElement("E veja se"));
		
		page.clickByText("›");
		assertTrue(menu.checkTextElement("Chegar até o fim!"));
		
		menu.swipeLeft();
		
		page.clickByText("‹");
		assertTrue(menu.checkTextElement("a esquerda"));
	}
	
}
