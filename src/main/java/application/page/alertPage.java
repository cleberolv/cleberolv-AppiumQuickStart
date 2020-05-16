package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class alertPage extends BasePage {
	
	public void btnAlertConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarPorTexto("SAIR");
	}

}
