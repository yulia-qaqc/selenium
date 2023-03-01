import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class AdminMenu {
        static WebDriver driver;
        @BeforeAll
        public static void start(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized","--start-in-incognito");           //Chrome command options
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //FirefoxOptions options = new FirefoxOptions();
            //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");     //версия Firefox стандарт
            //options.setBrowserVersion("111");                                         //версия Firefox Nightly
            //options.addArguments("-private");                                         //Firefox command option
            //driver = new FirefoxDriver(options);
        }
    @Test
    public void adminMenuTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> listVertical = driver
                .findElements(By.cssSelector("ul.list-vertical a span:nth-child(2)"));
        int num = listVertical.size();
        for (int i = 0; i < num; i++){
            List<WebElement> listVerticalNew = driver
                    .findElements(By.cssSelector("ul.list-vertical a span:nth-child(2)"));
            (listVerticalNew.get(i)).click();
            if(driver.findElement(By.cssSelector("h1[style='margin-top: 0px;']")) != null){
                System.out.println("Заголовок найден. Пункт основного меню "+ (i + 1));
            }
            else {System.out.println("Заголовок не найден. Пункт основного меню "+ (i + 1));
            }
            List<WebElement> InnerlistVertical = driver
                    .findElements(By.cssSelector("li.selected span.name:nth-child(1)"));
            int num2 = InnerlistVertical.size();
            if(num2 > 0){
                for (int j = 0; j < num2; j++){
                    List<WebElement> InnerlistVerticalNew = driver
                            .findElements(By.cssSelector("li.selected span.name:nth-child(1)"));
                    (InnerlistVerticalNew.get(j)).click();
                    if(driver.findElement(By.cssSelector("h1[style='margin-top: 0px;']")) != null){
                        System.out.println("Заголовок найден. Пункт меню второго уровня " + (j + 1));
                    }
                    else {System.out.println("Заголовок не найден. Пункт меню второго уровня " + (j + 1));
                    }
                }
            }
        }
    }
        @AfterAll
        public static void stop(){
        driver.quit();
        driver = null;
    }
}
