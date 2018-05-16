package clipscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import pom.ExplorePage;

public class VerifyExplore {
	
	WebDriver driver;
	
	@Test(priority = 1)
	public void testverifyrefreshfeed()
	{
		TouchAction action = new TouchAction ((MobileDriver)driver);
		action.press (200,600 ).waitAction(Duration.ofSeconds(2)).moveTo (200, 200).release ().perform ();
		ExplorePage explorepage = new ExplorePage(driver);
		explorepage.refreshfeed();
	}
	
	@Test(priority = 2)
	public void testverifytopbutton()
	{
		TouchAction action = new TouchAction ((MobileDriver)driver);
		action.press (200,600 ).waitAction(Duration.ofSeconds(2)).moveTo (200, 200).release ().perform ();
		ExplorePage explorepage = new ExplorePage(driver);
		explorepage.topbutton();
	}
	
	@Test(priority = 3)
	public void testverifygotofriendsusingbutton()
	{
		ExplorePage explorepage = new ExplorePage(driver);
		explorepage.gotofriendsusingbutton();
	}
	
	@Test(priority = 4)
	public void testverifygotonearbyusingbutton()
	{
		ExplorePage explorepage = new ExplorePage(driver);
		explorepage.gotofriendsusingbutton();
	}
	
	@Test(priority = 5)
	public void testplayvideo()
	{
		ExplorePage explorepage = new ExplorePage(driver);
		explorepage.playvideo();
	}
}
