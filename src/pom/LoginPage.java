package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(id = "com.clip:id/phone_tv")
	private WebElement phone_login;

	@FindBy(id = "com.clip:id/fb_rl")
	private WebElement facebook_login;

	@FindBy(id = "com.clip:id/google_rl")
	private WebElement gmail_login;

	@FindBy(id = "com.google.android.gms:id/title")
	private WebElement loginbox;

	// @FindBy(id="com.google.android.gms:id/account_name[@text='amit.ranjan@clipapp.in']")
	@FindBy(className = "android.widget.LinearLayout")
	private List<WebElement> accountname;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyloginmethodsenabled() {
		if (phone_login.isEnabled()) {
			Reporter.log("phone login is enabled", true);
		} else {
			Reporter.log("phone login is not enaled", true);
		}

		if (facebook_login.isEnabled()) {
			Reporter.log("facebook login is enabled", true);
		} else {
			Reporter.log("facebook login is not enabled", true);
		}

		if (gmail_login.isEnabled()) {
			Reporter.log("gmail login is enabled", true);
		} else {
			Reporter.log("gmail login is not enabled", true);
		}
	}

	public void verifygmaillogin() {
		gmail_login.click();
	}

	public void verifyaccountname() {
		accountname.get(1).click();
	}

}
