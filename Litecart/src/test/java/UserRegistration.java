import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
public class UserRegistration extends DriverClass {
    @Test
    // Сценарий регистрации нового пользователя в приложении litecart (для клиентов)
    public void registrationTest() {
        driver.get("http://localhost/litecart/en/");
        Random random = new Random();
        String email = random.nextInt(0,100000) + "@test.com";
        //регистрация нового пользователя
        driver.findElement(By.cssSelector("div#box-account-login td a"))
                .click();
        driver.findElement(By.cssSelector("input[name=firstname]"))
                .sendKeys("Ludovico");
        driver.findElement(By.cssSelector("input[name=lastname]"))
                .sendKeys("Einaudi");
        driver.findElement(By.cssSelector("input[name=address1]"))
                .sendKeys("1556 Broadway, suite 416");
        driver.findElement(By.cssSelector("input[name=postcode]"))
                .sendKeys("10120");
        driver.findElement(By.cssSelector("input[name=city]"))
                .sendKeys("New York");
        // выбор элемента select country, выбрать United States
        driver.findElement(By.cssSelector("span[class*='select2-container']"))
                .click();
        driver.findElement(By.cssSelector("input.select2-search__field"))
                .sendKeys("Un");
        WebElement US = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//li[contains(text(),'United States')]")));
        driver.findElement(By.xpath("//li[contains(text(),'United States')]"))
                .click();
        // инициализация объекта класса Select
        Select s = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        // выбор элемента select zone, выбрать New York
        WebElement NY = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value=NY]")));
        s.selectByValue("NY");
        driver.findElement(By.cssSelector("input[name=email]"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("input[name=phone]"))
                .sendKeys("+13150000000");
        driver.findElement(By.cssSelector("input[name=password]"))
                .sendKeys("q1w1a1s1");
        driver.findElement(By.cssSelector("input[name=confirmed_password]"))
                .sendKeys("q1w1a1s1");
        driver.findElement(By.cssSelector("button[type=submit]"))
                .click();
        driver.findElement(By.cssSelector("aside#navigation [href*=logout]"))
                .click();
        //повторный вход в только что созданную учётную запись
        driver.findElement(By.cssSelector("input[name=email]"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("input[name=password]"))
                .sendKeys("q1w1a1s1");
        driver.findElement(By.cssSelector("button[name=login]"))
                .click();
        //повторный выход
        driver.findElement(By.cssSelector("aside#navigation [href*=logout]"))
                .click();
    }
}
