package application.test;

import org.junit.Test;

import application.core.BaseTest;
import application.page.AccordionPage;
import application.page.MenuPage;
import junit.framework.Assert;

public class AccordionTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void interagirComAccordion() {
		
		//Acessar menu
		menu.acessarMenuAccordion();
		
		//Clicar na opção 1
		page.AcessarAcordeon();
		
		//Validar texto da opção 1 #Bug2
		Assert.assertEquals("Esta é a descrição da opção 1", page.validarAcordeon());
	}

}
