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
	public void interativeSwipe() {
		//acessar menu
		page.waitMenu();
		menu.swipe();
		
		Assert.assertTrue(menu.checkTextElement("a esquerda"));
		
		menu.SwipeRight();
		Assert.assertTrue(menu.checkTextElement("E veja se"));
		
		page.clickByText("›");
		Assert.assertTrue(menu.checkTextElement("Chegar até o fim!"));
		
		menu.swipeLeft();
		
		page.clickByText("‹");
		Assert.assertTrue(menu.checkTextElement("a esquerda"));
	}
	
}
