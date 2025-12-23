package anudip.assignments;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest2 {

    private static final String HUB_URL = "http://localhost:4444/wd/hub";

    @Test
    public void openUdemyInChrome() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), options);
        driver.get("https://www.udemy.com/");
        System.out.println("Test2 Chrome Title: " + driver.getTitle());
        driver.quit();
    }

    @Test
    public void openSpringInFirefox() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), options);
        driver.get("https://spring.io/projects/spring-boot");
        System.out.println("Test2 Firefox Title: " + driver.getTitle());
        driver.quit();
    }
}

