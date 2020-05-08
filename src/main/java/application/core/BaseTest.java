package application.core;

import org.junit.After;

public class BaseTest {
	
	@After
	//Encerra a sessão
	public void tearDown(){
		DriverFactory.killDriver();
	}

}
