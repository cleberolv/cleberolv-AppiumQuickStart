package application.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.core.BaseTest;
import application.page.MenuPage;
import application.page.SplashPage;

public class SplashTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void interativeSplash() {
		menu.splash();
		page.splashTextVisible();
		page.splasTextInvisible();
		assertTrue(page.checkTextElement("Splash!"));
	}
	
}
