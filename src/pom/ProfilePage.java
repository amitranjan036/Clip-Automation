package pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class ProfilePage {

	WebDriver driver;

	@FindBy(id = "com.clip:id/back_iv")
	private WebElement back;

	@FindBy(id = "com.clip:id/more_iv")
	private WebElement more;

	@FindBy(id = "com.clip:id/title")
	private WebElement shareprofile;

	@FindBy(id = "Navigate up")
	private WebElement backfromwhatsapp;

	@FindBy(id = "com.clip:id/snackbar_text")
	private WebElement whatsappnotavailable;

	@FindBy(id = "com.clip:id/user_pic_iv")
	private WebElement userpic;

	@FindBy(id = "com.clip:id/fullname_tv")
	private WebElement fullname;

	@FindBy(id = "com.clip:id/user_name_tv")
	private WebElement username;

	@FindBy(id = "com.clip:id/followers_num_tv")
	private WebElement follower_num;

	@FindBy(id = "com.clip:id/friends_num_tv")
	private WebElement friends_num;

	@FindBy(id = "com.clip:id/views_num_tv")
	private WebElement totalviews;

	@FindBy(id = "com.clip:id/edit_profile_tv")
	private WebElement editprofile;

	@FindBy(id = "com.clip:id/my_wibes_tv")
	private WebElement myuploadedvideo;

	@FindBy(id = "com.clip:id/fav_wibes_tv")
	private WebElement mylikedvideo;

	@FindBy(id = "com.clip:id/comment_num_ll")
	private WebElement myvideocommentbutton;

	@FindBy(id = "com.clip:id/thumbnail")
	private List<WebElement> videothumbnail;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifythumbnailcount() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int videocount = videothumbnail.size();
		String count = Integer.toString(videocount);
		Reporter.log(count, true);
		// Thread.sleep(5000);
		// videothumbnail.get(videocount - 1).click();
	}

	public void verifygetdatafromallbuttons() {
		String namefull = fullname.getText();
		String nameuser = username.getText();
		String num_follower = follower_num.getText();
		String num_friends = friends_num.getText();
		String viewstotal = totalviews.getText();

		Reporter.log("fullname " + namefull, true);
		Reporter.log("username " + nameuser, true);
		Reporter.log("follower_num " + num_follower, true);
		Reporter.log("friends_num " + num_friends, true);
		Reporter.log("totalviews " + viewstotal, true);
	}

	public void verifymorebutton() {
		more.click();
		shareprofile.click();
		try {
			// driver.findElement(By.id("Navigate up")).click();
			backfromwhatsapp.click();
		} catch (Exception e) {
			String toastmessage = whatsappnotavailable.getText();
			Reporter.log("whatsapp not available " + toastmessage, true);
		}
	}

	public void verifygotoeditprofile() {
		editprofile.click();
	}

	public void verifyafterediting() {

	}

	public void verifymyvideocommentenabledornot() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement videothumbnail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clip:id/thumbnail")));
		Reporter.log("waited 10 sec for thumnail", true);
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.press(300, 300).waitAction(Duration.ofSeconds(1)).moveTo(300, 700).release().perform();
		if (myvideocommentbutton.isEnabled()) {
			Reporter.log("Comment button is enabled", true);
			SoftAssert s = new SoftAssert();
			s.fail();
			s.assertAll();
		} else {
			Reporter.log("comment button is not enabled", true);

		}
	}

	public void verifymyvideocommentdisabledornot() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement videothumbnail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clip:id/thumbnail")));
		Reporter.log("waited 10 sec for thumnail", true);
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.press(300, 300).waitAction(Duration.ofSeconds(1)).moveTo(300, 700).release().perform();
		if (myvideocommentbutton.isEnabled()) {
			Reporter.log("Comment button is enabled", true);
		} else {
			Reporter.log("comment button is not enabled", true);
			SoftAssert s = new SoftAssert();
			s.fail();
			s.assertAll();
		}
	}

	// Need to block from friendslist
	public void verifygotofriendlist() {
		friends_num.click();

	}

}
