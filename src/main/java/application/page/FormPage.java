package application.page;

import static application.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import application.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormPage extends BasePage{
	
	public void writeName(String name){
		write(MobileBy.AccessibilityId("nome"), name);
	}
	
	public String checkName() {
		return getText(MobileBy.AccessibilityId("nome"));
	}

	public void selectComboBox(String value) {
		selectComboBox(MobileBy.AccessibilityId("console"), value);
	}
	
	public String checkComboBox() {
		return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clickCheckBox() {
		click(By.className("android.widget.CheckBox"));
	}
	
	public void clickSwitch() {
		click(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckBoxCheked() {
		return isNotCheked(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchCheked() {
		return isNotCheked(MobileBy.AccessibilityId("switch"));
	}
	
	public void save() {
		clickByText("SALVAR");
	}
	
	public void saveProlonged() {
		clickByText("SALVAR DEMORADO");
	}
	
	public String getText() {
		return getText(By.xpath("//android.widget.TextView[@index='12']"));
	}
	
	public String getConsole() {
		return getText(By.xpath("//android.widget.TextView[@index='13']"));
	}
	
	public String getValueSeekBar() {
		return getText(By.xpath("//android.widget.TextView[@index='14']"));
	}
	
	public String getSwitch() {
		return getText(By.xpath("//android.widget.TextView[@index='15']"));
	}
	
	public String getCheckBox() {
		return getText(By.xpath("//android.widget.TextView[@index='16']"));
	}
	
	public void clickSeekBar(double position) {
		int delta = 55;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		
		/*
		 * x = Xinitial + (Width * delta) 
		 * y = Yinitial + height / 2 
		 */
		
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		int xInicial = seek.getLocation().x + delta;
		int x = (int) (xInicial + ((seek.getSize().width - 2*delta) * position));
		System.out.println(x);
		
		tap (x, y);
	}
	
}
