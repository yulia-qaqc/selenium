import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    public static void deleteProducts(){
        List<WebElement> shortcuts =  DriverClass.driver.findElements(By.cssSelector("ul.shortcuts a"));
        // определить количество уникальных товаров
        int shortcutsCount = shortcuts.size();
        if (shortcutsCount == 3) {
            for (int i = 0; i <= 2; i++) {
                WebElement table = DriverClass.driver.findElement(By.cssSelector("table[class*='dataTable'] tbody"));
                DriverClass.driver.findElement(By.cssSelector("li.item button[name=remove_cart_item]")).click();
                boolean tableNew = new WebDriverWait(DriverClass.driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.stalenessOf(table));
            }
        }
        else if (shortcutsCount == 2) {
            for (int i = 0; i <= 1; i++) {
                WebElement table = DriverClass.driver.findElement(By.cssSelector("table[class*='dataTable'] tbody"));
                DriverClass.driver.findElement(By.cssSelector("li.item button[name=remove_cart_item]")).click();
                boolean tableNew = new WebDriverWait(DriverClass.driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.stalenessOf(table));
            }
        }
        else if (shortcutsCount == 1) {
            WebElement table = DriverClass.driver.findElement(By.cssSelector("table[class*='dataTable'] tbody"));
            DriverClass.driver.findElement(By.cssSelector("li.item button[name=remove_cart_item]")).click();
            boolean tableNew = new WebDriverWait(DriverClass.driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.stalenessOf(table));
        }
    }
    public static void checkProductsDeletion(){
        String noItems = DriverClass.driver.findElement(By.cssSelector("td.content p")).getAttribute("textContent");
        if (noItems.equals("There are no items in your cart.")) {
            System.out.println("Все товары в корзине удалены");
        }
    }
}
