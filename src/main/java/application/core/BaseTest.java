package application.core;

import org.junit.After;
import org.junit.AfterClass;

public class BaseTest {
	
	//Otimização de performance 
	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.getDriver().resetApp();
	}
	
	//Encerra a sessão
	@After
	public void tearDown(){
		DriverFactory.killDriver();
	}

}
