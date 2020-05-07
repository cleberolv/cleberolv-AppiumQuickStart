package application.page;

import application.core.DSL;

public class menuPage {

	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}
	
}
