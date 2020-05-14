package application.test;

import org.junit.Assert;
import org.junit.Test;

import application.core.BaseTest;
import application.page.menuPage;
import application.page.splashPage;

public class SplashTest extends BaseTest {

	private menuPage menu = new menuPage();
	private splashPage splash = new splashPage();
	
	@Test
	public void testSplash() {
		//Acessar Menu Splash
		menu.acessarMenuSplash();
		
		//Verificar exibição do splash
		splash.textoSplashVisivel();
		
		//Aguardar saída do splash
		splash.textoSplashInvisivel();
		
		//Verificar o fomulário
		Assert.assertTrue();
	}
	
}
