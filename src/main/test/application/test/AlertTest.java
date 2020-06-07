package application.test;

import org.junit.Before;
import org.junit.Test;

import application.core.BaseTest;
import application.page.AlertPage;
import application.page.MenuPage;
import junit.framework.Assert;

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
		Assert.assertEquals("Info", page.getTitleAlert());
		Assert.assertEquals("Confirma a operação?", page.getMessageAlert());
		
		page.confirm();
		
		await(1000);
		Assert.assertEquals("Confirmado", page.getMessageAlert());
		page.exit();
	}
	
	@Test
	public void clickAwayAlert() {
		page.clickSimpleAlert();
		page.clickOK();
		Assert.assertFalse(page.checkTextElement("Pode clicar no OK ou fora da caixa para sair"));
	}

}
