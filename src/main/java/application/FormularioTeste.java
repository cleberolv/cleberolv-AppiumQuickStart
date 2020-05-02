package application;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class FormularioTeste{

	@Test
	public void insercaoDeTexto() throws MalformedURLException {
	    
		DesiredCapabilities desiredCapablities = new DesiredCapabilities();
		
		desiredCapablities.setCapability("platformName", "Android");
	    desiredCapablities.setCapability("deviceName", "emulator-5554");
	    desiredCapablities.setCapability("automationName", "uiautomator2");
	    desiredCapablities.setCapability(MobileCapabilityType.APP , "/home/inmetrics/eclipse-workspace/CursoAppium/src/main/resources/AppiumCT.apk");
	    desiredCapablities.setCapability("noSign", false);
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapablities);
	    
	   //timeOut
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar Formulário
	    List<MobileElement>  elementosencontrados = driver.findElements(By.className("android.widget.TextView"));
	    elementosencontrados.get(1).click();
	    
	    //Escrever Nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Dino");
	    
	    //Checkar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Dino", text);
	    
	    driver.quit();
	}
	
	@Test
	public void selecaoDeCombo() throws MalformedURLException {
	    
		DesiredCapabilities desiredCapablities = new DesiredCapabilities();
		
		desiredCapablities.setCapability("platformName", "Android");
	    desiredCapablities.setCapability("deviceName", "emulator-5554");
	    desiredCapablities.setCapability("automationName", "uiautomator2");
	    desiredCapablities.setCapability(MobileCapabilityType.APP , "/home/inmetrics/eclipse-workspace/CursoAppium/src/main/resources/AppiumCT.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapablities);
	    
	    //timeOut
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionando formulário via Xpath
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
	    //Acessando o Combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //Selecionar opção desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    // 							//class					 		 [@atributo='value']
	    
	    //Verificando opção selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("Nintendo Switch", text);
	    
	    driver.quit();
	}
	
	@Test
	public void switchAndCheckBox() throws MalformedURLException {
	    
		DesiredCapabilities desiredCapablities = new DesiredCapabilities();
		
		desiredCapablities.setCapability("platformName", "Android");
	    desiredCapablities.setCapability("deviceName", "emulator-5554");
	    desiredCapablities.setCapability("automationName", "uiautomator2");
	    desiredCapablities.setCapability(MobileCapabilityType.APP , "/home/inmetrics/eclipse-workspace/CursoAppium/src/main/resources/AppiumCT.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapablities);
	    
	    //timeOut
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionando formulário via Xpath
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	    
	    //Verificar status dos elementos
	    MobileElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switch_ = driver.findElement(MobileBy.AccessibilityId("switch"));
	    //True ou false Não boolean
	    Assert.assertTrue(checkbox.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switch_.getAttribute("checked").equals("true"));
	    
	    //clicar nos elementos
	    checkbox.click();
	    switch_.click();
	    
	    //verificar status alterados
	    Assert.assertTrue(checkbox.getAttribute("checked").equals("true"));
	    Assert.assertTrue(switch_.getAttribute("checked").equals("false"));
	    
	    driver.quit();
	}
	
	
	@Test
	public void desafioFormulario() throws MalformedURLException {

		DesiredCapabilities desiredCapablities = new DesiredCapabilities();
		
		desiredCapablities.setCapability("platformName", "Android");
	    desiredCapablities.setCapability("deviceName", "emulator-5554");
	    desiredCapablities.setCapability("automationName", "uiautomator2");
	    desiredCapablities.setCapability(MobileCapabilityType.APP , "/home/inmetrics/eclipse-workspace/CursoAppium/src/main/resources/AppiumCT.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapablities);
	    
	    //timeOut
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //1. Abrir formulário
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
	    //2. Preencher Campos
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("Cleber Oliveira");
	    driver.findElement(By.className("android.widget.CheckBox")).click();
	    driver.findElement(By.className("android.widget.Switch")).click();
	    driver.findElement(By.className("android.widget.Spinner")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

	    //3. Clicar no botão salvar
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	    
	    //4. Validar campos
	    
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
