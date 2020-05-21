package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class AccordionPage extends BasePage {

	public void AcessarAcordeon() {
		clicar(By.className("android.widget.TextView"));
	}
	
	public String validarAcordeon() {
		//Verificar erro no Xpath
		return obterTexto(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
	
	}
	
}
