import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestLogin {
    static WebDriver driver;
    @BeforeAll
    public static void start(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","--start-in-incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void testLogin(){
        driver.get("https://www.livejournal.com/");
        // авторизация
        driver.findElement(By.cssSelector("ul.s-do a[class*=login]")).click();
        driver.findElement(By.cssSelector("input#user")).sendKeys("yourLogin");
        driver.findElement(By.cssSelector("input[id*=password]")).sendKeys("yourPassword");
        driver.findElement(By.cssSelector("button[name='action:login']")).click();
        // опубликовать post
        WebElement buttonPost = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.s-header-item-post")));
        driver.findElement(By.cssSelector("li.s-header-item-post")).click();
        driver.findElement(By.cssSelector("div textarea")).sendKeys("Test post");
        driver.findElement(By.cssSelector("div[data-offset-key]")).sendKeys("Have a nice day!");
        driver.findElement(By.xpath("//span[text()='Tune in and publish']")).click();
        WebElement buttonPublish = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("div[class*='submissionPopup'] span.rootIn-0-2-98")));
        driver.findElement(By.cssSelector("div[class*='submissionPopup'] span.rootIn-0-2-98")).click();
    }
    @AfterAll
    public static void stop(){
        driver.quit();
        driver = null;
    }
}


