package anudip.assignments;


import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

}
