package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class FriendListPage {
	WebDriver driver;

	@FindBy(id = "com.clip:id/back_iv")
	private WebElement back;

	@FindBy(id = "com.clip:id/fullname_tv")
	private List<WebElement> fullname;

	@FindBy(id = "com.clip:id/user_data_tv")
	private List<WebElement> username;

	@FindBy(id = "com.clip:id/unblock_tv")
	private List<WebElement> friendandunfriendbutton;

	@FindBy(id = "com.clip:id/more_iv")
	private List<WebElement> morebutton;

	@FindBy(id = "com.clip:id/title")
	private List<WebElement> blockandshareprofileonwhatsapp;

	@FindBy(id = "com.clip:id/followers_num_tv")
	private List<WebElement> followers;

	@FindBy(id = "com.clip:id/views_num_tv")
	private List<WebElement> friendtotalviews;

	@FindBy(id = "com.clip:id/follow_ll")
	private WebElement friendandunfriendbuttoninsideprofile;

	@FindBy(id = "com.clip:id/msg_ll")
	private WebElement messagefromprofile;

	@FindBy(id = "com.clip:id/my_wibes_tv")
	private List<WebElement> totalvideoes;

	@FindBy(id = "com.clip:id/thumbnail")
	private List<WebElement> videoesthumbnails;

	@FindBy(id = "com.clip:id/data_tv")
	private List<WebElement> singlevideoview;

	public FriendListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyblockprofile() {
		fullname.get(0).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement videothumbnail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clip:id/thumbnail")));
		Reporter.log("waited 10 sec for thumnail", true);
		morebutton.get(0).click();
		blockandshareprofileonwhatsapp.get(1).click();
	}
}
