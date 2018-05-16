package pom;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DrawerPage {

	WebDriver driver;

	@FindBy(id = "com.clip:id/burger_iv")
	private WebElement drawericon;

	@FindBy(id = "com.clip:id/profile_rl")
	private WebElement profileview;

	@FindBy(id = "com.clip:id/notif_ll")
	private WebElement notif;

	@FindBy(id = "com.clip:id/explore_ll")
	private WebElement search;

	@FindBy(id = "com.clip:id/chat_ll")
	private WebElement chat;

	@FindBy(id = "com.clip:id/share_ll")
	private WebElement share;

	@FindBy(id = "com.clip:id/settings_ll")
	private WebElement setting;

	public DrawerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifygoinsidedrawer() {
		drawericon.click();
	}

	public void verifyalloptionsenabled() {
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		list.add(profileview);
		list.add(notif);
		list.add(search);
		list.add(chat);
		list.add(share);
		list.add(setting);

		for (WebElement element : list) {
			Boolean enabled = element.isEnabled();
			Boolean displayed = element.isDisplayed();
			String text = element.getText();
			Reporter.log(text + "is enabled = " + enabled + " and displayed = " + displayed, true);
		}
	}

	public void verifygotoprofile() {
		profileview.click();
	}

	public void verifygotosettings() {
		setting.click();
	}

	// Need to block using chat
	public void blockusingchat() {
		chat.click();
	}

	// Need to block from friendslist
	public void blockfriend() {

	}
}
