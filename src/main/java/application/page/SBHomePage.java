package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class SBHomePage extends BasePage {
	
	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
}
