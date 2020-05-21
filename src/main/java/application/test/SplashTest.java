package application.test;

import org.junit.Assert;
import org.junit.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SplashPage;

public class SplashTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void testSplash() {
		//Acessar Menu Splash
		menu.acessarMenuSplash();
		
		//Verificar exibição do splash
		page.textoSplashVisivel();
		
		//Aguardar saída do splash
		page.textoSplashInvisivel();
		
		//Verificar o fomulário
		Assert.assertTrue(page.checkElementoTexto("Splash!"));
	}
	
}
