package anudip.assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assign3FacebookLoginTest {
	@Test
	public void launchAndLoginTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Assign3FacebookLogin loginPage = new Assign3FacebookLogin(driver);
		loginPage.login("krishnikaa2020@gmail.com", "krishnikaa143");
		loginPage.clickLogin();
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
		driver.quit();
	}
	
}