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
	
	public void await(long timeMs) {
		try {
			Thread.sleep(timeMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Rule
	// Screenshots
	public TestName testName = new TestName();
	
	
	@AfterClass
	// Performance gain
	public static void finishClass() {
		DriverFactory.getDriver().resetApp();
	}
	
	@After
	public void tearDown(){
		takeScreenshot();
		DriverFactory.killDriver();
	}

	public void takeScreenshot() {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File ("target/screenshots/" +testName.getMethodName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
