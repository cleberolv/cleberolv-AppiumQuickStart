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
import application.page.FormularioPage;
import application.page.MenuPage;
import io.appium.java_client.MobileBy;
import junit.framework.Assert;

public class FormularioTest extends BaseTest {
	
	// Instâncias
	
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	// Passos precedentes para acesso às funcionalidades
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@Test
	public void insercaoDeTexto() throws MalformedURLException {
		
		// Escreve nome no formulário
		page.escreverNome("Dino");
		
		// Checar nome escrito
		assertEquals("Dino", page.checarNome());
	}

	@Test
	public void selecaoDeCombo() throws MalformedURLException {

		// Acessando o combo e selecionando opção desejada
		page.selecionarCombo("Nintendo Switch");
		
		// Verificando opção selecionada
		Assert.assertEquals("Nintendo Switch", page.checarCombo());
	}

	@Test
	public void switchAndCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());

		// clicar nos elementos
		page.clicarCheck();
		page.clicarSwitch();

		// verificar status alterados
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());
	}

	@Test
	public void realizarCadastro() throws MalformedURLException {

		// Preencher Campos
		page.escreverNome("Cleber Oliveira");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");

		// Clicar no botão salvar
		page.salvar();

		// Validar campos
		Assert.assertEquals("Nome: Cleber Oliveira", page.obterTexto());
		Assert.assertEquals("Console: switch", page.obterConsole());
		Assert.assertEquals("Switch: Off", page.obterSwitch());
		Assert.assertEquals("Checkbox: Marcado", page.obterCheckBox());
	}
	
	@Test
	public void clicarSalvarDemorado() throws MalformedURLException {

		// Preenchendo campo através da chamada do método da classe formularioPage() 
		page.escreverNome("Cleber Oliveira");
		
		// Zerando o timeout implicito para o método
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		//Clica no botão salvar demorado
		page.salvarDemorado();
		
		//Instaciando a classe WebDriverWait e definindo o time out (limite) para 10 segundos
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		
		//Aguardando até o elemento xpath ser apresentado na tela
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Cleber Oliveira']")));
		
		// Valida campo digitado
		Assert.assertEquals("Nome: Cleber Oliveira", page.obterTexto());
	}
	
	@Test
	public void alterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.checkElementoTexto("20/2/2000"));
	}
	
	@Test
	public void alterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("12"));
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.checkElementoTexto("12:10"));
	}
	
	@Test
	public void interagindoComSeekBar() {
		//clicar no seekbar
		page.clicarSeekBar(0.67);
		
		//salvar
		page.salvar();
		
		//validar valor
		Assert.assertEquals("Slider: 67", page.obterValorSeekBar());
	}
	
}