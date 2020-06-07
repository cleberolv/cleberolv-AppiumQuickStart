package application.core;

import static application.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void await(long timeMs) {
		try {
			Thread.sleep(timeMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitMenu() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Found element, starting test...");
	}

	public void write(By by, String text) {
		getDriver().findElement(by).sendKeys(text);
	}

	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}

	public void click(By by) {
		getDriver().findElement(by).click();
	}

	public void clickByText(String text) {
		click(By.xpath("//*[@text='" + text + "']"));
	}

	public void selectComboBox(By by, String value) {
		getDriver().findElement(by).click();
		getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + value + "']")).click();
	}

	public boolean isNotCheked(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("false");

	}
	
	public boolean isCheked(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public boolean checkTextElement(String text) {
		List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + text + "']"));
		return elements.size() > 0;
	}

	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	public void scroll(double start, double end) {
		Dimension size = getDriver().manage().window().getSize();

		// Vertical 50% of the screen
		int x = size.width / 2;

		// Defines the scrool actions
		int start_y = (int) (size.height * start);
		int end_y = (int) (size.height * end);

		// Do the scrool actions
		new TouchAction<>(getDriver()).longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y))
				.release().perform();

	}

	public void scrollElement(MobileElement element, double start, double end) {

		int x = element.getLocation().x + (element.getSize().width / 2);

		int start_y = (int) (element.getSize().height * start);
		int end_y = (int) (element.getSize().height * end);

		new TouchAction<>(getDriver()).longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y))
				.release().perform();
	}

	public void swipe(double start, double end) {
		Dimension size = getDriver().manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * start);
		int end_x = (int) (size.width * end);

		new TouchAction<>(getDriver()).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();
	}

	public void swipeElement(MobileElement element, double start, double end) {

		int y = element.getLocation().y + (element.getSize().height / 2);

		int start_x = (int) (element.getSize().width * start);
		int end_x = (int) (element.getSize().width * end);

		new TouchAction<>(getDriver()).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();
	}
	
	// 0.9 = 90% of the screen 
	public void scrollDown() {
		scroll(0.9, 0.1);
	}

	public void scrollUP() {
		scroll(0.1, 0.9);
	}

	public void swipeLeft() {
		swipe(0.1, 0.9);
	}

	public void SwipeRight() {
		swipe(0.9, 0.1);
	}
}
