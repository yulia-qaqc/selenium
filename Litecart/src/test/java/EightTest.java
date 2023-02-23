import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Set;
public class EightTest extends MainClass {
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles=driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size()>0 ? handles.iterator().next():null;
            }
        };
    }
    @BeforeEach
    public void loginAdmin() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
    @Test
    public void openNewWindows() {
        // открыть countries
        driver.findElement(By.cssSelector("ul.list-vertical a[href*='countries']")).click();
        // выбрать страну
        driver.findElement(By.xpath("//a[text()='Brazil']")).click();
        // получить id текущего окна
        String mainWindow = driver.getWindowHandle();
        // получить id открытых окон
        Set<String> oldWindows = driver.getWindowHandles();
        System.out.println("Main window id: " + mainWindow);
        // получить links для новых окон
        List<WebElement> links = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
        int count = links.size();
        for (int i = 0; i < count; i++) {
            // открыть новое окно
            links.get(i).click();
            // ждем появления нового окна
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            // переключиться  в новое окно
            driver.switchTo().window(newWindow);
            System.out.println("New window " + (i + 1) + " id: " + newWindow);
            driver.close();
            // возврат в исходное окно
            driver.switchTo().window(mainWindow);
        }
    }
}


