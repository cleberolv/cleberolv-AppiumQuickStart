package application;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import application.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class FormularioTeste {

	private AndroidDriver<MobileElement> driver;

	@Before
	//Faz a chamada do Driver Factory para iniciar a sessão
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	}

	@After
	//Encerra a sessão
	public void tearDown(){
		DriverFactory.killDriver();
	}
	
	@Test
	public void insercaoDeTexto() throws MalformedURLException {

		// Escrever Nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Dino");

		// Checkar nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Dino", text);
	}

	@Test
	public void selecaoDeCombo() throws MalformedURLException {

		// Acessando o Combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// Selecionar opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		// //class [@atributo='value']

		// Verificando opção selecionada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);
	}

	@Test
	public void switchAndCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		MobileElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switch_ = driver.findElement(MobileBy.AccessibilityId("switch"));
		// True ou false Não boolean
		Assert.assertTrue(checkbox.getAttribute("checked").equals("false"));
		Assert.assertTrue(switch_.getAttribute("checked").equals("true"));

		// clicar nos elementos
		checkbox.click();
		switch_.click();

		// verificar status alterados
		Assert.assertTrue(checkbox.getAttribute("checked").equals("true"));
		Assert.assertTrue(switch_.getAttribute("checked").equals("false"));
	}

	@Test
	public void desafioFormulario() throws MalformedURLException {

		// Preencher Campos
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Cleber Oliveira");
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// Clicar no botão salvar
		driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();

		// Validar campos
		String nome = driver.findElement(By.xpath("//android.widget.TextView[@index='12']")).getText();
		Assert.assertEquals("Nome: Cleber Oliveira", nome);
		String console = driver.findElement(By.xpath("//android.widget.TextView[@index='13']")).getText();
		Assert.assertEquals("Console: switch", console);
		String switch_1 = driver.findElement(By.xpath("//android.widget.TextView[@index='15']")).getText();
		Assert.assertEquals("Switch: Off", switch_1);
		String check = driver.findElement(By.xpath("//android.widget.TextView[@index='16']")).getText();
		Assert.assertEquals("Checkbox: Marcado", check);
	}
}