package application.page;

import java.util.concurrent.TimeUnit;
import static application.core.driverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.basePage;

public class splashPage extends basePage {
	
	public boolean textoSplashVisivel() {
		return checkElementoTexto("Splash!");
	}
	
	public void textoSplashInvisivel() {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("Splash!")));
	}

}
