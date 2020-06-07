package application.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

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
		Assert.assertEquals("Clique Longo", page.getTextField());
	}
	
	@Test
	public void doubleClick() {
		page.clickByText("Clique duplo");
		page.clickByText("Clique duplo");
		Assert.assertEquals("Duplo Clique", page.getTextField());
	}
	
}
