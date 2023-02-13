import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
public class ThirdTest extends MainClass {
    @BeforeAll
    public static void beforeTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }
    @Test
    //Проверка сортировки геозон на странице геозон
    public void geoZonesTest() {
        List<WebElement> geoZones = driver
                .findElements(By.cssSelector("tr.row td:nth-child(3) a"));
        int num = geoZones.size();
        for (int i = 0; i < num; i++) {
            geoZones.get(i).click();
            List<WebElement> zones = driver
                    .findElements(By.cssSelector("select[name*=zone_code] [selected]"));
            List<String> zonesList = new ArrayList<>();
            for (WebElement webElement : zones) {
                String zone = webElement.getAttribute("textContent");
                zonesList.add(zone);
            }
            List<String> zonesListSorted = new ArrayList<>(zonesList);
            zonesListSorted.sort(Comparator.naturalOrder());
            boolean isEqual = Objects.equals(zonesList,zonesListSorted);
            if (isEqual) {
                System.out.println("Зоны отсортированы в алфавитном порядке");
            }
            else {
                System.out.println("Ошибка сортировки");
            }
            System.out.println(zonesList);
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            geoZones = driver
                    .findElements(By.cssSelector("tr.row td:nth-child(3) a"));
        }
    }
}
