package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LanguagePage {

	@FindBy(id = "com.clip:id/settings_tick_iv")
	private WebElement tickmark;

	// @FindBy(id = "(com.clip:id/settings_tick_iv)/..")
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.View[3]/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.ImageView/..")
	private WebElement tickmarkparent;

	@FindBy(id = "com.clip:id/settings_hindi")
	private WebElement hindi;

	@FindBy(id = "com.clip:id/bengali_tv")
	private WebElement bengali;

	@FindBy(id = "com.clip:id/telugu_tv")
	private WebElement telugu;

	@FindBy(id = "com.clip:id/marathi_tv")
	private WebElement marathi;

	@FindBy(id = "com.clip:id/tamil_tv")
	private WebElement tamil;

	@FindBy(id = "com.clip:id/urdu_tv")
	private WebElement urdu;

	@FindBy(id = "com.clip:id/kannada_tv")
	private WebElement kannada;

	@FindBy(id = "com.clip:id/gujarathi_tv")
	private WebElement gujarathi;

	@FindBy(id = "com.clip:id/mal_tv")
	private WebElement malyalam;

	@FindBy(id = "com.clip:id/punjabi_tv")
	private WebElement punjabi;

	@FindBy(id = "com.clip:id/english_tv")
	private WebElement English;

	// public void countlistBox()
	// {
	// int count = listName.size();
	// System.out.println(count);
	// }

	public LanguagePage(WebDriver driver) {
		PageFactory.initElements(driver, LanguagePage.this);
	}

	// public void selectableLanguage(String emailid)
	// {
	// listname.sendKeys(emailid);
	// }

	public void verifylanguagetext() {
		String val_hindi = hindi.getText().toString();
		Reporter.log(val_hindi, true);
		// SoftAssert s = new SoftAssert();
		// s.assertEquals(val_hindi, "j");
		// s.assertAll();
		String val_bengali = bengali.getText();
		String val_telugu = telugu.getText();
		String val_marathi = marathi.getText();
		String val_tamil = tamil.getText();
		String val_urdu = urdu.getText();
		String val_kannada = kannada.getText();
		String val_gujarathi = gujarathi.getText();
		String val_malyalam = malyalam.getText();
		String val_punjabi = punjabi.getText();
	}

	public void gotologin() {
		hindi.click();
	}

	// Need to fix this
	public void verifyselectedlanguage() {
		String tagname = tickmark.getTagName();
		Reporter.log(tagname, true);
		Reporter.log("is tagname is printed", true);

		String tickmark = tickmarkparent.getText().toString();
		Reporter.log(tickmark, true);

	}
}
