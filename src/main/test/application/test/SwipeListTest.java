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
		page.waitMenu();
		menu.swipeList();
	}
	
	@Test
	public void interativeSwipeList1() {
		page.swipeElementRight("Opção 1");
		page.BtnMoreOptions();
		Assert.assertTrue(menu.checkTextElement("Opção 1 (+)"));
	}
	
	@Test	
	public void interativeSwipeList4() {
		page.swipeElementRight("Opção 4");
		page.clickByText("(-)");
		Assert.assertTrue(menu.checkTextElement("Opção 4 (-)"));
	}
	
	@Test	
	public void swipeListRestart() {
		page.swipeElementLeft("Opção 5 (-)");
		Assert.assertTrue(menu.checkTextElement("Opção 5"));
	}
}
