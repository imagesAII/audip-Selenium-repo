package anudip.assignments;

import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakessofInput {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        // 1. Open the first URL
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();

        // Store parent window
        String parentWindow = driver.getWindowHandle();

        // 2. Open new browser window
        driver.switchTo().newWindow(WindowType.WINDOW);

        // 3. Navigate to second URL
        driver.get("https://rahulshettyacademy.com/");

        // 4. Extract the second course name (links containing pattern)
        List<WebElement> courses = driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]"));

        String secondCourseName = courses.get(1).getText(); // second course
        System.out.println("Extracted Course: " + secondCourseName);

        // 5. Switch back to the original window
        driver.switchTo().window(parentWindow);

        // 6. Input field with name='name'
        WebElement inputField = driver.findElement(By.name("name"));
        inputField.sendKeys(secondCourseName);

        // 7. Screenshot ONLY the input field → save as logo.png
        File src = inputField.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/screenshots/logo.png");
        src.renameTo(dest);

        // 8. Print height and width of the input field
        BufferedImage image = ImageIO.read(dest);
        int width = image.getWidth();
        int height = image.getHeight();

        System.out.println("Input Field Screenshot Width : " + width);
        System.out.println("Input Field Screenshot Height: " + height);

        driver.quit();
    }
}
