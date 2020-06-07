package application.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import application.page.TabsPage;

public class TabsTestNG extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private TabsPage page = new TabsPage();
	
	@BeforeClass
	public void menu() {
		menu.tabs();
	}
	
	@Test(groups = {"Verify, Tabs"}, priority = 1, testName = "Check functionality - Tabs")
	public void Tabs() {
		AssertJUnit.assertEquals("Este é o conteúdo da Aba 1", page.checkTabOne());
		page.changeTab();
		AssertJUnit.assertEquals("Este é o conteúdo da Aba 2", page.checkTabTwo());
	}
}
