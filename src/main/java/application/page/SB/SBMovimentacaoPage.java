package application.page.SB;

import org.openqa.selenium.By;

import application.core.BasePage;

	public class SBMovimentacaoPage extends BasePage {
	
	public void setDescricao(String descricao) {
		escreverFormulario(By.className("android.widget.EditText"), descricao);
	}
	
	public void setInteressado(String interessado) {
		escreverFormulario(By.xpath("//*[@text='Interessado']"), interessado);
	}
	
	public void setValor(String valor) {
		escreverFormulario(By.xpath("//*[@text='Valor']"), valor);
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(By.xpath("//*[@text='Selecione uma conta...']"), valor);
	}
	
	public void btnSalvar() {
		clicarPorTexto("SALVAR");
	}
}
