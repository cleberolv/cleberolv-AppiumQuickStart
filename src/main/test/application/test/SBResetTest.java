package application.test;

import org.junit.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SBResetPage;
import junit.framework.Assert;

public class SBResetTest extends BaseTest {

	private SBResetPage reset = new SBResetPage();
	private SBTest test = new SBTest();
	private MenuPage page = new MenuPage();

	@Test
	public void restaurarMassa() {
		test.login();
		reset.resetMassa();
		Assert.assertTrue(page.checkElementoTexto("Dados resetados com sucesso!"));
	}

}