package application.test;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.core.BaseTest;
import application.core.DriverFactory;
import application.page.FormPage;
import application.page.MenuPage;
import io.appium.java_client.MobileBy;
import junit.framework.Assert;

public class FormTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private FormPage page = new FormPage();

	@Before
	public void acessMenu() throws MalformedURLException {
		menu.form();
	}
	
	@Test
	public void insertText() throws MalformedURLException {
		page.writeName("Dino");
		assertEquals("Dino", page.checkName());
	}

	@Test
	public void selectComboBox() throws MalformedURLException {
		page.selectComboBox("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", page.checkComboBox());
	}

	@Test
	public void switchAndCheckBox() throws MalformedURLException {
		Assert.assertTrue(page.isCheckBoxCheked());
		Assert.assertFalse(page.isSwitchCheked());

		page.clickCheckBox();
		page.clickSwitch();

		Assert.assertFalse(page.isCheckBoxCheked());
		Assert.assertTrue(page.isSwitchCheked());
	}

	@Test
	public void register() throws MalformedURLException {
		page.writeName("Cleber Oliveira");
		page.clickCheckBox();
		page.clickSwitch();
		page.selectComboBox("Nintendo Switch");

		page.save();

		Assert.assertEquals("Nome: Cleber Oliveira", page.getText());
		Assert.assertEquals("Console: switch", page.getConsole());
		Assert.assertEquals("Switch: Off", page.getSwitch());
		Assert.assertEquals("Checkbox: Marcado", page.getCheckBox());
	}
	
	@Test
	public void clickSaveProlonged() throws MalformedURLException {
		page.writeName("Cleber Oliveira");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		page.saveProlonged();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Cleber Oliveira']")));
		Assert.assertEquals("Nome: Cleber Oliveira", page.getText());
	}
	
	@Test
	public void changeDate() {
		page.clickByText("01/01/2000");
		page.clickByText("20");
		page.clickByText("OK");
		Assert.assertTrue(page.checkTextElement("20/2/2000"));
	}
	
	@Test
	public void changeHour() {
		page.clickByText("06:00");
		page.click(MobileBy.AccessibilityId("12"));
		page.click(MobileBy.AccessibilityId("10"));
		page.clickByText("OK");
		Assert.assertTrue(page.checkTextElement("12:10"));
	}
	
	@Test
	public void interactSeekBar() {
		page.clickSeekBar(0.67);
		page.save();
		Assert.assertEquals("Slider: 67", page.getValueSeekBar());
	}

}