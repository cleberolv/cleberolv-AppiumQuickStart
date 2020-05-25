package application.page.SB;

import application.core.BasePage;

public class SBMenuPage extends BasePage {
	
	//Acessar aba Contas
	public void abaContas(){
		clicarPorTexto("CONTAS");
	}
	
	//Acessar aba Movimentações
	public void abaMovimentacoes() {
		clicarPorTexto("MOV...");
	}
	
	//Acessar aba Resumo
	public void abaResumo() {
		clicarPorTexto("RESUMO");
	}
	
	//Acessar aba Home
	public void abaHome() {
		clicarPorTexto("HOME");
	}

}
