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

public class baseTest {
	
	@Rule
	//Determina nome das screenshots
	public TestName testName = new TestName();
	
	
	@AfterClass
	//Otimização de performance 
	public static void finalizaClasse() {
		driverFactory.getDriver().resetApp();
	}
	
	@After
	//Encerra a sessão
	public void tearDown(){
		gerarScreenshot();
		driverFactory.killDriver();
	}
	
	//Gera screenshot
	public void gerarScreenshot() {
		File imagem = ((TakesScreenshot) driverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File ("target/screenshots/" +testName.getMethodName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
