package application.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.core.BaseTest;
import application.page.AccordionPage;
import application.page.MenuPage;

public class AccordionTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void interactAccordion() {
		menu.accordion();
		page.acessAccordion();
		await(1000);
		assertEquals("Esta é a descrição da opção 1", page.validateAccordion()); 
	}

}
