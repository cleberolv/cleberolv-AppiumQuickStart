package application.page;

import org.openqa.selenium.By;

import application.core.DSL;
import io.appium.java_client.MobileBy;

public class formularioPage {
	
	private DSL dsl = new DSL();
	
	//Escreve nome no formulário
	public void escreverNome(String nome){
		dsl.escreverFormulario(MobileBy.AccessibilityId("nome"), nome);
	}
	
	//Checa nome escrito no formulario
	public String checarNome() {
		return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	//Seleciona um valor no combo box
	public void selecionarCombo(String valor) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	//Checa um valor selecionado no combo box
	public String checarCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	//Clica em um elemento check
	public void clicarCheck() {
		dsl.clicar(By.className("android.widget.CheckBox"));
	}
	
	//Clica em um elemeto switch
	public void clicarSwitch() {
		dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	//Verfica se o elemento check está marcado
	public boolean isCheckMarcado() {
		return dsl.isCheked(By.className("android.widget.CheckBox"));
	}
	
	//Verfica se o elemento switch está marcado
	public boolean isSwitchMarcado() {
		return dsl.isCheked(MobileBy.AccessibilityId("switch"));
	}
	
	//Clica no botão Salvar
	public void salvar() {
		dsl.clicarPorTexto("SALVAR");
	}
	
	//Checa informações 
	public String obterTexto() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='12']"));
	}
	
	public String obterConsole() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='13']"));
	}
	
	public String obterSwitch() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='15']"));
	}
	
	public String obterCheckBox() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='16']"));
	}
}
