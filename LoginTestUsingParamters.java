package anudip.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestUsingParamters {
	@Test
	@Parameters({ "username", "password", "expected" })
	public void performLogin(String username, String password, String expected) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
// Fill login form driver.findElement(By.id("username")).sendKeys(username); driver.findElement(By.id("password")).sendKeys(password); driver.findElement(By.id("submit")).click();
		Thread.sleep(2000); // Just for visibility, not recommended in production
		System.out.println("Attempted login with --> Username: " + username + " | Password: " + password);
		if (expected.equalsIgnoreCase("valid")) {
			boolean isLogoutPresent = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
			Assert.assertTrue(isLogoutPresent, "Expected successful login but it failed.");
			System.out.println("Login successful for user: " + username);
		} else {
			String errorMsg = driver.findElement(By.id("error")).getText();
			Assert.assertTrue(errorMsg.contains("invalid"), "Expected login failure, but login might have succeeded.");
			System.out.println("Login failed as expected for user: " + username + " with password: " + password);
		}
		driver.quit();
	}
}