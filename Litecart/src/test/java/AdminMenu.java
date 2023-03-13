import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class AdminMenu extends DriverClass {
    @Test
    public void scenarioTest() {
        // авторизация в панели администратора
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> listVertical = driver
                .findElements(By.cssSelector("ul.list-vertical a span:nth-child(2)"));
        int num = listVertical.size();
        for (int i = 0; i < num; i++) {
            List<WebElement> listVerticalNew = driver
                    // прокликивать последовательно все пункты меню, включая вложенные пункты
                    .findElements(By.cssSelector("ul.list-vertical a span:nth-child(2)"));
            (listVerticalNew.get(i)).click();
            // для каждой страницы проверить наличие заголовка
            assertNotNull(driver.findElement(By.cssSelector("h1[style='margin-top: 0px;']")));

            List<WebElement> InnerlistVertical = driver
                    .findElements(By.cssSelector("li.selected span.name:nth-child(1)"));
            int num2 = InnerlistVertical.size();
            if (num2 > 0) {
                for (int j = 0; j < num2; j++) {
                    List<WebElement> InnerlistVerticalNew = driver
                            .findElements(By.cssSelector("li.selected span.name:nth-child(1)"));
                    (InnerlistVerticalNew.get(j)).click();
                    assertNotNull(driver.findElement(By.cssSelector("h1[style='margin-top: 0px;']")));
                }
            }
        }
    }
}


