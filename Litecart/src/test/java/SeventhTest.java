import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SeventhTest extends MainClass {
    @Test
    public void cartTest() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver.findElements(By.cssSelector("li[class*='product column']"));
        for (int j = 0; j < 3; j++) {
            WebElement item = items.get(j);
            item.click();
            // получить значение счетчика товаров
            String i = driver.findElement(By.cssSelector("div#cart span.quantity")).getAttribute("textContent");
            // если на странице присутствует select size
            try {
                WebElement select = driver.findElement(By.cssSelector("select[name='options[Size]']"));
                Select s = new Select(select);
                WebElement S = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name*=Size] [value*=M]")));
                s.selectByIndex(2);
            } catch (NoSuchElementException ex) {
                System.out.println("Отсутствует селект size на данной странице");
            }
            // добавить товар в корзину
            driver.findElement(By.cssSelector("button[name*='add_cart'][value]")).click();
            // подождать, пока счётчик товаров в корзине обновится
            boolean itemsCountNew = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                    .not(attributeContains(By.cssSelector("div#cart span.quantity"), "textContent", i)));
            driver.get("http://localhost/litecart/en/");
            items = driver.findElements(By.cssSelector("li[class*='product column']"));
        }
        // открыть корзину
        driver.findElement(By.cssSelector("div#cart a.link")).click();
        //удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
        WebElement itemCart = driver.findElement(By.cssSelector("button[value=Remove]"));
            for (int g = 0; g < 3; g++) {
                try {
                    driver.findElement(By.cssSelector("li.shortcut")).click();
                    itemCart.click();
                    WebElement table = driver.findElement(By.cssSelector("table[class*='dataTable']"));
                    boolean tableNew = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                            .stalenessOf(table));
                    itemCart = driver.findElement(By.cssSelector("button[value=Remove]"));
                } catch (NoSuchElementException ex) {
                    System.out.println("Отсутствует shortcut на данной странице");
                }
            }
    }
}