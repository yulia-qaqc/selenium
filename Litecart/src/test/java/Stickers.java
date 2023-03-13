import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Stickers extends DriverClass {
    // Сценарий проверяет, что у каждого товара имеется ровно один стикер
    @Test
    public void stickersTest() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver
                .findElements(By.cssSelector("ul.products li"));
        int num = items.size();
        for (int i = 0; i < num; i++) {
            List<WebElement> stickers = items.get(i)
                    .findElements(By.cssSelector("div.sticker"));
            int stickersNum = stickers.size();
            assertEquals(1,stickersNum);
        }
    }
}
