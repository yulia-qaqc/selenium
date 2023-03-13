import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CartActions extends DriverClass {
    @Test
    public void cartTest() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver.findElements(By.cssSelector("li[class*='product column']"));
        for (int j = 0; j < 3; j++) {
            WebElement item = items.get(j);
            item.click();
            // получить значение счетчика товаров
            String quantity = driver.findElement(By.cssSelector("div#cart span.quantity")).getAttribute("textContent");
            // если на странице присутствует select size
            try {
                WebElement select = driver.findElement(By.cssSelector("select[name='options[Size]']"));
                Select s = new Select(select);
                WebElement selectWE = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name*=Size] [value*=M]")));
                s.selectByIndex(2);
            } catch (NoSuchElementException ex) {
                System.out.println("Отсутствует селект size на данной странице");
            }
            // добавить товар в корзину
            driver.findElement(By.cssSelector("button[name*='add_cart'][value]")).click();
            // подождать, пока счётчик товаров в корзине обновится
            boolean itemsQuantityNew = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                    .not(attributeContains(By.cssSelector("div#cart span.quantity"), "textContent", quantity)));
            driver.get("http://localhost/litecart/en/");
            items = driver.findElements(By.cssSelector("li[class*='product column']"));
        }
        // открыть корзину
        driver.findElement(By.cssSelector("div#cart a.link")).click();
        // удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
        List<WebElement> shortcuts =  driver.findElements(By.cssSelector("ul.shortcuts a"));
        // определить количество уникальных товаров
        int shortcutsCount = shortcuts.size();
        if (shortcutsCount == 3) {
            for (int i = 0; i <= 2; i++) {
                WebElement table = driver.findElement(By.cssSelector("table[class*='dataTable'] tbody"));
                driver.findElement(By.cssSelector("li.item button[name=remove_cart_item]")).click();
                boolean tableNew = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.stalenessOf(table));
            }
        }
        else if (shortcutsCount == 2) {
            for (int i = 0; i <= 1; i++) {
                WebElement table = driver.findElement(By.cssSelector("table[class*='dataTable'] tbody"));
                driver.findElement(By.cssSelector("li.item button[name=remove_cart_item]")).click();
                boolean tableNew = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.stalenessOf(table));
            }
        }
        else if (shortcutsCount == 1) {
            WebElement table = driver.findElement(By.cssSelector("table[class*='dataTable'] tbody"));
            driver.findElement(By.cssSelector("li.item button[name=remove_cart_item]")).click();
            boolean tableNew = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.stalenessOf(table));
        }
        // проверить, что все товары в корзине удалены
        String noItems = driver.findElement(By.cssSelector("td.content p")).getAttribute("textContent");
        assertEquals("There are no items in your cart.",noItems);
    }
}
