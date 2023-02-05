import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;

public class FirstTest extends FirstClass {
    @Test
    public void firstTest() {
        driver.get("https://www.sela.ru/");
        driver.findElement(By.xpath("//a[@class='js-choice-city-close-popup city-isset']")).click(); // кнопка "да, все верно"
        driver.findElement(By.xpath("//ul[@class='header__user-menu-list']//li[@class='header__user-menu-item'][2]")).click(); // вход в личный кабинет
        driver.findElement(By.xpath("//form[@class='popup-registration__form js-tab-content login-form is-active-tab']//input[@class='popup-registration__input js-email-input']"))
                .sendKeys("email"); // ввести email
        driver.findElement(By.xpath("//form[@class='popup-registration__form js-tab-content login-form is-active-tab']//input[@class='popup-registration__input popup-registration__input--password js-password js-password-input']"))
                .sendKeys("password"); // ввести пароль
        driver.findElement(By.xpath("//button[@class='popup-registration__submit js-submit']")).click(); // кнопка "войти"
        // ожидание загрузки новой страницы, чтобы получить url
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tabs__wrapper js-drop-down']")));
        String currentUrl = driver.getCurrentUrl(); // получить текущий url
        if(Objects.equals(currentUrl, "https://www.sela.ru/eshop/my/orders/")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}
