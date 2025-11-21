package anudip.assignments;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingTest 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	 WebDriver driver = new ChromeDriver();
         
         // Maximize window
         driver.manage().window().maximize();
         System.out.println("Browser window maximized.");
         
         // Navigate to Bing
         driver.get("https://www.bing.com");
         System.out.println("Opened Bing homepage.");
         
         // Navigate to Wikipedia
         driver.navigate().to("https://www.wikipedia.org");
         System.out.println("Navigated to Wikipedia.");
         
         // Go back to Bing
         driver.navigate().back();
         System.out.println("Navigated back to Bing.");
         
         // Move forward to Wikipedia
         driver.navigate().forward();
         System.out.println("Navigated forward to Wikipedia.");
         
         // Refresh the page
         driver.navigate().refresh();
         System.out.println("Page refreshed.");
         
         // Resize the browser window
         driver.manage().window().setSize(new Dimension(800, 600));
         System.out.println("Browser window resized to 800x600.");
         
    }
}
