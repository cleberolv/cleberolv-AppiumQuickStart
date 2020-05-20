package application.core;

import static application.core.driverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class basePage {

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
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
	}
	
}
