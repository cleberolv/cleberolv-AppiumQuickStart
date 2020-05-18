package application.page;

import application.core.BasePage;

public class abasPage extends BasePage {

	public boolean validarAba1() {
		return checkElementoTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean validarAba2() {
		return checkElementoTexto("Este é o conteúdo da Aba 2");
	}
	
	public void mudarAba() {
		clicarPorTexto("ABA 2");
	}
	
}
