package anudip.assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestPaggingStudent {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

        String lastRowText = ""; // to track last row

        while (true) {

            // Find all rows fresh
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class='col-sm-12']//table//tbody/tr"));

            // Get text of the last row
            String currentLastRow = rows.get(rows.size() - 1).getText().trim();

            // Stop if last row is same as previous iteration (end reached)
            if (currentLastRow.equals(lastRowText)) {
                break;
            }
            lastRowText = currentLastRow;

            // Print student names
            for (WebElement row : rows) {
                List<WebElement> cols = row.findElements(By.tagName("td"));
                if (!cols.isEmpty()) {
                    System.out.println(cols.get(0).getText().trim());
                }
            }

            // Click Next button
            WebElement nextBtn = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
            Actions act = new Actions(driver);
            act.moveToElement(nextBtn).click().perform();

            // Wait for table to refresh
            Thread.sleep(1000);
        }

        driver.quit();
    }
}
