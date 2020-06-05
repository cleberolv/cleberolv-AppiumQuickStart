package application.test;

import org.junit.Before;
import org.junit.Test;

import application.core.BasePage;
import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SBContasPage;
import application.page.SBHomePage;
import application.page.SBLoginPage;
import application.page.SBMenuPage;
import application.page.SBMovimentacaoPage;
import application.page.SBResumoPage;
import junit.framework.Assert;

public class SBTest extends BaseTest {
	
	//Base
	private MenuPage menuPage = new MenuPage();
	private BasePage page = new BasePage();
	
	//Acessos & Menus SB
	private SBLoginPage login = new SBLoginPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBMenuPage menu = new SBMenuPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void login() {
		menuPage.acessarMenuSB();
		login.setEmail("o@c");
		login.setSenha("a");
		login.btnEntrar();
	}
	
	/* --------------------------------------------- CONTAS --------------------------------------------- */
	
	@Test
	public void incluirConta() {
		//Acessar aba contas
		menu.abaContas();
		
		//Preencher nome da conta
		contas.setConta("Conta da minha nene <3");
		
		//Salvar
		contas.btnSalvar();
		
		//Validar
		contas.esperaElemento("Conta adicionada com sucesso");
		page.scrollDown();
		Assert.assertTrue(contas.checkElementoTexto("Conta da minha nene"));
	}
	
	@Test
	public void contaJaExistente() {
		//Acessar aba contas
		menu.abaContas();
		
		//Preencher nome da conta
		contas.setConta("Conta mesmo nome");
		
		//Salvar
		contas.btnSalvar();
		
		//Validar
		Assert.assertTrue(contas.checkElementoTexto("Problemas de comunicação"));
	}
	
	@Test
	public void excluirConta() {
		//Acessar aba contas
		menu.abaContas();
		
		//Localizar conta
		contas.esperaElemento("Conta para alterar");
		
		//Longo clique
		contas.cliqueLongo("Conta para alterar");
		
		//Excluir
		contas.btnExcluir();
		
		//Validar
		Assert.assertTrue(page.checkElementoTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void contaInexistente() {
		//Acessar aba contas
		menu.abaContas();
		
		//Validar que conta não existe na lista
		Assert.assertFalse(page.checkElementoTexto("Conta do Mark Manson"));
	}
	
	/* ------------------------------------------ MOVIMENTAÇÕES --------------------------------------------- */
	
	@Test
	public void inconssitenciasMov() {
		//Acessar aba Movimentações
		menu.abaMovimentacoes();
		
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
		menu.abaMovimentacoes();
		
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
		
		//Validar Movimentação
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		//Acessar aba Resumo
		menu.abaResumo();
			
		//Validar elemento para exclusão
		resumo.esperaTexto("Movimentacao 3, calculo saldo");
		
		//deslizar para excluir
		resumo.swipeElementRight("Movimentacao 3, calculo saldo");
		
		//Clicar no botao excluir
		resumo.clicarBotaoDeletar();
		
		//Validar exclusão
		resumo.esperaTexto("Movimentação removida com sucesso!");
		
		//Acessar aba Resumo
		menu.abaHome();
		
		//Validar que a exclusão foi efetuada
		esperar(1000);
		page.scroll(0.2, 0.9);
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
