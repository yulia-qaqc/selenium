import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirstClass {
    static WebDriver driver;
    @BeforeAll
    public static void start(){
        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");     //версия Firefox стандарт
        //options.setBrowserVersion("111");                                         //версия Firefox Nightly
        options.addArguments("--start-maximized","--start-in-incognito");           //Chrome command options
        //options.addArguments("-private");                                         //Firefox command option
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver(options);
    }
    @AfterAll
    public static void stop(){
        driver.quit();
        driver = null;
    }
}