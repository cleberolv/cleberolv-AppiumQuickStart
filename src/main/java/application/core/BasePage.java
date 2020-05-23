package application.core;

import static application.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

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

	public boolean chekedMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("false");

	}

	public boolean checkElementoTexto(String texto) {
		List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elements.size() > 0;
	}

	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}

	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();

		// Faz a primeira localização da tela: vertical 50%
		int x = size.width / 2;

		// Define as ações de scroll
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		// Realiza as ações de scrool

		new TouchAction<>(getDriver()).longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y))
				.release().perform();

	}
}
