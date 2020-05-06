package application;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import application.core.DSL;
import application.core.DriverFactory;
import io.appium.java_client.MobileBy;
import junit.framework.Assert;

public class FormularioTeste {
	
	private DSL dsl = new DSL();

	@Before
	//Passos precedentes para acesso às funcionalidades
	public void inicializarAppium() throws MalformedURLException {
		//Selecionando formulário (DSL)
		dsl.clicarPorTexto("Formulário");
	}

	@After
	//Encerra a sessão
	public void tearDown(){
		DriverFactory.killDriver();
	}
	
	@Test
	public void insercaoDeTexto() throws MalformedURLException {

		// Escrever Nome (DSL)
		dsl.escreverFormulario(MobileBy.AccessibilityId("nome"), "Dino");

		// Checkar nome escrito (DSL)
		assertEquals("Dino", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	@Test
	public void selecaoDeCombo() throws MalformedURLException {

		// Acessando o combo e selecionando opção desejada
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		// Verificando opção selecionada
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", text);
	}

	@Test
	public void switchAndCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		Assert.assertTrue(dsl.isCheked(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheked(MobileBy.AccessibilityId("switch")));

		// clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// verificar status alterados
		Assert.assertFalse(dsl.isCheked(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheked(MobileBy.AccessibilityId("switch")));
	}

	@Test
	public void realizarCadastro() throws MalformedURLException {

		// Preencher Campos
		dsl.escreverFormulario(By.className("android.widget.EditText"), "Cleber Oliveira");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");

		// Clicar no botão salvar
		dsl.clicarPorTexto("SALVAR");

		// Validar campos
		Assert.assertEquals("Nome: Cleber Oliveira", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='12']")));
		Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='13']")));
		Assert.assertEquals("Switch: Off", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='15']")));
		Assert.assertEquals("Checkbox: Marcado", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='16']")));
	}
}