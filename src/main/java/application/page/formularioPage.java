package application.page;

import org.openqa.selenium.By;

import application.core.basePage;
import io.appium.java_client.MobileBy;

public class formularioPage extends basePage{
	
	//Escreve nome no formulário
	public void escreverNome(String nome){
		escreverFormulario(MobileBy.AccessibilityId("nome"), nome);
	}
	
	//Checa nome escrito no formulario
	public String checarNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	//Seleciona um valor no combo box
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	//Checa um valor selecionado no combo box
	public String checarCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	//Clica em um elemento check
	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}
	
	//Clica em um elemeto switch
	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	//Verfica se o elemento check está marcado
	public boolean isCheckMarcado() {
		return chekedMarcado(By.className("android.widget.CheckBox"));
	}
	
	//Verfica se o elemento switch está marcado
	public boolean isSwitchMarcado() {
		return chekedMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	//Clica no botão Salvar
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	//Clica no botão Salvar
	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	//Checa informações 
	public String obterTexto() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='12']"));
	}
	
	public String obterConsole() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='13']"));
	}
	
	public String obterSwitch() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='15']"));
	}
	
	public String obterCheckBox() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='16']"));
	}
}
