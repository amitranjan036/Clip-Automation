package pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class VideoPage {
	WebDriver driver;

	@FindBy(id = "com.clip:id/emoji_btn")
	private WebElement commentemoji;

	@FindBy(id = "com.clip:id/comment_et")
	private WebElement commenttextbox;

	@FindBy(id = "com.clip:id/comment_send_iv")
	private WebElement sendbutton;

	@FindBy(id = "com.clip:id/back_iv")
	private WebElement topbackbutton;

	@FindBy(id = "com.clip:id/username_tv")
	private List<WebElement> userprofile;

	// need to provide index "0" here
	@FindBy(id = "com.clip:id/pic_iv")
	private WebElement profilepic;

	@FindBy(id = "com.clip:id/follow_tv")
	private WebElement followbutton;

	@FindBy(id = "com.clip:id/more_iv")
	private WebElement videomenubutton;

	@FindBy(id = "com.clip:id/exo_subtitles")
	private WebElement videoframe;

	@FindBy(id = "com.clip:id/like_rl")
	private WebElement likebutton;

	@FindBy(id = "com.clip:id/comment_num_ll")
	private WebElement commentbutton;

	@FindBy(id = "com.clip:id/whatsapp_rl")
	private WebElement whatsappbutton;

	@FindBy(id = "com.clip:id/download_rl")
	private WebElement downloadbutton;

	// need to provide index no "1"
	@FindBy(id = "com.clip:id/comm_username_tv")
	private WebElement usernameoflastcomment;

	// need to provide index no 2
	@FindBy(id = "com.clip:id/comm_tv")
	private WebElement textoflastcomment;

	@FindBy(id = "com.clip:id/desc_tv")
	private WebElement hashtag;

	// need to provide index no "0" here
	@FindBy(id = "com.clip:id/views_num_tv")
	private WebElement view;

	@FindBy(id = "com.clip:id/favs_num_tv")
	private WebElement like;

	@FindBy(id = "com.clip:id/comments_tv")
	private WebElement comment;

	@FindBy(id = "com.clip:id/whatsapp_tv")
	private WebElement whatsappshare;

	@FindBy(id = "com.clip:id/download_tv")
	private WebElement download;

	@FindBy(id = "com.clip:id/okay_button")
	private WebElement okaybutton;

	@FindBy(id = "com.clip:id/close")
	private WebElement closebutton;

	@FindBy(id = "com.clip:id/video_ll")
	private WebElement videofileshare;

	@FindBy(id = "com.clip:id/link_ll")
	private WebElement videolinkshare;

	@FindBy(id = "com.clip:id/wibe_rl")
	private WebElement videodownloadedtoastmessage;

	public VideoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void commentemojidisplayed() {
		// TouchAction action = new TouchAction ((MobileDriver)driver);
		// action.press (600,1000 ).waitAction(Duration.ofSeconds(2)).moveTo (600,
		// 500).release ().perform ();

		if (commentemoji.isDisplayed()) {
			Reporter.log("Comment Emoji is displayed");
		} else {
			Reporter.log("Comment emoji is not displayed");
		}
	}

	public void commentusingcommenttextbox() {
		if (commenttextbox.isEnabled()) {
			commenttextbox.sendKeys("good");
			commenttextbox.clear();
			commenttextbox.sendKeys("textbox");
			sendbutton.click();
		} else {
			Reporter.log("comment box is disabled", true);
		}
	}

	public void correctusername() {
		WebElement username = userprofile.get(1);
		String usernameonvideopage = username.getText();

		if (usernameonvideopage.equals()) {
			Reporter.log("correct username is displayed", true);
		} else {
			Reporter.log("correct username is not displayed", true);
		}
	}

	// verifying like and dislike functionality along with the changes in count of
	// like
	public void likecountbeforelike() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		TouchAction action = new TouchAction((MobileDriver) driver);
		action.press(300, 900).waitAction(Duration.ofSeconds(1)).moveTo(300, 500).release().perform();

		// Get the count before liking the video
		try {
			String likecountbeforelike = like.getText();
			Reporter.log("likecountbeforelike " + likecountbeforelike, true);
		} catch (NoSuchElementException e) {
			Reporter.log("No like is present on this video", true);
		}
	}

	public void like() {
		// like the video
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		likebutton.click();
		closebutton.click();
		Reporter.log("clicked on close button", true);
	}

	public void verifyvideoinlikedvideosection() {
		okaybutton.click();
	}

	public void like_colourcountafterlike() {
		// Get the count after liking the video
		try {
			String likecountafterlike = like.getText();
			Reporter.log("likecountafterlike " + likecountafterlike, true);
		} catch (NoSuchElementException e) {
			Reporter.log("Like count doesnt increased", true);
		}

		// dislike the video by clicking again on like button
		likebutton.click();

		// Get the count after dislike
		String likecountafterdislike = like.getText();
		Reporter.log("likecountafterdislike" + likecountafterdislike, true);
	}

	// comment using the comment button along with the changes in count of comment
	public void verifycommentcount() {
		String commentcountbeforecomment = comment.getText();
		if (commenttextbox.isEnabled()) {
			comment.click();
			commenttextbox.sendKeys("good");
			commenttextbox.clear();
			commenttextbox.sendKeys("commentbutton");
			sendbutton.click();
		} else {
			Reporter.log("comment box is disabled", true);
		}

		// need to check latest comment
		String lastcomment = textoflastcomment.getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(lastcomment, "commentbutton");
		s.assertAll();

		String commentcountaftercomment = comment.getText();
		Reporter.log("commentcountbeforecomment" + commentcountbeforecomment, true);
		Reporter.log("commentcountaftercomment" + commentcountaftercomment, true);
	}

	// verifying whatsappshare funtionality and whatsappcount
	public void verifywhatsappcountusingfileshare() throws InterruptedException {
		String whatsappsharecountbeforefileshare = whatsappshare.getText();

		// share the videofile on whatsapp
		whatsappbutton.click();
		videofileshare.click();

		// Need to wait for file download
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Navigate up")));
		driver.findElement(By.id("Navigate up")).click();
		Thread.sleep(2000);

		String whatsappsharecountafterfileshare = whatsappshare.getText();
		Reporter.log("whatsappsharecountbeforefileshare " + whatsappsharecountbeforefileshare);
		Reporter.log("whatsappsharecountaftersharewithvideo " + whatsappsharecountafterfileshare);
	}

	public void verifywhatsappcountusinglinkshare() throws InterruptedException {
		String whatsappsharecountbeforevideolinkshare = whatsappshare.getText();

		// share the videolink on whatsapp
		whatsappbutton.click();
		videolinkshare.click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Navigate up")));
		driver.findElement(By.id("Navigate up")).click();
		Thread.sleep(2000);

		String whatsappsharecountaftervideolinkshare = whatsappshare.getText();
		Reporter.log("whatsappsharecountbeforevideolinkshare " + whatsappsharecountbeforevideolinkshare);
		Reporter.log("whatsappsharecountaftervideolinkshare " + whatsappsharecountaftervideolinkshare);
	}

	// verify download
	public void verifydownloadcount() {
		String countbeforedownload = download.getText();
		downloadbutton.click();
		if (videodownloadedtoastmessage.isDisplayed()) {
			Reporter.log("video already downloaded", true);
		}
		String countafterdownload = download.getText();
		Reporter.log("countbeforedownload " + countbeforedownload);
		Reporter.log("countafterdownload " + countafterdownload);

		// compare download count

	}

	public void verifyfollowbutton() {
		String beforefollow = followbutton.getText();
		Reporter.log(beforefollow, true);
		followbutton.click();
		String afterfollow = followbutton.getText();
		Reporter.log(afterfollow, true);
		// if(beforefollow.equals(afterfollow))
		// {
		// Reporter.log("Follow button of video is working",true);
		// }
		// else
		// {
		// SoftAssert s = new SoftAssert();
		// s.assertNotEquals(afterfollow, beforefollow);
		// s.assertAll();
		// Reporter.log("Follow button of video page is not working",true);
		// }
		SoftAssert s = new SoftAssert();
		s.assertNotEquals(afterfollow, beforefollow);
		s.assertAll();
		Reporter.log("Follow button is working", true);
	}

	public void verifyunfollow() {
		String beforeunfollow = followbutton.getText();
		Reporter.log("beforeunfollow " + beforeunfollow, true);
		followbutton.click();
		String afterunfollow = followbutton.getText();
		Reporter.log("Afterunfollow " + afterunfollow, true);

		SoftAssert s = new SoftAssert();
		s.assertNotEquals(afterunfollow, beforeunfollow);
		s.assertAll();
		Reporter.log("unfollow button is working", true);
	}

	public void verifymenubutton() {
		videomenubutton.click();
	}

	public void verifyviewcount() {
		String viewcount = view.getText();
		Reporter.log("View count for video: " + viewcount, true);
	}

	public void verifybackbutttonofvideopage() {
		topbackbutton.click();
	}
}
