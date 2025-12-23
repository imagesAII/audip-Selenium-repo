package anudip.assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class GridTest {
    public static void main(String[] args) throws Exception {

        // ChromeOptions can be replaced with FirefoxOptions for Firefox testing
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), 
                options
        );

        driver.get("https://opensource-demo.orangehrmlive.com");
        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }
}
