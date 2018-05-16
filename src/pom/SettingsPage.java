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
import org.testng.asserts.SoftAssert;

public class SettingsPage {

	WebDriver driver;

	@FindBy(id = "com.clip:id/back_iv")
	private WebElement back;

	@FindBy(id = "com.clip:id/cache_num_tv")
	private WebElement cachememory;

	@FindBy(id = "com.clip:id/cache_num_tv")
	private WebElement clearcachedmemory;

	@FindBy(id = "com.clip:id/change_lang_ll")
	private WebElement changelanguage;

	@FindBy(id = "com.clip:id/block_ll")
	private WebElement blockedpersons;

	@FindBy(id = "com.clip:id/comment_switch")
	private WebElement commentswitch;

	@FindBy(id = "com.clip:id/report_ll")
	private WebElement report;

	@FindBy(id = "com.clip:id/rating_ll")
	private WebElement rating;

	@FindBy(id = "com.clip:id/tnc_rl")
	private WebElement tnc;

	@FindBy(id = "com.clip:id/logout_tv")
	private WebElement logout;

	@FindBy(id = "com.clip:id/content_lang_rl")
	private WebElement videolanguage;

	@FindBy(id = "com.clip:id/app_lang_rl")
	private WebElement applanguage;

	@FindBy(id = "com.clip:id/no_users_iv")
	private WebElement no_user_blocked;

	@FindBy(id = "com.clip:id/fullname_tv")
	private List<WebElement> blockedfullname;

	@FindBy(id = "com.clip:id/user_data_tv")
	private List<WebElement> blockedusername;

	@FindBy(id = "com.clip:id/unblock_tv")
	private List<WebElement> unblockbutton;

	@FindBy(id = "com.clip:id/report_et")
	private WebElement reporttextbox;

	@FindBy(id = "com.clip:id/send_tv")
	private WebElement sendbutton;

	@FindBy(id = "com.clip:id/rate_bar")
	private WebElement apprating;

	@FindBy(id = "com.clip:id/cross_iv")
	private WebElement closeapprating;

	@FindBy(id = "com.clip:id/privacy_ll")
	private WebElement privacypolicy;

	@FindBy(id = "com.clip:id/top_up_ll")
	private WebElement termsagreement;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clearmemory() {
		String cachedmemoryvalue = cachememory.getText();
		Reporter.log(cachedmemoryvalue, true);

		clearcachedmemory.click();
		String clearedcache = cachememory.getText();
		Reporter.log(clearedcache, true);

		SoftAssert s = new SoftAssert();
		s.assertEquals(clearedcache, "0.00 Bytes");
		s.assertAll();
	}

	public void videolanguagechange() {
		changelanguage.click();
		videolanguage.click();
		VideoLanguagePage vlp = new VideoLanguagePage(driver);
		vlp.verifyselectedlanguagesnumber();
	}

	public void verifychangevideolanguage() {
		changelanguage.click();
		videolanguage.click();
		VideoLanguagePage vlp = new VideoLanguagePage(driver);
		vlp.verifychangelanguage();
	}

	public void verifycommentswitch() {
		if (commentswitch.isEnabled()) {
			commentswitch.click();
			back.click();
			DrawerPage drawerpage = new DrawerPage(driver);
			drawerpage.verifygoinsidedrawer();
			drawerpage.verifygotoprofile();
			ProfilePage profilepage = new ProfilePage(driver);
			profilepage.verifymyvideocommentenabledornot();
			back.click();
			back.click();
			drawerpage.verifygoinsidedrawer();
			drawerpage.verifygotosettings();
		} else {
			commentswitch.click();
			back.click();
			DrawerPage drawerpage = new DrawerPage(driver);
			drawerpage.verifygoinsidedrawer();
			drawerpage.verifygotoprofile();
			ProfilePage profilepage = new ProfilePage(driver);
			profilepage.verifymyvideocommentdisabledornot();
			back.click();
			back.click();
			drawerpage.verifygoinsidedrawer();
			drawerpage.verifygotosettings();
		}
	}

	// Need to fix this
	public void verifyapplanguage() {
		changelanguage.click();
		applanguage.click();
		LanguagePage languagepage = new LanguagePage(driver);
		languagepage.verifyselectedlanguage();
	}

	public void verifyblock() {
		blockedpersons.click();
		if (no_user_blocked.isDisplayed()) {
			Reporter.log("No user is blocked", true);
			back.click();
			back.click();
			DrawerPage drawerpage = new DrawerPage(driver);
			drawerpage.verifygoinsidedrawer();
			drawerpage.verifygotoprofile();
			ProfilePage profilePage = new ProfilePage(driver);
			profilePage.verifygotofriendlist();
			FriendListPage friendlistpage = new FriendListPage(driver);
			friendlistpage.verifyblockprofile();

		} else {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement videothumbnail = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clip:id/fullname_tv")));
			String countofblockedpersons = Integer.toString(blockedfullname.size());
			Reporter.log("Total blocked persons are: " + countofblockedpersons, true);

			unblockbutton.get(0).click();
			String countafterunblock = Integer.toString(blockedfullname.size());
			Reporter.log("count after unblock: " + countafterunblock);
		}
	}
}
