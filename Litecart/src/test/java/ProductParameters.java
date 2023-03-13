import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductParameters extends DriverClass {
    @Test
    // Проверка совпадения текста на главной странице и странице товара
    public void itemTitle() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver
                .findElements(By.cssSelector("li.product a.link"));
        int num = items.size();
        for (int i = 0; i < num; i++) {
            String title = items.get(i).getAttribute("title");
            items.get(i).click();
            String itemPageTitle = driver.findElement(By.cssSelector("h1.title"))
                    .getAttribute("textContent");
            assertEquals(title,itemPageTitle);

            driver.get("http://localhost/litecart/en/");
            items = driver
                    .findElements(By.cssSelector("li.product a.link"));
        }
    }
    @Test
    // Проверка совпадения цен на главной странице и странице товара (обычной и акционной)
    public void itemPrice() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver
                .findElements(By.cssSelector("li.product div.price-wrapper"));
        int num = items.size(); // кол-во товаров
        for (int i = 0; i < num; i++) {
            WebElement item = items.get(i); // конкретный товар
            List<WebElement> prices = item.findElements(By.cssSelector("[class*='price']"));
            int num2 = prices.size();// количество цен для конкретного товара
            if (num2 == 1) {
                String priceRegular = prices.get(0).getAttribute("textContent");
                items.get(i).click();
                String priceRegularItemPage = driver
                        .findElements(By.cssSelector("div[id='box-product'] div.price-wrapper [class*='price']"))
                        .get(0).getAttribute("textContent");
                assertEquals(priceRegular,priceRegularItemPage);

                driver.get("http://localhost/litecart/en/");
                items = driver
                        .findElements(By.cssSelector("li.product div.price-wrapper"));
            } else {
                String priceRegular = prices.get(0).getAttribute("textContent");
                String priceCampaign = prices.get(1).getAttribute("textContent");
                items.get(i).click();
                String priceRegularItemPage = driver
                        .findElements(By.cssSelector("div[id='box-product'] div.price-wrapper [class*='price']"))
                        .get(0).getAttribute("textContent");
                String priceCampaignItemPage = driver
                        .findElements(By.cssSelector("div[id='box-product'] div.price-wrapper [class*='price']"))
                        .get(1).getAttribute("textContent");
                assertEquals(priceRegular,priceRegularItemPage);
                assertEquals(priceCampaign,priceCampaignItemPage);

                driver.get("http://localhost/litecart/en/");
                items = driver
                        .findElements(By.cssSelector("li.product div.price-wrapper"));
            }
        }
    }
    @Test
    // Тест проверяет, что обычная цена товара зачёркнутая и серая
    public void greyColorPrice() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver
                .findElements(By.cssSelector("li.product div.price-wrapper"));
        int num = items.size(); // кол-во товаров
        for (int i = 0; i < num; i++) {
            WebElement item = items.get(i); // конкретный товар
            List<WebElement> prices = item.findElements(By.cssSelector("[class*='price']"));
            int num2 = prices.size();// количество цен для конкретного товара
            if (num2 == 2) {
                String priceRegularCrossedOut = prices.get(0).getCssValue("text-decoration-line");
                Color priceRegularColorRgba = Color.fromString(prices.get(0).getCssValue("color"));
                //Color: rgba(119, 119, 119, 1)
                // вывести значения R, G, B
                int R = priceRegularColorRgba.getColor().getRed();
                int G = priceRegularColorRgba.getColor().getGreen();
                int B = priceRegularColorRgba.getColor().getBlue();

                assertEquals(R,G);
                assertEquals(G,B);
                assertEquals("line-through",priceRegularCrossedOut);
            }
        }
    }
    @Test
    // Тест проверяет, что акционная цена товара жирная и красная. Для первого товара из блока Campaigns
    public void redColorPrice() {
        driver.get("http://localhost/litecart/en/");
        WebElement campaignPrice = driver
                .findElement(By.cssSelector("div[id='box-campaigns'] strong"));
        String boldPrice = campaignPrice.getCssValue("font-weight");
        int boldP = Integer.parseInt(boldPrice);
        Color redPriceRgba = Color.fromString(campaignPrice.getCssValue("color"));
        //Color: rgba(204, 0, 0, 1)
        // вывести значения G, B
        int G = redPriceRgba.getColor().getGreen();
        int B = redPriceRgba.getColor().getBlue();
        assertEquals(0,G);
        assertEquals(0,B);
        assertTrue(boldP >= 700);

        campaignPrice.click(); // переход на страницу товара
        WebElement campaignPriceItemPage = driver
                .findElement(By.cssSelector("strong.campaign-price"));
        String boldPriceItemPage = campaignPriceItemPage.getCssValue("font-weight");
        int boldIP = Integer.parseInt(boldPriceItemPage);
        Color redPriceItemPage = Color.fromString(campaignPriceItemPage.getCssValue("color"));
        // вывести значения G, B
        int G2 = redPriceItemPage.getColor().getGreen();
        int B2 = redPriceItemPage.getColor().getBlue();
        assertEquals(0,G2);
        assertEquals(0,B2);
        assertTrue(boldIP >= 700);
    }
    @Test
    // Тест проверяет, что шрифт акционной цены крупнее, чем обычной. Для первого товара из блока Campaigns
    public void sizePrice() {
        driver.get("http://localhost/litecart/en/");
        WebElement regularPrice = driver
                .findElement(By.cssSelector("div[id='box-campaigns'] s"));
        WebElement campaignPrice = driver
                .findElement(By.cssSelector("div[id='box-campaigns'] strong"));
        String sizeRegularPrice = regularPrice
                .getCssValue("font-size");
        String sizeCampaignPrice = campaignPrice
                .getCssValue("font-size");
        double sizeRegularPriceD = Double
                .parseDouble(sizeRegularPrice.replace("px",""));
        double sizeCampaignPriceD = Double
                .parseDouble(sizeCampaignPrice.replace("px",""));

        assertTrue(sizeCampaignPriceD > sizeRegularPriceD);
        //переход на страницу товара
        driver.findElement(By.cssSelector("div[id='box-campaigns'] li.product")).click();
        WebElement regularPriceItemPage = driver
                .findElement(By.cssSelector("s.regular-price"));
        WebElement campaignPriceItemPage = driver
                .findElement(By.cssSelector("strong.campaign-price"));
        String sizeRegularPriceItemPage = regularPriceItemPage
                .getCssValue("font-size");
        String sizeCampaignPriceItemPage = campaignPriceItemPage
                .getCssValue("font-size");
        double sizeRegularPriceItemPageD2 = Double
                .parseDouble(sizeRegularPriceItemPage.replace("px",""));
        double sizeCampaignPriceItemPageD2 = Double
                .parseDouble(sizeCampaignPriceItemPage.replace("px",""));

        assertTrue(sizeCampaignPriceItemPageD2 > sizeRegularPriceItemPageD2);
    }
}

