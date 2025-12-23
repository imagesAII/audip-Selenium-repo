package anudip.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestImplicitIDPass {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		
		submit.click();
		

	}

}
