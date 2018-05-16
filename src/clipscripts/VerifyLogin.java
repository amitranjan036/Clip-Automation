package clipscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pom.LoginPage;

public class VerifyLogin {
	WebDriver driver;
	@Test(priority=1)
	public void testloginmethodsenabled()
	{
		LoginPage login_page = new LoginPage(driver);
		login_page.verifyloginmethodsenabled();
	}
	
	@Test(priority=2)
	public void testgmaillogin()
	{
		LoginPage login_page = new LoginPage(driver);
		login_page.verifygmaillogin();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login_page.verifyaccountname();
	}

	
}
