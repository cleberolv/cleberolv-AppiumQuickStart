package application.test;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.BaseTest;
import application.core.DriverFactory;
import application.page.formularioPage;
import application.page.menuPage;
import junit.framework.Assert;

public class FormularioTeste extends BaseTest {
	
	// Instâncias
	
	private menuPage menu = new menuPage();
	private formularioPage formulario = new formularioPage();

	@Before
	// Passos precedentes para acesso às funcionalidades
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@Test
	public void insercaoDeTexto() throws MalformedURLException {
		
		// Escreve nome no formulário
		formulario.escreverNome("Dino");
		
		// Checar nome escrito
		assertEquals("Dino", formulario.checarNome());
	}

	@Test
	public void selecaoDeCombo() throws MalformedURLException {

		// Acessando o combo e selecionando opção desejada
		formulario.selecionarCombo("Nintendo Switch");
		
		// Verificando opção selecionada
		Assert.assertEquals("Nintendo Switch", formulario.checarCombo());
	}

	@Test
	public void switchAndCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());

		// clicar nos elementos
		formulario.clicarCheck();
		formulario.clicarSwitch();

		// verificar status alterados
		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertTrue(formulario.isSwitchMarcado());
	}

	@Test
	public void realizarCadastro() throws MalformedURLException {

		// Preencher Campos
		formulario.escreverNome("Cleber Oliveira");
		formulario.clicarCheck();
		formulario.clicarSwitch();
		formulario.selecionarCombo("Nintendo Switch");

		// Clicar no botão salvar
		formulario.salvar();

		// Validar campos
		Assert.assertEquals("Nome: Cleber Oliveira", formulario.obterTexto());
		Assert.assertEquals("Console: switch", formulario.obterConsole());
		Assert.assertEquals("Switch: Off", formulario.obterSwitch());
		Assert.assertEquals("Checkbox: Marcado", formulario.obterCheckBox());
	}
	
	@Test
	public void clicarSalvarDemorado() throws MalformedURLException {

		// Preenchendo campo através da chamada do método da classe formularioPage() 
		formulario.escreverNome("Cleber Oliveira");
		
		// Zerando o timeout implicito para o método
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		//Clica no botão salvar demorado
		formulario.salvarDemorado();
		
		//Instaciando a classe WebDriverWait e definindo o time out (limite) para 10 segundos
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		
		//Aguardando até o elemento xpath ser apresentado na tela
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Cleber Oliveira']")));
		
		// Valida campo digitado
		Assert.assertEquals("Nome: Cleber Oliveira", formulario.obterTexto());
	}
}