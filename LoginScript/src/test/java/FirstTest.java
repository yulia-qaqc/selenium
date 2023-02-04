import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirstTest {
    static WebDriver driver;
    @BeforeAll
    public static void start(){
        ChromeOptions options = new ChromeOptions();                                //Chrome
        options.addArguments("--start-maximized","--start-in-incognito");           //Chrome command options
        driver = new ChromeDriver(options);

        //FirefoxOptions options = new FirefoxOptions();                            //Firefox
        //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");     //версия Firefox стандарт
        //options.setBrowserVersion("111");                                         //версия Firefox Nightly
        //options.addArguments("-private");                                         //Firefox command option
        //driver = new FirefoxDriver(options);
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
