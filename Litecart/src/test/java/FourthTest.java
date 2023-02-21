import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import java.util.List;
public class FourthTest extends MainClass {
    @Test
    // Проверка совпадения текста на главной странице и странице товара
    public void itemTitle() {
        System.out.println("Проверка совпадения текста на главной странице и странице товара");
        driver.get("http://localhost/litecart/en/");
        List<WebElement> items = driver
                .findElements(By.cssSelector("li.product a.link"));
        int num = items.size();
        for (int i = 0; i < num; i++) {
            String title = items.get(i).getAttribute("title");
            items.get(i).click();
            String itemPageTitle = driver.findElement(By.cssSelector("h1.title"))
                    .getAttribute("textContent");
            if (title.equals(itemPageTitle)) {
                System.out.println("Товар " + (i+1) + ". Текст совпадает");
            } else {
                System.out.println("Товар " + (i+1) + ". Ошибка");
            }
            driver.get("http://localhost/litecart/en/");
            items = driver
                    .findElements(By.cssSelector("li.product a.link"));
        }
    }
    @Test
    // Проверка совпадения цен на главной странице и странице товара (обычной и акционной)
    public void itemPrice() {
        System.out.println("Проверка совпадения цен на главной странице и странице товара (обычной и акционной)");
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
                if (priceRegular.equals(priceRegularItemPage)) {
                    System.out.println("Товар " + (i + 1) + ". Цены совпадают");
                } else {
                    System.out.println("Товар " + (i + 1) + ". Ошибка");
                }
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
                if (priceRegular.equals(priceRegularItemPage) && priceCampaign.equals(priceCampaignItemPage)) {
                    System.out.println("Товар " + (i + 1) + ". Цены совпадают");
                } else {
                    System.out.println("Товар " + (i + 1) + ". Ошибка");
                }
                driver.get("http://localhost/litecart/en/");
                items = driver
                        .findElements(By.cssSelector("li.product div.price-wrapper"));
            }
        }
    }
    @Test
    // Тест проверяет, что обычная цена товара зачёркнутая и серая
    public void greyColorPrice() {
        System.out.println("Тест проверяет, что обычная цена товара зачёркнутая и серая");
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
                    if((R == G) & (G == B) & priceRegularCrossedOut.equals("line-through")){
                    System.out.println("Товар " + (i + 1) + ". Обычная цена серая и зачеркнутая");
                    } else {
                    System.out.println("Товар " + (i + 1) + ". Ошибка");
                    }
            }
        }
    }
    @Test
    // Тест проверяет, что акционная цена товара жирная и красная. Для первого товара из блока Campaigns
    public void redColorPrice() {
        System.out.println("Тест проверяет, что акционная цена товара жирная и красная");
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
                if((G == 0) & (B == 0) & boldP >= 700) {
                System.out.println("Главная страница: Акционная цена товара жирная и красная");
                } else {
                System.out.println("Главная страница: Ошибка");
                }
        campaignPrice.click(); // переход на страницу товара
        WebElement campaignPriceItemPage = driver
                .findElement(By.cssSelector("strong.campaign-price"));
        String boldPriceItemPage = campaignPriceItemPage.getCssValue("font-weight");
        int boldIP = Integer.parseInt(boldPriceItemPage);
        Color redPriceItemPage = Color.fromString(campaignPriceItemPage.getCssValue("color"));
        // вывести значения G, B
        int G2 = redPriceItemPage.getColor().getGreen();
        int B2 = redPriceItemPage.getColor().getBlue();
            if((G2 == 0) & (B2 == 0) & boldIP >= 700) {
            System.out.println("Страница товара: Акционная цена товара жирная и красная");
            } else {
            System.out.println("Страница товара: Ошибка");
            }
    }
    @Test
    // Тест проверяет, что шрифт акционной цены крупнее, чем обычной. Для первого товара из блока Campaigns
    public void sizePrice() {
        System.out.println("Проверка размера шрифтов акционной цены и обычной");
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
        if (sizeCampaignPriceD > sizeRegularPriceD){
            System.out.println("Главная страница. Шрифт акционной цены крупнее, чем обычной");
        }
        else {System.out.println("Главная страница. Ошибка");
        }
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
        if (sizeCampaignPriceItemPageD2 > sizeRegularPriceItemPageD2){
            System.out.println("Страница товара. Шрифт акционной цены крупнее, чем обычной");
        }
        else {System.out.println("Страница товара. Ошибка");
        }
    }
}

