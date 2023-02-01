import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class FirstTest {
    private static WebDriver driver;
    @BeforeAll
    public static void start(){
        driver = new ChromeDriver();
    }
    @Test
    public void firstTest(){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
    @AfterAll
    public static void stop(){
        driver.quit();
        driver = null;
    }
}
