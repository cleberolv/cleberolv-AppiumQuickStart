package application.page;

import application.core.BasePage;

public class MenuPage extends BasePage {
	
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
	
}
