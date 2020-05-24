package application.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	//Wait em milissegunos
	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Rule
	//Determina nome das screenshots
	public TestName testName = new TestName();
	
	
	@AfterClass
	//Otimização de performance 
	public static void finalizaClasse() {
		DriverFactory.getDriver().resetApp();
	}
	
	@After
	//Encerra a sessão
	public void tearDown(){
		gerarScreenshot();
		DriverFactory.killDriver();
	}
	
	//Gera screenshot
	public void gerarScreenshot() {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File ("target/screenshots/" +testName.getMethodName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
