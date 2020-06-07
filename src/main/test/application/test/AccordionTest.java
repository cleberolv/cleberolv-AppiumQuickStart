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
	public void interactAccordion() {
		menu.accordion();
		page.acessAccordion();
		await(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.validateAccordion()); 
	}

}
