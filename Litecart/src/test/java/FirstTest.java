import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstTest extends MainClass {
    // Сценарий проверяет, что у каждого товара имеется ровно один стикер div[class*='sticker']
    @Test
    public void FirstTest() {
        driver.get("http://localhost/litecart/en/");
        // Блок Most Popular
        List<WebElement> item1 = driver
                .findElements(By.cssSelector("div.box[id='box-most-popular'] a.link[title='Blue Duck'] div[class*='sticker']"));
        if (item1.toArray().length == 1) {
            System.out.print("Most Popular. Элемент 1. Проверка пройдена\n");
        }
        else {
            System.out.print("Most Popular. Элемент 1. Ошибка\n");
        }
        List<WebElement> item2 = driver
                .findElements(By.cssSelector("div.box[id='box-most-popular'] a.link[title='Purple Duck'] div[class*='sticker']"));
        if (item2.toArray().length == 1) {
            System.out.print("Most Popular. Элемент 2. Проверка пройдена\n");
        }
        else {
            System.out.print("Most Popular. Элемент 2. Ошибка\n");
        }
        List<WebElement> item3 = driver
                .findElements(By.cssSelector("div.box[id='box-most-popular'] a.link[title='Red Duck'] div[class*='sticker']"));
        if (item3.toArray().length == 1) {
            System.out.print("Most Popular. Элемент 3. Проверка пройдена\n");
        }
        else {
            System.out.print("Most Popular. Элемент 3. Ошибка\n");
        }
        List<WebElement> item4 = driver
                .findElements(By.cssSelector("div.box[id='box-most-popular'] a.link[title='Green Duck'] div[class*='sticker']"));
        if (item4.toArray().length == 1) {
            System.out.print("Most Popular. Элемент 4. Проверка пройдена\n");
        }
        else {
            System.out.print("Most Popular. Элемент 4. Ошибка\n");
        }
        List<WebElement> item5 = driver
                .findElements(By.cssSelector("div.box[id='box-most-popular'] a.link[title='Yellow Duck'] div[class*='sticker']"));
        if (item5.toArray().length == 1) {
            System.out.print("Most Popular. Элемент 5. Проверка пройдена\n");
        }
        else {
            System.out.print("Most Popular. Элемент 5. Ошибка\n");
        }
        // Блок Campaigns
        List<WebElement> item6 = driver
                .findElements(By.cssSelector("div.box[id='box-campaigns'] a.link[title='Yellow Duck'] div[class*='sticker']"));
        if (item6.toArray().length == 1) {
            System.out.print("Campaigns. Элемент 1. Проверка пройдена\n");
        }
        else {
            System.out.print("Campaigns. Элемент 1. Ошибка\n");
        }
        // Блок Latest Products
        List<WebElement> item7 = driver
                .findElements(By.cssSelector("div.box[id='box-latest-products'] a.link[title='Yellow Duck'] div[class*='sticker']"));
        if (item7.toArray().length == 1) {
            System.out.print("Latest Products. Элемент 1. Проверка пройдена\n");
        }
        else {
            System.out.print("Latest Products. Элемент 1. Ошибка\n");
        }
        List<WebElement> item8 = driver
                .findElements(By.cssSelector("div.box[id='box-latest-products'] a.link[title='Green Duck'] div[class*='sticker']"));
        if (item8.toArray().length == 1) {
            System.out.print("Latest Products. Элемент 2. Проверка пройдена\n");
        }
        else {
            System.out.print("Latest Products. Элемент 2. Ошибка\n");
        }
        List<WebElement> item9 = driver
                .findElements(By.cssSelector("div.box[id='box-latest-products'] a.link[title='Red Duck'] div[class*='sticker']"));
        if (item9.toArray().length == 1) {
            System.out.print("Latest Products. Элемент 3. Проверка пройдена\n");
        }
        else {
            System.out.print("Latest Products. Элемент 3. Ошибка\n");
        }
        List<WebElement> item10 = driver
                .findElements(By.cssSelector("div.box[id='box-latest-products'] a.link[title='Blue Duck'] div[class*='sticker']"));
        if (item10.toArray().length == 1) {
            System.out.print("Latest Products. Элемент 4. Проверка пройдена\n");
        }
        else {
            System.out.print("Latest Products. Элемент 4. Ошибка\n");
        }
        List<WebElement> item11 = driver
                .findElements(By.cssSelector("div.box[id='box-latest-products'] a.link[title='Purple Duck'] div[class*='sticker']"));
        if (item11.toArray().length == 1) {
            System.out.print("Latest Products. Элемент 5. Проверка пройдена\n");
        }
        else {
            System.out.print("Latest Products. Элемент 5. Ошибка\n");
        }
    }
}
