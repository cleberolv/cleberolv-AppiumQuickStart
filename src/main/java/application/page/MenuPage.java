package application.page;

import application.core.BasePage;

public class MenuPage extends BasePage {
	
	BasePage page = new BasePage();
	
	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}
	
	public void acessarMenuSplash() {
		clicarPorTexto("Splash");
	}
	
	public void acessarMenuAlert() {
		clicarPorTexto("Alertas");
	}
	
	public void acessarMenuAbas() {
		clicarPorTexto("Abas");
	}
	
	public void acessarMenuAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarMenuCliques() {
		clicarPorTexto("Cliques");
	}
	
	public void acessarMenuSwipe() {
		page.scroll(0.9, 0.1);
		clicarPorTexto("Swipe");
	}
	
	public void acessarMenuSwipeList() {
		page.scroll(0.9, 0.1);
		clicarPorTexto("Swipe List");
	}
}
