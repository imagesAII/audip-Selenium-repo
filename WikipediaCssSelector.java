package anudip.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaCssSelector 
{
    public static void main( String[] args )
    {
    	 WebDriver driver = new ChromeDriver();
         
         try {
             driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin");
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             
             WebElement usernameField = driver.findElement(By.cssSelector("input[id^='wpName']"));
             WebElement passwordField = driver.findElement(By.cssSelector("input[id*='wpPassword']"));
             WebElement loginButton = driver.findElement(By.cssSelector("button[id$='wpLoginAttempt']"));
             
             usernameField.sendKeys("testuser");
             passwordField.sendKeys("password123");
             loginButton.click();
             
             Thread.sleep(5000);
             
             if (driver.getCurrentUrl().contains("UserLoginSuccess")) {
                 System.out.println("Login Successful!");
             } else {
                 System.out.println("Login Failed! Check credentials.");
             }
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
          //   driver.quit();
         }
    }
}