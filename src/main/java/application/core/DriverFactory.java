package application.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	// Verifica se já há uma sessão, se não, cria uma nova.
	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
//			createDriver();
			createTestObjectDriver();
		}
		return driver;
	}

	// Capabilities para aparelho virtual
	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/inmetrics/eclipse-workspace/CursoAppium/src/main/resources/AppiumCT.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Capabilities para aparelho na nuvem
	private static void createTestObjectDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("testobject_api_key", "C5ADE955983F4642B086A3817546E12E");
		desiredCapabilities.setCapability("appiumVersion", "1.17.0");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("autoGrantPermissions", "true");


		try {
			driver = new AndroidDriver<MobileElement>(new URL("https://appium.testobject.com/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TimeOut padrão
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Encerra sessão
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
