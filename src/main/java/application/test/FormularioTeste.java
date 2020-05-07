package application.test;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.core.DriverFactory;
import application.page.formularioPage;
import application.page.menuPage;
import junit.framework.Assert;

public class FormularioTeste {
	
	//instâncias
	
	private menuPage menu = new menuPage();
	private formularioPage formulario = new formularioPage();

	@Before
	//Passos precedentes para acesso às funcionalidades
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@After
	//Encerra a sessão
	public void tearDown(){
		DriverFactory.killDriver();
	}
	
	@Test
	public void insercaoDeTexto() throws MalformedURLException {
		
		//Escreve nome no formulário
		formulario.escreverNome("Dino");
		
		//Checar nome escrito
		assertEquals("Dino", formulario.checarNome());
	}

	@Test
	public void selecaoDeCombo() throws MalformedURLException {

		//Acessando o combo e selecionando opção desejada
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
}