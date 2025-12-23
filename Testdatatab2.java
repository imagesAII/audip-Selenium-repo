package anudip.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testdatatab2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://qavbox.github.io/demo/webtable/");
        driver.manage().window().maximize();

        // Get all rows of the second table
        WebElement table = driver.findElement(By.id("table02"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // List to store names (column 1) and full rows
        List<String> names = new ArrayList<>();
        List<String> fullRows = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() > 0) {
                String name = cols.get(0).getText().trim();
                names.add(name);

                // store full row as tab-separated string
                String fullRow = cols.get(0).getText().trim() + "\t" +
                                 cols.get(1).getText().trim() + "\t" +
                                 cols.get(2).getText().trim() + "\t" +
                                 cols.get(3).getText().trim();
                fullRows.add(fullRow);
            }
        }

        System.out.println("All Employee Names (Original):");
        names.forEach(n -> System.out.println("Employee name: " + n));

        System.out.println("=======");

        // Sort names
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());

        System.out.println("All Employee Names (Sorted):");
        sortedNames.forEach(n -> System.out.println("Employee name: " + n));

        // Compare original vs sorted
        if (names.equals(sortedNames)) {
            System.out.println("Names are sorted.");
        } else {
            System.out.println("Names are not sorted.");
        }

        System.out.println("\nTokyo Office Employees are:");

        // Filter Tokyo employees using full rows
        List<String> tokyoEmployees = fullRows.stream()
            .map(row -> row.split("\t"))                                      // split by tab
            .filter(cols -> cols.length > 2)                                  // ensure row has enough columns
            .filter(cols -> cols[2].trim().equalsIgnoreCase("Tokyo"))         // office column
            .map(cols -> "Employee Name: " + cols[0].trim() + " works in Tokyo office.") // intro format
            .toList();

        tokyoEmployees.forEach(System.out::println);

        driver.quit();
    }
}
