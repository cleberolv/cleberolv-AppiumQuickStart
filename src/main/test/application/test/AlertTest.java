package application.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import application.core.BaseTest;
import application.page.AlertPage;
import application.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertPage page = new AlertPage();
	
	@Before
	public void menu() {
		menu.alert();
	}
	
	@Test
	public void testAlert() {
		
		page.btnAlertConfirm();
		assertEquals("Info", page.getTitleAlert());
		assertEquals("Confirma a operação?", page.getMessageAlert());
		
		page.confirm();
		
		await(1000);
		assertEquals("Confirmado", page.getMessageAlert());
		page.exit();
	}
	
	@Test
	public void clickAwayAlert() {
		page.clickSimpleAlert();
		page.clickOK();
		assertFalse(page.checkTextElement("Pode clicar no OK ou fora da caixa para sair"));
	}

}
