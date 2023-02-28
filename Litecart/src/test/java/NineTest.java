import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;

import java.time.Duration;
import java.util.List;

public class NineTest {
    static WebDriver driver;
    @BeforeAll
    public static void start(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","--start-in-incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void logsTest() {
        // авторизация
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        // открыть каталог, категорию, которая содержит товары
        driver.findElement(By.cssSelector("a[href*='doc=catalog']")).click();
        driver.findElement(By.cssSelector("a[href*='category_id=1']")).click();
        // список товаров
        List<WebElement> products = driver.findElements(By
                .cssSelector("a[href*='product_id']:not([title='Edit'])"));
        int num = products.size();
        // вывести информацию о логах [browser, driver, client]
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        // последовательно открывать страницы товаров и проверять, не появляются ли в логе браузера сообщения
        for(int i = 0; i < num; i++){
            products.get(i).click();
            List<LogEntry> logs = driver.manage().logs().get("browser").getAll();
            System.out.println("Product " + (i + 1) + " " + logs);
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            products = driver.findElements(By
                    .cssSelector("a[href*='product_id']:not([title='Edit'])"));
        }
    }
    @AfterAll
    public static void stop(){
        driver.quit();
        driver = null;
    }
}

