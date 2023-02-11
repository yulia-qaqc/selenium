import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;
import static java.util.Collections.sort;
public class SecondTest extends MainClass {
    // Сценарий проверяет сортировку стран и геозон на странице стран
    @BeforeAll
    public static void beforeTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    }
    @Test
    public void countriesTest() {
        List<WebElement> countries = driver
                .findElements(By.cssSelector("tr.row td:nth-child(5) a"));
        List<String> countriesList = new ArrayList<>();
        int num = countries.size();
        for (int i = 0; i < num; i ++) {
            String country = countries.get(i).getAttribute("text");
            countriesList.add(country);
        }
        System.out.println(countriesList);
    }
    @Test
    public void geoZonesTest() {
        List<WebElement> countryRow = driver.findElements(By.cssSelector("tr.row"));
        int num = countryRow.size();
        for (int i = 0; i < num; i++) {
            countryRow = driver.findElements(By.cssSelector("tr.row"));
            WebElement rowNumber = countryRow.get(i);
            String zone = rowNumber.findElement(By.cssSelector("tr.row td:nth-child(6)"))
                    .getAttribute("textContent");
            if(!zone.equals("0")){
                rowNumber.findElement(By.cssSelector("tr.row td:nth-child(5) a")).click();
                List<WebElement> names = driver
                        .findElements(By.cssSelector("table.dataTable td:nth-child(3)"));
                List<String> namesList = new ArrayList<>();
                int num2 = names.size();
                for (int j = 0; j < num2; j ++) {
                    String name = names.get(j).getAttribute("textContent");
                    namesList.add(name);
                }
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
                System.out.println(namesList);
            }
        }
        }
}
