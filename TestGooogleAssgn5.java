package anudip.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
Lab Exercise 1: 
A user wants to search for "java thread life cycle" in Google. You need to 
automate selecting the suggestion from the search bar. 
Exercise: 
● Open Google. 
● Type ""java thread". 
● Select "java thread life cycle" from the auto-suggestions.
 */
public class TestGooogleAssgn5 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriver driver =new ChromeDriver();
  	  // Open Google
      driver.get("https://www.google.com/");

      // Locate the search box and enter text
      WebElement searchBox = driver.findElement(By.name("q"));
      searchBox.sendKeys("java thread");

      // Wait for suggestions to appear
      Thread.sleep(1000);  // Using Thread.sleep() instead of explicit wait

      // Capture the list of suggestions
      List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

      // Iterate and select the desired suggestion
      for (WebElement suggestion : suggestions) {
          if (suggestion.getText().contains("life cycle")) {
              suggestion.click();
              break;
          }
      }
    }
}