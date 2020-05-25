package application.page.SB;

import static application.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class SBContasPage extends BasePage {
	
	public void setConta(String nome) {
		escreverFormulario(By.className("android.widget.EditText"), nome);
	}
	
	public void btnSalvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void btnExcluir() {
		clicarPorTexto("EXCLUIR");
	}
	
	public void esperaElemento(String valor) {
		//Aguarda até a visibilidade de determinado elemento 
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + valor + "']")));
		System.out.println("Bingo! Elemento encontrado");
	}
	
	public void cliqueLongo(String valor) {
		new TouchAction<>(getDriver())
		.longPress(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='" + valor + "']")))).perform();
	}

}
