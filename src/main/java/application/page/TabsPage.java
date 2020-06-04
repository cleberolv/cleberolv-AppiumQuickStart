package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class TabsPage extends BasePage {
	
	public String checkTabOne() {
		return obterTexto(By.xpath("//*[contains(@text, 'Aba 1')]"));
	}
	
	public String checkTabTwo() {
		return obterTexto(By.xpath("//*[contains(@text, 'Aba 2')]"));
	}
	
	public void changeTab() {
		clicarPorTexto("ABA 2");
	}
	
}
