package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class CameraPage {
	WebDriver driver;

	@FindBy(id = "com.clip:id/themeOverlay")
	private WebElement themeoverlay;

	@FindBy(id = "com.clip:id/duration_toggle_tv")
	private WebElement videoduration;

	@FindBy(id = "com.clip:id/snackbar_text")
	private WebElement durationchangessnackbar;

	@FindBy(id = "com.clip:id/capture_iv")
	private WebElement capturepausevideo;

	@FindBy(id = "com.clip:id/delete_iv")
	private WebElement frameanddeletebutton;

	@FindBy(id = "com.clip:id/upload_iv")
	private WebElement uploadandgallery;

	@FindBy(id = "com.clip:id/rotate_iv")
	private WebElement switchcamera;

	@FindBy(id = "com.clip:id/back_iv")
	private WebElement backbutton;

	@FindBy(id = "com.clip:id/flash_iv")
	private WebElement flash;

	// @FindBy(id="com.clip:id/tick_iv")
	// private WebElement tick;

	@FindBy(id = "com.clip:id/recorder_progress")
	private WebElement recorderprogress;

	@FindBy(id = "android:id/content")
	private WebElement dialoguebox;

	@FindBy(id = "android:id/button2")
	private WebElement keepvideo;

	@FindBy(id = "android:id/button1")
	private WebElement removevideo;

	@FindBy(id = "com.clip:id/parent")
	private List<WebElement> subelements;

	public CameraPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifydurationtimer() {
		String durationtext1 = videoduration.getText();
		Reporter.log(durationtext1, true);
		videoduration.click();
		String durationtext2 = videoduration.getText();
		Reporter.log(durationtext2, true);
		videoduration.click();
		String durationtext3 = videoduration.getText();
		Reporter.log(durationtext3, true);
		videoduration.click();
		String durationtext4 = videoduration.getText();
		Reporter.log(durationtext4);

		if (durationtext1.equals("16s")) {
			SoftAssert s = new SoftAssert();
			s.assertEquals(durationtext2, "61s");
			s.assertEquals(durationtext3, "7s");
			s.assertAll();
		} else if (durationtext1.equals("61s")) {
			SoftAssert s = new SoftAssert();
			s.assertEquals(durationtext2, "7s");
			s.assertEquals(durationtext3, "16s");
			s.assertAll();
		} else if (durationtext1.equals("7s")) {
			SoftAssert s = new SoftAssert();
			s.assertEquals(durationtext2, "16s");
			s.assertEquals(durationtext3, "61s");
			s.assertAll();
		}

	}

	// Need to compare imageview to verify frames

	public void verifyaddframebeforerecording() {
		frameanddeletebutton.click();
		subelements.get(1).click();
		// String src = themeoverlay.getAttribute("src");
		// Reporter.log("imagesrc "+src,true);
		// driver.switchTo().defaultContent();
		// tick.click();
		TouchAction action = new TouchAction((MobileDriver) driver);
		// action.press (600,1000 ).waitAction(Duration.ofSeconds(1)).moveTo (600,
		// 500).release ().perform ();
		action.press(500, 500);
	}

	public void verifyrecordtwofragementofvideo() throws InterruptedException {
		capturepausevideo.click();
		Thread.sleep(3000);
		// pausing the recording
		capturepausevideo.click();
		// resuming the recording
		capturepausevideo.click();
		Thread.sleep(3000);
		// pausing the recording
		capturepausevideo.click();
	}

	public void verifydeletelastfragementofvideo() {
		frameanddeletebutton.click();
	}

	public void verifygotoeditpage() {
		uploadandgallery.click();
	}

	public void verifycameraandflashbutton() {
		if (switchcamera.isEnabled()) {
			Reporter.log("camera button is enabled", true);
		}
		switchcamera.click();
		if (flash.isEnabled()) {
			flash.click();
			Reporter.log("flash button is enabled", true);
		} else {
			switchcamera.click();
			if (flash.isEnabled()) {
				flash.click();
				Reporter.log("flash button is enabled", true);
			}
		}
		;
		flash.click();
		switchcamera.click();
	}

	public void verifybackbuttonwithkeepediting() {
		backbutton.click();
		keepvideo.click();
	}

	public void veriybackbuttonwithremoveediting() {
		backbutton.click();
		removevideo.click();
	}

	public void verifyrecordvideousingbothcamera() throws InterruptedException {
		capturepausevideo.click();
		Thread.sleep(3000);
		capturepausevideo.click();
		switchcamera.click();
		capturepausevideo.click();
		Thread.sleep(3000);
		capturepausevideo.click();
	}

}
