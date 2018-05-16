package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProfileEditPage {

	WebDriver driver;

	@FindBy(id = "com.clip:id/back_iv")
	private WebElement back;

	@FindBy(id = "com.clip:id/name_et")
	private WebElement nametextbox;

	@FindBy(id = "com.clip:id/username_et")
	private WebElement usernametextbox;

	@FindBy(id = "com.clip:id/pic_iv")
	private WebElement changepic;

	@FindBy(id = "android:id/text1")
	private List<WebElement> picselectoptions;

	@FindBy(id = "com.clip:id/m_radio")
	private WebElement maleradiobutton;

	@FindBy(id = "com.clip:id/f_radio")
	private WebElement femaleradiobutton;

	@FindBy(id = "com.clip:id/save_tv")
	private WebElement submit;

	public ProfileEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyfullname() {

		String fullname = nametextbox.getText();
		String username = usernametextbox.getText();

		Reporter.log(fullname, true);
		Reporter.log(username, true);

		nametextbox.clear();
		nametextbox.sendKeys("amit");
	}

	public void verifyusername() {
		int i = 0;
		int j = i + 1;

		for (i = 0; i < j; i++) {
			usernametextbox.sendKeys("amit" + i);
		}
	}

	public void verifygenderbox() {
		if (maleradiobutton.isSelected()) {
			femaleradiobutton.click();
		} else {
			maleradiobutton.click();
		}
	}

	public void verifysubmitbutton() {
		submit.click();
	}

}
