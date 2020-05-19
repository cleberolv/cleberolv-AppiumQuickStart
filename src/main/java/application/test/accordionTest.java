package application.test;

import org.junit.Test;

import application.core.baseTest;
import application.page.accordionPage;
import application.page.menuPage;
import junit.framework.Assert;

public class accordionTest extends baseTest {
	
	menuPage menu = new menuPage();
	accordionPage page = new accordionPage();
	
	@Test
	public void interagirComAccordion() {
		
		//Acessar menu
		menu.acessarMenuAccordion();
		
		//Clicar na opção 1
		page.AcessarAcordeon();
		
		//Validar texto da opção 1
		
		Assert.assertEquals("Esta é a descrição da opção 1", page.validarAcordeon());
	}

}
