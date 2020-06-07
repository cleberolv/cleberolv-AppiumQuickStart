package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class SBHomePage extends BasePage {
	
	public String getBalance(String account) {
		return getText(By.xpath("//*[@text='"+account+"']/following-sibling::android.widget.TextView"));
	}
}
