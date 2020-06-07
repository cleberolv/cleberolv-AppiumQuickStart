package application.page;

import static application.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class SBAccountPage extends BasePage {
	
	public void setConta(String name) {
		write(By.className("android.widget.EditText"), name);
	}
	
	public void btnSave() {
		clickByText("SALVAR");
	}
	
	public void btnDelete() {
		clickByText("EXCLUIR");
	}
	
	public void waitElement(String value) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + value + "']")));
		System.out.println("Element Found!");
	}
	
	public void longClick(String value) {
		new TouchAction<>(getDriver())
		.longPress(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='" + value + "']")))).perform();
	}

}
