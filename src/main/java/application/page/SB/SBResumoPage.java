package application.page.SB;

import static application.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class SBResumoPage extends BasePage {
	
	public void esperaTexto(String valor) {
		// Aguarda até a visibilidade do texto
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + valor + "']")));
	}

	public void swipeElementLeft(String movimentacao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text = '" + movimentacao + "']/..")), 0.1, 0.9);
	}

	public void swipeElementRight(String movimentacao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text = '" + movimentacao + "']/..")), 0.9, 0.1);
	}
	
	public void clicarBotaoDeletar() {
		new TouchAction<>(getDriver())
				.tap(ElementOption.element(getDriver()
				.findElement(By.xpath("//*[@text='Del']/.."))))
				.perform();
	}
}
