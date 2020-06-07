package application.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import application.core.BaseTest;
import application.page.ClicksPage;
import application.page.MenuPage;

public class ClicksTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private ClicksPage page = new ClicksPage();
	
	@Before
	public void menu() {
		menu.clicks();
	}
	
	@Test
	public void longClick() {
		page.longClick();
		assertEquals("Clique Longo", page.getTextField());
	}
	
	@Test
	public void doubleClick() {
		page.clickByText("Clique duplo");
		page.clickByText("Clique duplo");
		assertEquals("Duplo Clique", page.getTextField());
	}
	
}
