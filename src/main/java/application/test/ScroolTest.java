package application.test;

import static application.core.DriverFactory.getDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.BaseTest;
import application.page.MenuPage;
import junit.framework.Assert;

public class ScroolTest extends BaseTest {
	
	@Before
	public void espera() {
		//Aguarda até a visibilidade do elemento fomulário 
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Elemento encontrado, iniciando teste...");
	}
	
	//Obs.: Todas as chamadas foram feitas atraves de outras pages
	private MenuPage menu = new MenuPage();
	
	@Test
	public void swipeDown() {
		
		//scroll down de 90% a 10% da tela
		menu.scroll(0.9, 0.1);
		
		//clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPorTexto("OK");
		
	}
}
