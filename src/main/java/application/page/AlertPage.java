package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class AlertPage extends BasePage {
	
	public void btnAlertConfirm() {
		clickByText("ALERTA CONFIRM");
	}
	
	public String getTitleAlert() {
		return getText(By.id("android:id/alertTitle"));
	}

	public String getMessageAlert() {
		return getText(By.id("android:id/message"));
	}
	
	public void confirm() {
		clickByText("CONFIRMAR");
	}
	
	public void exit() {
		clickByText("SAIR");
	}
	
	public void clickOK() {
		clickByText("OK");
	}
	
	public void clickSimpleAlert() {
		clickByText("ALERTA SIMPLES");
	}

	public void clickOut() {
		tap(500, 500);
	}
	
}
