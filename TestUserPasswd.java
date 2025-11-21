package anudip.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUserPasswd {
	
	public static void main(String[] args) throws InterruptedException {
		

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.name("username"));

		username.sendKeys("student");
		
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.name("password"));
		
		Thread.sleep(1000);

		password.sendKeys("Password123");

		WebElement loginButton = driver.findElement(By.className("btn"));
		Thread.sleep(1000);
		loginButton.click();

	}

}
