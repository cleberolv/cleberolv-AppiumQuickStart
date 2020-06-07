package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

	public class SBTransactionsPage extends BasePage {
	
	public void setDescription(String description) {
		write(By.className("android.widget.EditText"), description);
	}
	
	public void setStakeholder(String stakeholder) {
		write(By.xpath("//*[@text='Interessado']"), stakeholder);
	}
	
	public void setValue(String value) {
		write(By.xpath("//*[@text='Valor']"), value);
	}
	
	public void selectComboBox(String value) {
		selectComboBox(By.xpath("//*[@text='Selecione uma conta...']"), value);
	}
	
	public void btnSave() {
		clickByText("SALVAR");
	}
}
