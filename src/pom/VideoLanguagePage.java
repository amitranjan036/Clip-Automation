package pom;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class VideoLanguagePage {

	WebDriver driver;

	@FindBy(id = "com.clip:id/back_iv")
	private WebElement back;

	@FindBy(id = "com.clip:id/num_tv")
	private WebElement selectedlanguages;

	@FindBy(id = "com.clip:id/hindi_tv")
	private WebElement hindi_rb;

	@FindBy(id = "com.clip:id/bengali_tv")
	private WebElement bengali_rb;

	@FindBy(id = "com.clip:id/telugu_tv")
	private WebElement telugu_rb;

	@FindBy(id = "com.clip:id/marathi_tv")
	private WebElement marathi_rb;

	@FindBy(id = "com.clip:id/tamil_tv")
	private WebElement tamil_rb;

	@FindBy(id = "com.clip:id/urdu_tv")
	private WebElement urdu_rb;

	@FindBy(id = "com.clip:id/kannada_tv")
	private WebElement kannada_rb;

	@FindBy(id = "com.clip:id/gujarati_tv")
	private WebElement gujarati_rb;

	@FindBy(id = "com.clip:id/mal_tv")
	private WebElement malyalam_rb;

	@FindBy(id = "com.clip:id/punjabi_tv")
	private WebElement punjabi_rb;

	@FindBy(id = "com.clip:id/next_tv")
	private WebElement updatebutton;

	public VideoLanguagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	ArrayList<WebElement> listofselectedlanguage = new ArrayList<WebElement>();

	public void verifyselectedlanguagesnumber() {
		int count = 0;
		// Print selected video language
		String numberofselectedvideolanguage = selectedlanguages.getText();
		Reporter.log("Video Language selected in begining" + numberofselectedvideolanguage, true);

		ArrayList<WebElement> listofselectedvideo = new ArrayList<WebElement>();
		listofselectedvideo.add(hindi_rb);
		listofselectedvideo.add(bengali_rb);
		listofselectedvideo.add(telugu_rb);
		listofselectedvideo.add(marathi_rb);
		listofselectedvideo.add(tamil_rb);
		listofselectedvideo.add(urdu_rb);
		listofselectedvideo.add(kannada_rb);
		listofselectedvideo.add(gujarati_rb);
		listofselectedvideo.add(malyalam_rb);
		listofselectedvideo.add(punjabi_rb);

		for (WebElement element : listofselectedvideo) {
			// Printing the enabled and disabled radio buttons
			String name1 = element.getText();
			if (element.isEnabled()) {
				Reporter.log(name1 + "is enabled", true);
			} else {
				Reporter.log(name1 + "is not enabled", true);
				SoftAssert s = new SoftAssert();
				s.fail();
				s.assertAll();
			}

			// changing the the selected video language and getting the count with changes
			if (element.isSelected()) {
				element.click();
				updatebutton.click();
			} else {
				element.click();
				listofselectedlanguage.add(element);
				count++;
				updatebutton.click();
			}
		}

		// verifying count of select video language
		int selectedvideonumber = Integer.parseInt(numberofselectedvideolanguage);
		SoftAssert s = new SoftAssert();
		s.assertEquals(10 - selectedvideonumber, count);
		Reporter.log("count is matching with changes video language number", true);
		s.assertAll();
		back.click();
	}

	// verifying whether selected language changes or not
	public void verifychangelanguage() {
		for (WebElement languagename : listofselectedlanguage) {
			if (languagename.isSelected()) {
				Reporter.log(languagename.getText() + " is enabled");
			} else {
				Reporter.log(languagename.getText() + " is not enabled");
				SoftAssert s = new SoftAssert();
				s.fail();
				s.assertAll();
			}
		}
	}
}
