package application.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SBLoginPage;
import application.page.SBResetPage;

public class SBResetTest extends BaseTest {

	private SBResetPage reset = new SBResetPage();
	private SBLoginPage login = new SBLoginPage();
	private MenuPage page = new MenuPage();

	@Before
	public void login() {
		page.SB();
		login.setEmail("o@c");
		login.setSenha("a");
		login.btnEnter();
	}
	
	@Test
	public void restartData() {
		reset.resetData();
		assertTrue(page.checkTextElement("Dados resetados com sucesso!"));
	}

}