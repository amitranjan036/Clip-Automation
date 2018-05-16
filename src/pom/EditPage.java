package pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class EditPage {
	WebDriver driver;

	@FindBy(id = "com.clip:id/ok_iv")
	private WebElement okbuttonforeditedandhashtagvideo;

	@FindBy(xpath = "(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout)")
	private WebElement layout;

	@FindBy(id = "com.clip:id/imageFrame")
	private WebElement framebutton;

	@FindBy(id = "com.clip:id/imageTheme")
	private WebElement themebutton;

	@FindBy(id = "com.clip:id/imageSticker")
	private WebElement sticker;

	@FindBy(id = "com.clip:id/imageSound")
	private WebElement sound;

	@FindBy(id = "com.clip:id/imageDraw")
	private WebElement drawing;

	@FindBy(id = "com.clip:id/imageTrim")
	private WebElement trim;

	@FindBy(id = "com.clip:id/imageButton1")
	private List<WebElement> imagebuttononeditpage;

	@FindBy(id = "com.clip:id/addMusic")
	private WebElement addmusicfromgallery;

	@FindBy(id = "com.clip:id/videoSoundSeekbar")
	private WebElement videovolume;

	@FindBy(id = "com.clip:id/audioSoundSeekbar")
	private WebElement audiovolume;

	@FindBy(id = "com.clip:id/row_title")
	private List<WebElement> audiorow;

	@FindBy(xpath = "(//android.widget.TextView[@content-desc=\"Options\"])")
	private List<WebElement> addbuttonofmusic;

	@FindBy(id = "android:id/body")
	private WebElement audioloaderbar;

	@FindBy(xpath = "(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.view.View/android.widget.TextView)")
	private List<WebElement> Allhashtags;

	@FindBy(id = "com.clip:id/chars_left_tv")
	private WebElement descriptionlength;

	@FindBy(id = "com.clip:id/desc_et")
	private WebElement descriptiontextbox;

	@FindBy(id = "com.clip:id/stoke")
	private WebElement stroketext;

	@FindBy(id = "com.clip:id/seekBar")
	private WebElement penstroke;

	@FindBy(id = "com.clip:id/undo")
	private WebElement undobutton;

	@FindBy(id = "com.clip:id/redo")
	private WebElement redobutton;

	@FindBy(id = "com.clip:id/stoke_black")
	private WebElement black;

	@FindBy(id = "com.clip:id/stoke_blue")
	private WebElement blue;

	@FindBy(id = "com.clip:id/stoke_orange")
	private WebElement orange;

	@FindBy(id = "com.clip:id/stoke_red")
	private WebElement red;

	@FindBy(id = "com.clip:id/stoke_green")
	private WebElement green;

	@FindBy(id = "com.clip:id/stoke_purple")
	private WebElement purple;

	@FindBy(id = "com.clip:id/textTime")
	private WebElement videototaltime;

	@FindBy(id = "com.clip:id/textTimeSelection")
	private WebElement editedtimeline;

	@FindBy(id = "com.clip:id/timeLineView")
	private WebElement timeselector;

	@FindBy(id = "com.clip:id/icon_video_play")
	private WebElement playbutton;

	public EditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyframethemesticker() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		imagebuttononeditpage.get(1).click();
		themebutton.click();
		imagebuttononeditpage.get(1).click();
		// sticker.click();
		// imagebuttononeditpage.get(1).click();
		// imagebuttononeditpage.get(0).click();
	}

	public void verifysound() {

		Dimension dimensions = layout.getSize();
		int width = dimensions.getWidth();
		int height = dimensions.getHeight();
		Reporter.log("width: " + width, true);
		Reporter.log("height:" + height, true);

		Point point = layout.getLocation();
		int x = point.getX();
		int y = point.getY();
		Reporter.log("X: " + x, true);
		Reporter.log("Y: " + y, true);

		int startx = x + 2 * (width / 4);
		int starty = y + (height / 2);
		int endx = x + (width / 4);
		int endy = starty;

		TouchAction action = new TouchAction((MobileDriver) driver);
		action.press(startx, starty).waitAction(Duration.ofSeconds(1)).moveTo(endx, endy).release().perform();
		// scroll for vivo
		// action.press(400, 900).waitAction(Duration.ofSeconds(1)).moveTo(200,
		// 900).release().perform();

		// scroll for honor6x
		// action.press(900, 1700).waitAction(Duration.ofSeconds(1)).moveTo(400,
		// 1700).release().perform();

		sound.click();

		if (audiovolume.isEnabled()) {
			Reporter.log("Audio is not added but audiovolume is enabled", true);
		} else {
			Reporter.log("audiovolume is not enabled because audio is not added", true);
		}

		// Add music from clipgallery
		addmusicfromgallery.click();

		String audiotext = audiorow.get(0).getText();
		Reporter.log("audiotext: " + audiotext, true);
		addbuttonofmusic.get(0).click();

		try {
			if (audioloaderbar.isDisplayed()) {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/body")));
			}
		} catch (Exception e) {
			Reporter.log("Audio downloaded");
		}

		// //Add music from phone gallery
		// addmusicfromgallery.click();
		// addbuttonofmusic.click();

		if (audiovolume.isEnabled()) {
			Reporter.log("Audio is added and now, audiovolume is enabled", true);
		} else {
			Reporter.log("Audio is added because audio volume is not enabled", true);
		}
	}

	public void verifydraw() {
		TouchAction action = new TouchAction((MobileDriver) driver);
		// action.press(400, 900).waitAction(Duration.ofSeconds(1)).moveTo(200,
		// 900).release().perform();

		drawing.click();
		blue.click();
		action.press(300, 300).waitAction(Duration.ofSeconds(1)).moveTo(300, 600).release().perform();
		red.click();
		action.press(150, 450).waitAction(Duration.ofSeconds(1)).moveTo(450, 450).release().perform();
		undobutton.click();
		redobutton.click();
	}

	public void verifytrimforonesec() {
		trim.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clip:id/icon_video_play")));

		if (playbutton.isEnabled()) {
			playbutton.click();
		} else {
			Reporter.log("Play button is not enabled", true);
		}

		String videoduration = videototaltime.getText();
		Reporter.log("video duration " + videoduration, true);

		String editedvideotimeline = editedtimeline.getText();
		Reporter.log("edited video timeline " + editedvideotimeline, true);

		Dimension dimensions = timeselector.getSize();
		int width = dimensions.getWidth();
		int height = dimensions.getHeight();
		Reporter.log("width: " + width, true);
		Reporter.log("height:" + height, true);

		Point point = timeselector.getLocation();
		int x = point.getX();
		int y = point.getY();
		Reporter.log("X: " + x, true);
		Reporter.log("Y: " + y, true);
		int restartx = x - 20;
		TouchAction action = new TouchAction((MobileDriver) driver);

		for (int i = 0; i <= 500; i++) {
			String videotime = videototaltime.getText().toString();
			Reporter.log(videotime, true);
			if (videotime.trim().equals("00:02")) {
				Reporter.log("time is 00:02", true);
				break;
			} else {
				int newx = restartx;
				int start_x = newx;
				int start_y = y + height + 50;
				int endx = start_x + 50;
				restartx = endx;

				action.press(start_x, start_y).waitAction(Duration.ofSeconds(1)).moveTo(endx, start_y).release()
						.perform();
				Reporter.log("moved " + i + " times", true);
			}
		}

		okbuttonforeditedandhashtagvideo.click();
		okbuttonforeditedandhashtagvideo.click();

	}

	public void verifyhashtag() throws InterruptedException {

		// Reading default hashtags and remaining space in description box
		Thread.sleep(3000);
		String hashtag = descriptiontextbox.getText();
		String remainingcharacters = descriptionlength.getText();
		char firstchar = remainingcharacters.charAt(0);
		int usedspace = firstchar;
		// int hashtaglength = hashtag.length();
		Reporter.log(hashtag, true);
		Reporter.log("remaining characters in hashtag " + remainingcharacters, true);
		// Reporter.log("value", hashtaglength, true);

		// Reading all hashtags in hashtag box
		int allhashtagcount = Allhashtags.size();
		String firsthashtag = Allhashtags.get(0).getText();
		int lengthfirsthashtag = firsthashtag.length();
		Reporter.log("All hashtag count ", allhashtagcount, true);
		Reporter.log("First Hashtag Text " + firsthashtag, true);
		Reporter.log("length first hashtag", lengthfirsthashtag, true);

		// Writing hashtag from hashtag box
		Allhashtags.get(0).click();
		String hashtagsindescriptionbox = descriptiontextbox.getText();
		String remainingcharafteraddinghashtag = descriptionlength.getText();
		char firstcharafteraddinghashtag = remainingcharafteraddinghashtag.charAt(0);
		int usedspaceafteraddinghashtag = firstcharafteraddinghashtag;
		Reporter.log("hashtags text: " + hashtagsindescriptionbox, true);

		// Writing hashtag and upload video
		// descriptiontextbox.sendKeys("Hashtag");
		okbuttonforeditedandhashtagvideo.click();
	}
}
