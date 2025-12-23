package anudip.assignments;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//
//

public class SmokeTest_MulitipleURL {

    @Parameters("url")
    @Test
    public void openApp(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        System.out.println("Opening application : " + url);
    }
}
