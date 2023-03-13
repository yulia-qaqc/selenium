import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Driver {
    static WebDriver driver;
    @BeforeAll
    public static void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--start-in-incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterAll
    public static void stop(){
        driver.quit();
        driver = null;
    }
}