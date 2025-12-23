package anudip.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSortingalphabetical {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");

        // Locate the table with class "tsc_table_s13"
        WebElement table = driver.findElement(By.className("tsc_table_s13"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        List<String> structureNames = new ArrayList<>();
        List<String> fullRows = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() > 1) {  // ignore header or empty rows
                String name = cols.get(0).getText().trim();       // 1st column
                String country = cols.get(1).getText().trim();    // 2nd column

                structureNames.add(name);

                // Store full row for later filtering
                fullRows.add(name + "\t" + country);
            }
        }

        // 1. Print whether the original list is sorted
        List<String> sortedNames = structureNames.stream()
                .sorted()
                .collect(Collectors.toList());

        if (structureNames.equals(sortedNames)) {
            System.out.println("Structure names are sorted alphabetically.");
        } else {
            System.out.println("Structure names are NOT sorted alphabetically.");
        }

        // 2. Print all structure names
        System.out.println("\nAll Structure Names:");
        structureNames.forEach(System.out::println);

        // 3. Filter and print structures from UAE
        System.out.println("\nStructures from UAE:");
        List<String> uaeStructures = fullRows.stream()
                .map(row -> row.split("\t"))
                .filter(cols -> cols.length > 1)
                .filter(cols -> cols[1].equalsIgnoreCase("UAE"))
                .map(cols -> cols[0])  // structure name
                .collect(Collectors.toList());

        uaeStructures.forEach(System.out::println);

        driver.quit();
    }
}
