import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class FirstTest extends MainClass {
    // Сценарий проверяет, что у каждого товара имеется ровно один стикер
    @Test
    public void stickersTest() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver.findElements(By.cssSelector("div.image-wrapper"));
        int num = items.size();
        for (int i = 0; i < num; i++) {
            (items.get(i)).click();
            List<WebElement> stickers = driver
                    .findElements(By.cssSelector("div[id='box-product']  div[class*='sticker']"));
            int x = stickers.size();
            if (x == 1) {
                System.out.println("У товара один стикер");
            }
            else {System.out.println("Ошибка");
            }
            driver.get("http://localhost/litecart/en/");
            items = driver.findElements(By.cssSelector("div.image-wrapper"));
        }
    }
}
