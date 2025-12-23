package anudip.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestEcommerce {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser(){
		
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		System.out.println("Browser launched and site opened");
	}
	
	@Test(priority=1)
	public void printTitleandUrl() {
		System.out.println("The Title of the webpage is : "+driver.getTitle());
		System.out.println("The URL of the webpage is : "+driver.getCurrentUrl());
	}
	
	@Test(priority=2, dependsOnMethods = "printTitleandUrl")
	public void printPageSource() {
		System.out.println("The page Source is : "+driver.getPageSource());
	}
	
	@Test(priority=3, dependsOnMethods = "printPageSource", enabled = false)
	public void checkSearchBox() {
		WebElement searchBox = driver.findElement(By.id("search_query_top"));
		System.out.println("Search Box displayed :"+searchBox.isDisplayed());
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser Closed...");
	}

}
