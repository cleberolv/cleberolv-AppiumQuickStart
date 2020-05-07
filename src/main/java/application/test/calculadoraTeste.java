package application.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class calculadoraTeste {

	@Test
	public void Soma() throws MalformedURLException {
	    
		DesiredCapabilities desiredCapablities = new DesiredCapabilities();
		
		desiredCapablities.setCapability("platformName", "Android");
	    desiredCapablities.setCapability("deviceName", "emulator-5554");
	    desiredCapablities.setCapability("automationName", "uiautomator2");
	    desiredCapablities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapablities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    desiredCapablities.setCapability("noSign", false);
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapablities);
	    
	    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    
	    System.out.println(el6.getText());
	    
	    Assert.assertEquals("5", el6.getText());
	    
	    driver.quit();
	}
	
}
