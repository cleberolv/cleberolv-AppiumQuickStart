package application.test;

import org.junit.Before;
import org.junit.Test;

import application.core.BasePage;
import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SBHomePage;
import application.page.SBLoginPage;
import application.page.SBMenuPage;
import application.page.SBTransactionsPage;
import application.page.SBResumoPage;
import junit.framework.Assert;

public class SBTestTransactions extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private BasePage page = new BasePage();
	
	private SBLoginPage login = new SBLoginPage();
	private SBTransactionsPage transaction = new SBTransactionsPage();
	private SBMenuPage menu = new SBMenuPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resume = new SBResumoPage();
	
	@Before
	public void login() {
		menuPage.SB();
		login.setEmail("o@c");
		login.setSenha("a");
		login.btnEnter();
	}
	
	@Test
	public void testFailFields() {
		menu.transactionsTab();
		
		transaction.btnSave();
		Assert.assertTrue(page.checkTextElement("Descrição é um campo obrigatório"));
		transaction.setDescription("Descrição");
		
		transaction.btnSave();
		
		Assert.assertTrue(page.checkTextElement("Interessado é um campo obrigatório"));
		transaction.setStakeholder("Interessado");
		transaction.btnSave();
		
		Assert.assertTrue(page.checkTextElement("Valor é um campo obrigatório"));
		transaction.setValue("11");
		transaction.btnSave();
		
		Assert.assertTrue(page.checkTextElement("Conta é um campo obrigatório"));
	}
	
	@Test
	public void registerTransaction() {
		menu.transactionsTab();
		
		transaction.setDescription("Descrição");
		transaction.setStakeholder("Interessado");
		transaction.setValue("11");
		transaction.selectComboBox("Conta para movimentacoes");
		
		transaction.btnSave();
		Assert.assertTrue(page.checkTextElement("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void deleteTransaction() {
		
		Assert.assertEquals("534.00", home.getBalance("Conta para saldo"));
		
		menu.resumeTab();
	
		resume.waitForText("Movimentacao 3, calculo saldo");
		resume.swipeElementRight("Movimentacao 3, calculo saldo");
		
		resume.clickBtnDelete();
		
		resume.waitForText("Movimentação removida com sucesso!");
		
		menu.homeTab();
		
		await(1000);
		page.scroll(0.2, 0.9);
		Assert.assertEquals("-1000.00", home.getBalance("Conta para saldo"));
	}
	
}
