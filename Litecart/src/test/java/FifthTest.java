import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
public class FifthTest extends MainClass {
    @Test
    // Сценарий регистрации нового пользователя в приложении litecart (для клиентов)
    public void loginTest() {
        driver.get("http://localhost/litecart/en/");
        Random random = new Random();
        String email = random.nextInt(0,100000) + "@test.com";
        //регистрация нового пользователя
        driver.findElement(By.cssSelector("div#box-account-login td a")).click();
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Ludovico");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("Einaudi");
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys("1556 Broadway, suite 416");
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys("10120");
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys("New York");
        // инициализация объекта класса Select
        Select s1 = new Select(driver.findElement(By.cssSelector("select[name=country_code]")));
        // явное ожидание
        WebElement US = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value=US]")));
        // выбор элемента select country, выбрать United States
        s1.selectByValue("US");
        //s1.selectByIndex(224);
        // выбор элемента select zone, выбрать New York
        Select s2 = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        WebElement NY = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value=NY]")));
        s2.selectByValue("NY");
        //s2.selectByIndex(42);
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys("+13150000000");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("q1w1a1s1");
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys("q1w1a1s1");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.cssSelector("aside#navigation [href*=logout]")).click();
        //повторный вход в только что созданную учётную запись
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("q1w1a1s1");
        driver.findElement(By.cssSelector("button[name=login]")).click();
        //повторный выход
        driver.findElement(By.cssSelector("aside#navigation [href*=logout]")).click();
    }
}
