import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;

public class MainClass {
        static WebDriver driver;
        @BeforeAll
        public static void start(){
            ChromeOptions options = new ChromeOptions();                                //Chrome
            options.addArguments("--start-maximized","--start-in-incognito");           //Chrome command options
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //FirefoxOptions options = new FirefoxOptions();                            //Firefox
            //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");     //версия Firefox стандарт
            //options.setBrowserVersion("111");                                         //версия Firefox Nightly
            //options.addArguments("-private");                                         //Firefox command option
            //driver = new FirefoxDriver(options);
        }
        @AfterAll
        public static void stop(){
        driver.quit();
        driver = null;
    }
}
