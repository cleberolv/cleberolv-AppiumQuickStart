package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class AccordionPage extends BasePage {

	public void acessAccordion() {
		click(By.className("android.widget.TextView"));
	}
	
	public String validateAccordion() {		
		return getText(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
	
	}
	
}
