package anudip.assignments;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSearchWordAndSS {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.wikipedia.org/");	
		
		driver.manage().window().maximize();
		
		WebElement word = driver.findElement(By.xpath("//strong[@class='jsl10n localized-slogan']"));
		
		System.out.println("The copied word is : "+word.getText());
		
		String meaning = word.getText();
		
		driver.get("https://translate.google.com/?sl=auto&tl=en&op=translate");
		
		driver.findElement(By.xpath("//textarea[@aria-label='Source text']")).sendKeys(meaning);
		
		WebElement translate = driver.findElement(By.xpath("//div[@jslog='167510; metadata:W10=; mutable:true;']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(translate).perform();
		
		Thread.sleep(2000);
		
		System.out.println("The translated word is : "+translate.getText());
		
		WebElement inputbox = driver.findElement(By.xpath("//div[@class='n4sEPd']"));
	
		File source = inputbox.getScreenshotAs(OutputType.FILE);
		
		File tagetfile = new File(System.getProperty("user.dir")+"/screenshots/product.png");
		
		source.renameTo(tagetfile);
		
		BufferedImage image = ImageIO.read(tagetfile);

        // Get dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        System.out.println("Screenshot width: " + width);
        System.out.println("Screenshot height: " + height);
		driver.close();
		
	}

}
