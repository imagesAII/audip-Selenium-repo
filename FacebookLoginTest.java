package anudip.assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLoginTest {
	@Test
	public void launchAndLoginTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		FacebookLoginPage loginPage = new FacebookLoginPage(driver);
		loginPage.login("krishnikaa2020@gmail.com", "krishnikaa143");
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
		driver.quit();
	}
}
