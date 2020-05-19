package application.test;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.baseTest;
import application.core.driverFactory;
import application.page.formularioPage;
import application.page.menuPage;
import junit.framework.Assert;

public class formularioTest extends baseTest {
	
	// Instâncias
	
	private menuPage menu = new menuPage();
	private formularioPage page = new formularioPage();

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
		driverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		//Clica no botão salvar demorado
		page.salvarDemorado();
		
		//Instaciando a classe WebDriverWait e definindo o time out (limite) para 10 segundos
		WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), 10);
		
		//Aguardando até o elemento xpath ser apresentado na tela
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Cleber Oliveira']")));
		
		// Valida campo digitado
		Assert.assertEquals("Nome: Cleber Oliveira", page.obterTexto());
	}
}