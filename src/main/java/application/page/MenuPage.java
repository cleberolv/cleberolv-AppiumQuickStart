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
	
	public void accessMenuTabs() {
		clicarPorTexto("Abas");
	}
	
	public void acessarMenuAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarMenuCliques() {
		clicarPorTexto("Cliques");
	}
	
	public void acessarMenuSwipe() {
		page.scrollDown();
		clicarPorTexto("Swipe");
	}
	
	public void acessarMenuSwipeList() {
		page.scrollDown();
		clicarPorTexto("Swipe List");
	}
	
	public void acessarMenuDragAndDrop() {
		page.scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
	public void acessarMenuSB() {
		clicarPorTexto("SeuBarriga Nativo");
	}
}
