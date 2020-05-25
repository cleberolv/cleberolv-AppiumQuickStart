package application.core;

import static application.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	public void esperaMenu() {
		//Aguarda até a visibilidade do elemento fomulário 
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Elemento encontrado, iniciando teste...");
	}

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

		//Scroll - vertical
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
		
		//Scroll - vertical (elemento)
		public void scrollElement(MobileElement element, double inicio, double fim) {
					
		//Define a localização do elemento
		int x = element.getLocation().x + (element.getSize().width / 2);

		// Define as ações de scroll
		int start_y = (int) (element.getSize().height * inicio);
		int end_y = (int) (element.getSize().height * fim);

		// Realiza as ações de scrool

		new TouchAction<>(getDriver()).longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y))
			.release().perform();
		}
	
		//Swipe - horizontal
		public void swipe(double inicio, double fim) {
			Dimension size = getDriver().manage().window().getSize();

			// Faz a primeira localização da tela: vertical 50%
			int y = size.height / 2;

			// Define as ações de scroll
			int start_x = (int) (size.width * inicio);
			int end_x = (int) (size.width * fim);

			// Realiza as ações de scrool

			new TouchAction<>(getDriver()).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
					.release().perform();
		}
		
		//Swipe - horizontal (elemento)
		public void swipeElement(MobileElement element, double inicio, double fim) {
			
			//Define a localização do elemento
			int y = element.getLocation().y + (element.getSize().height / 2);

			// Define as ações de scroll
			int start_x = (int) (element.getSize().width * inicio);
			int end_x = (int) (element.getSize().width * fim);

			// Realiza as ações de scrool

			new TouchAction<>(getDriver()).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
					.release().perform();
		}
		
		/*Direcionais: 
		 * De 10% a 90% da tela ou vice-versa 
		*/
		
		public void scrollDown() {
			scroll(0.9, 0.1);
		}
	
		public void scrollUP() {
			scroll(0.1, 0.9);
		}
	
		public void swipeLeft() {
			swipe(0.1, 0.9);
		}
	
		public void SwipeRight() {
			swipe(0.9, 0.1);
		}
}
