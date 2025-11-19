package com.anudip.org.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	public static void main(String[] args) {

//		testcase1();
//		testcase2();
//		testcase3();
//		testcase4();
	}
	
	private static void testcase4() {

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/SpringMvcJavaBasedConfig/");
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.name("userName"));

		username.sendKeys("pratikrunner@gmail.com");
		WebElement password = driver.findElement(By.name("passWord"));

		password.sendKeys("1234");

		WebElement loginButton = driver.findElement(By.className("btn"));
		loginButton.click();

	}

	private static void testcase3() {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.name("username"));

		username.sendKeys("student");
		WebElement password = driver.findElement(By.name("password"));

		password.sendKeys("Password123");

		WebElement loginButton = driver.findElement(By.className("btn"));
		loginButton.click();

	}

	private static void testcase2() {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("Create Facbook Account");
		searchBox.submit();

	}

	private static void testcase1() {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		String title = driver.getTitle();

		if (title.equals("Google")) {

			System.out.println("test passed");
		} else {
			System.out.println("test failed");
		}
	}

}
