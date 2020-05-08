package application.core;

import static application.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {
	public void escreverFormulario(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}

	public void selecionarCombo(By by, String valor) {

		getDriver().findElement(by).click();
		getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + valor + "']")).click();
	}

	public boolean isCheked(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("false");

	}
}
