package application.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import application.core.BasePage;
import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SBContasPage;
import application.page.SBLoginPage;
import application.page.SBMovimentacaoPage;
import junit.framework.Assert;

public class SBTest extends BaseTest {
	
	//Base
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();
	
	//Acessos & Menus
	private SBLoginPage login = new SBLoginPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	
	@Before
	public void login() {
		menu.acessarMenuSB();
		login.setEmail("cleber@test.com.br");
		login.setSenha("cleber");
		login.btnEntrar();
	}
	
	/* --------------------------------------------- CONTAS --------------------------------------------- */
	
	@Test
	public void incluirConta() {
		//Acessar aba contas
		page.clicarPorTexto("CONTAS");
		
		//Preencher nome da conta
		page.escreverFormulario(By.className("android.widget.EditText"), "Conta da Fernanda");
		
		//Salvar
		page.clicarPorTexto("SALVAR");
		
		//Validar
		contas.esperaElemento("Conta adicionada com sucesso");
		page.scrollDown();
		Assert.assertTrue(page.checkElementoTexto("Conta da Fernanda"));
	}
	
	@Test
	public void contaJaExistente() {
		//Acessar aba contas
		page.clicarPorTexto("CONTAS");
		
		//Preencher nome da conta
		page.escreverFormulario(By.className("android.widget.EditText"), "Conta mesmo nome");
		
		//Salvar
		page.clicarPorTexto("SALVAR");
		
		//Validar
		Assert.assertTrue(page.checkElementoTexto("Problemas de comunicação"));
	}
	
	@Test
	public void excluirConta() {
		//Acessar aba contas
		page.clicarPorTexto("CONTAS");
		
		//Localizar conta
		contas.esperaElemento("Conta para alterar");
		
		//Longo clique
		contas.cliqueLongo("Conta para alterar");
		
		//Excluir
		page.clicarPorTexto("EXCLUIR");
		
		//Validar
		Assert.assertTrue(page.checkElementoTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void contaInexistente() {
		//Acessar aba contas
		page.clicarPorTexto("CONTAS");
		
		//Validar que conta não existe na lista
		Assert.assertFalse(page.checkElementoTexto("Conta do Mark Manson"));
	}
	
	/* ------------------------------------------ MOVIMENTAÇÕES --------------------------------------------- */
	
	@Test
	public void inconssitenciasMov() {
		//Acessar aba Movimentações
		page.clicarPorTexto("MOV...");
		
		//Salvar
		mov.btnSalvar();
		
		//Validar Erro #1 - Descrição
		Assert.assertTrue(page.checkElementoTexto("Descrição é um campo obrigatório"));
		
		//Preencher Descição
		mov.setDescricao("Descrição");
		
		//Salvar
		mov.btnSalvar();
		
		//Validar Erro #2 - Interessado
		Assert.assertTrue(page.checkElementoTexto("Interessado é um campo obrigatório"));
		
		//Preencher Interessado
		mov.setInteressado("Interessado");
		
		//Salvar
		mov.btnSalvar();
		
		//Validar Erro #3 - Valor
		Assert.assertTrue(page.checkElementoTexto("Valor é um campo obrigatório"));
		
		//Preencher Valor
		mov.setValor("11");
				
		//Salvar
		mov.btnSalvar();
		
		//Validar Erro #4 - Conta
		Assert.assertTrue(page.checkElementoTexto("Conta é um campo obrigatório"));
	}
	
	@Test
	public void cadastrarMovimentacao() {
		//Acessar aba Movimentações
		page.clicarPorTexto("MOV...");
		
		//Preencher Descição
		mov.setDescricao("Descrição");
		
		//Preencher Interessado
		mov.setInteressado("Interessado");
		
		//Preencher Valor
		mov.setValor("11");
			
		//Preencher conta
		mov.selecionarCombo("Conta para movimentacoes");
		
		//Salvar
		mov.btnSalvar();
		
		//Validar inserção
		Assert.assertTrue(page.checkElementoTexto("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void excluirMovimentacao() {
		//mov.esperaCebacalho();
		mov.scrollElementDown("Conta para extrato");
		
		//Validar Movimentação
		mov.esperaTexto("Conta para movimentacoes");
		
		//Acessar aba Resumo
		page.clicarPorTexto("RESUMO");
		
		page.scrollDown();
		
		//Validar elemento para exclusão
		mov.esperaTexto("Conta para movimentacoes");
		
		//deslizar para excluir
		mov.swipeElementRight("Conta para movimentacoes");
		
		//Clicar no botao excluir
		mov.clicarBotaoDeletar();
		
		//Validar exclusão
		mov.esperaTexto("Movimentação removida com sucesso!");
		
		//Acessar aba Resumo
		page.clicarPorTexto("HOME");
		
		//Validar que a exclusão foi efetuada
		//mov.esperaCebacalho();
		page.scrollUP();
		Assert.assertFalse(page.checkElementoTexto("Conta para movimentacoes"));
	}
}
