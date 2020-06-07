package application.test;

import org.junit.Before;
import org.junit.Test;

import application.core.BasePage;
import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SBAccountPage;
import application.page.SBLoginPage;
import application.page.SBMenuPage;
import junit.framework.Assert;

public class SBTestAccount extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private BasePage page = new BasePage();
	
	private SBLoginPage login = new SBLoginPage();
	private SBAccountPage account = new SBAccountPage();
	private SBMenuPage menu = new SBMenuPage();
	
	@Before
	public void login() {
		menuPage.SB();
		login.setEmail("o@c");
		login.setSenha("a");
		login.btnEnter();
		menu.accountTab();
	}
	
	@Test
	public void createAccount() {
		account.setConta("Conta da Fernanda");
		account.btnSave();
		
		account.waitElement("Conta adicionada com sucesso");
		page.scrollDown();
		Assert.assertTrue(account.checkTextElement("Conta da Fernanda"));
	}
	
	@Test
	public void accountAlreadyExists() {		
		account.setConta("Conta mesmo nome");
		account.btnSave();
		Assert.assertTrue(account.checkTextElement("Problemas de comunicação"));
	}
	
	@Test
	public void deleteAccount() {
		account.waitElement("Conta para alterar");
		account.longClick("Conta para alterar");
		account.btnDelete();
		Assert.assertTrue(page.checkTextElement("Conta excluída com sucesso"));
	}
	
	@Test
	public void accountNotFound() {
		Assert.assertFalse(page.checkTextElement("Conta do Mark Manson"));
	}
	
}
