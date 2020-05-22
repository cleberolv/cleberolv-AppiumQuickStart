package application.page;

import static application.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import application.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class CliquesPage extends BasePage {

	// (!) Changed to JRE 1.7
	
	public void cliqueLongo() {
		new TouchAction<>(getDriver())
		.longPress(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))).perform();
	}
	
	public String obterTextoCampo() {
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
	
}