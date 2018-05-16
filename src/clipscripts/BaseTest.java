package clipscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public WebDriver driver;

	@BeforeClass
	public void preCondition() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "myDevice");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.clip");
		capabilities.setCapability("appActivity", "com.clip.discovery.home.HomeActivity");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		TouchAction action = new TouchAction((MobileDriver) driver);
		action.press(300, 700).waitAction(Duration.ofSeconds(2)).moveTo(300, 400).release().perform();

	}

}
