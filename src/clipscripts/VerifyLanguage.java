package clipscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.DrawerPage;
import pom.LanguagePage;
import pom.LoginPage;
import pom.SettingsPage;

public class VerifyLanguage extends BaseTest {

	@Test(priority = 1)
	public void testlanguagetext() {
		LanguagePage lan_pag = new LanguagePage(driver);
		lan_pag.verifylanguagetext();
	}

	@Test(priority = 2)

	public void testgotologin() {
		LanguagePage lan_pag = new LanguagePage(driver);
		lan_pag.gotologin();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clip:id/google_rl")));
	}

	@Test(priority = 3)
	public void testloginmethodsenabled() {
		LoginPage login_page = new LoginPage(driver);
		login_page.verifyloginmethodsenabled();
	}

	@Test(priority = 4)
	public void testgmaillogin() {
		LoginPage login_page = new LoginPage(driver);
		login_page.verifygmaillogin();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login_page.verifyaccountname();

		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement burgericon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clip:id/thumbnail")));
		Reporter.log("waited till burger icon loaded", true);

		// String text = snackbar.getText();
		// Reporter.log(text,true);
	}

	// @Test(priority = 5)
	// public void testfloatbutton() {
	// ExplorePage explorepage = new ExplorePage(driver);
	// explorepage.topbutton();
	// }
	//
	// @Test(priority = 6)
	// public void testgotofriendusingbutton() {
	// ExplorePage explorepage = new ExplorePage(driver);
	// explorepage.gotofriendsusingbutton();
	// }
	//
	// @Test(priority = 7)
	// public void testnearbyusingbutton() {
	// ExplorePage explorepage = new ExplorePage(driver);
	// explorepage.gotonearbyusingbutton();
	// }
	//
	// @Test(priority = 8, invocationCount = 2)
	// public void testrefreshfeed() throws InterruptedException {
	// ExplorePage explorepage = new ExplorePage(driver);
	// Thread.sleep(2000);
	// explorepage.refreshfeed();
	// }
	//
	// @Test(priority = 9)
	// public void testplayvideo() {
	// ExplorePage explorepage = new ExplorePage(driver);
	// explorepage.playvideo();
	// }
	//
	// @Test(priority = 10)
	// public void testlike_dislikebutton() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.likecountbeforelike();
	// videopage.like();
	// videopage.like_colourcountafterlike();
	// }
	//
	// @Test(priority = 11)
	// public void testcommentemoji() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.commentemojidisplayed();
	// }
	//
	// @Test(priority = 12)
	// public void testcommenttextbox() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.commentusingcommenttextbox();
	// }
	//
	// @Test(priority = 13)
	// public void testcommentbutton_count() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.verifycommentcount();
	// }
	//
	// @Test(priority = 14)
	// public void testwhatsapp() throws InterruptedException {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.verifywhatsappcountusingfileshare();
	// videopage.verifywhatsappcountusinglinkshare();
	// }
	//
	// @Test(priority = 15)
	// public void testdownload() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.verifydownloadcount();
	// }
	//
	// @Test(priority = 16)
	// public void testfollow() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.verifyfollowbutton();
	// }
	//
	// @Test(priority = 17)
	// public void testunfollow() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.verifyunfollow();
	// }
	//
	// @Test(priority = 18)
	// public void testbackbuttonofvideopage() {
	// VideoPage videopage = new VideoPage(driver);
	// videopage.verifybackbutttonofvideopage();
	// }
	//
	// @Test(priority = 19)
	// public void testcamerabuttonofexplorepage() {
	// ExplorePage explorepage = new ExplorePage(driver);
	// explorepage.gotocamera();
	// }
	//
	// @Test(priority = 20)
	// public void testdurationtimer() {
	// CameraPage camerapage = new CameraPage(driver);
	// camerapage.verifydurationtimer();
	// }
	//
	// @Test(priority = 21)
	// public void testcameraandflashbutton() {
	// CameraPage camerapage = new CameraPage(driver);
	// camerapage.verifycameraandflashbutton();
	// }
	//
	// @Test(priority = 22)
	// public void testbothcameraforrecording() throws InterruptedException {
	// CameraPage camerapage = new CameraPage(driver);
	// camerapage.verifyrecordvideousingbothcamera();
	// camerapage.verifygotoeditpage();
	// }
	//
	// @Test(priority = 23)
	// public void testeditpage() {
	// EditPage editpage = new EditPage(driver);
	// editpage.verifyframethemesticker();
	// }
	//
	// @Test(priority = 24)
	// public void testbackbuttonwithremoveediting() {
	// CameraPage camerapage = new CameraPage(driver);
	// camerapage.veriybackbuttonwithremoveediting();
	// }
	//
	// @Test(priority = 25)
	// public void testdeletelastframe() {
	// CameraPage camerapage = new CameraPage(driver);
	// camerapage.verifydeletelastfragementofvideo();
	// camerapage.verifydeletelastfragementofvideo();
	// }
	//
	// @Test(priority = 26)
	// public void testtwofragementvideo() throws InterruptedException {
	// CameraPage camerapage = new CameraPage(driver);
	// camerapage.verifyrecordtwofragementofvideo();
	// camerapage.verifygotoeditpage();
	// }
	//
	// @Test(priority = 27)
	// public void testbackbuttonwithkeepediting() {
	// CameraPage camerapage = new CameraPage(driver);
	// camerapage.verifybackbuttonwithkeepediting();
	// }
	//
	// @Test(priority = 28)
	// public void testframethemesticker() {
	// EditPage editpage = new EditPage(driver);
	// editpage.verifyframethemesticker();
	// }
	//
	// @Test(priority = 29)
	// public void testsound() {
	// EditPage editpage = new EditPage(driver);
	// editpage.verifysound();
	// }
	//
	// @Test(priority = 30)
	// public void testdraw() throws InterruptedException {
	// EditPage editpage = new EditPage(driver);
	// editpage.verifydraw();
	// }
	//
	// @Test(priority = 31)
	// public void testtrim() {
	// EditPage editpage = new EditPage(driver);
	// editpage.verifytrimforonesec();
	// }
	//
	// @Test(priority = 32)
	// public void testhashtag() throws InterruptedException {
	// EditPage editpage = new EditPage(driver);
	// editpage.verifyhashtag();
	// }

	@Test(priority = 5)
	public void testdrawerpage() {
		DrawerPage drawerpage = new DrawerPage(driver);
		drawerpage.verifygoinsidedrawer();
		// drawerpage.verifyalloptionsenabled();
		// drawerpage.verifygotoprofile();
		drawerpage.verifysettings();
	}

	// @Test(priority = 6)
	// public void testprofilepage() {
	// ProfilePage profilepage = new ProfilePage(driver);
	// profilepage.verifythumbnailcount();
	// profilepage.verifygetdatafromallbuttons();
	// // profilepage.verifymorebutton();
	// profilepage.verifygotoeditprofile();
	// }
	//
	// @Test(priority = 7)
	// public void testeditprofilepage() {
	// ProfileEditPage profileeditpage = new ProfileEditPage(driver);
	// profileeditpage.verifyfullname();
	// }

	// Need to fix this
	@Test(priority = 6)
	public void testsettingpage() {
		SettingsPage settingpage = new SettingsPage(driver);
		settingpage.verifyapplanguage();
	}
}
