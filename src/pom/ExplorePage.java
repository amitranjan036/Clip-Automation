package pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class ExplorePage {
	WebDriver driver;

	@FindBy(id = "com.clip:id/username_tv")
	private List<WebElement> username;

	@FindBy(id = "com.clip:id/data_tv")
	private List<WebElement> no_of_view;

	@FindBy(id = "com.clip:id/go_top_iv")
	private WebElement gotop;

	@FindBy(id = "com.clip:id/camera_iv")
	private WebElement camera;

	@FindBy(id = "com.clip:id/burger_iv")
	private WebElement menu_button;

	// Need to provide index no "0" here
	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	private List<WebElement> headerbuttons;

	// Need to provide index no "0" here
	@FindBy(id = "com.clip:id/thumbnail")
	private List<WebElement> selectvideo;

	public ExplorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, ExplorePage.this);
	}

	public void refreshfeed() {
		String explorebutton = headerbuttons.get(1).getText();
		headerbuttons.get(1).click();
		Reporter.log(explorebutton, true);

		String username_before_refreshfeed = username.get(0).getText();
		Reporter.log(username_before_refreshfeed, true);

		String no_of_view_before_refreshfeed = no_of_view.get(0).getText();
		Reporter.log(no_of_view_before_refreshfeed, true);

		Reporter.log("scroll will start", true);

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.press(300, 300).waitAction(Duration.ofSeconds(1)).moveTo(300, 700).release().perform();

		Reporter.log("scrolling is done", true);

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/progress")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String username_after_refreshfeed = username.get(0).getText();
		Reporter.log(username_after_refreshfeed, true);

		String no_of_view_after_refreshfeed = no_of_view.get(0).getText();
		Reporter.log(no_of_view_after_refreshfeed, true);

		if (username_before_refreshfeed.equals(username_after_refreshfeed)
				& no_of_view_before_refreshfeed.equals(no_of_view_after_refreshfeed)) {
			Reporter.log("Refresh Feed Failed", true);
			SoftAssert s = new SoftAssert();
			s.assertNotEquals(username_after_refreshfeed, username_before_refreshfeed);
			s.assertAll();
		} else {
			Reporter.log("Refresh Feed Passed", true);
		}
	}

	public void topbutton() {
		Reporter.log("scroll down for float button", true);

		for (int i = 0; i <= 15; i++) {
			TouchAction action = new TouchAction((MobileDriver) driver);
			action.press(300, 700).waitAction(Duration.ofSeconds(1)).moveTo(300, 300).release().perform();
		}

		Reporter.log("scrolling is done", true);
		gotop.click();
		Reporter.log("float button is clicked", true);
	}

	public void gotofriendsusingbutton() {
		headerbuttons.get(0).click();
	}

	public void gotonearbyusingbutton() {
		headerbuttons.get(2).click();
	}

	public void gotocamera() {
		camera.click();
	}

	public void playvideo() {
		selectvideo.get(0).click();
	}

}
