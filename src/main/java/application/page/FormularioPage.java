package application.page;

import static application.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import application.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{
	
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
	
	public String obterValorSeekBar() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='14']"));
	}
	
	public String obterSwitch() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='15']"));
	}
	
	public String obterCheckBox() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='16']"));
	}
	
	public void clicarSeekBar(double posicao) {
		int delta = 55;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		
		/* Formulas
		 * x = Xinitial + (Width * delta) 
		 * y = Yinitial + height / 2
		 *  */
		
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		int xInicial = seek.getLocation().x + delta;
		int x = (int) (xInicial + ((seek.getSize().width - 2*delta) * posicao));
		System.out.println(x);
		
		tap (x, y);
	}
	
}
