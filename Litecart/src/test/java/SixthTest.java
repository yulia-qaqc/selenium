import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.time.Duration;

public class SixthTest extends MainClass{
    @Test
    // Сценарий добавления нового товара в приложении litecart (в админке)
    public void addProductTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        // перейти в Catalog
        driver.findElement(By.cssSelector("ul#box-apps-menu [href*=catalog] span.name")).click();
        driver.findElement(By.cssSelector("[href*=edit_product]")).click();
        // блок General
        driver.findElement(By.cssSelector("input[name=status][value='1']")).click();
        driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("Mandarinka duck");
        driver.findElement(By.cssSelector("input[name='code']")).sendKeys("15");
        driver.findElement(By.cssSelector("[data-name='Rubber Ducks']")).click();
        driver.findElement(By.cssSelector("[data-name='Subcategory']")).click();
        // Default Category
        Select s1 = new Select(driver.findElement(By.cssSelector("select[name='default_category_id']")));
        WebElement S1 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='default_category_id'] [value='1']")));
        s1.selectByValue("1");
        driver.findElement(By.cssSelector("[name='product_groups[]'][value='1-2']")).click();
        // Quantity
        driver.findElement(By.cssSelector("[name='quantity']")).clear();
        driver.findElement(By.cssSelector("[name='quantity']")).sendKeys("7");
        // Quantity Unit
        Select s2 = new Select(driver.findElement(By.cssSelector("select[name='default_category_id']")));
        WebElement S2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='quantity_unit_id'] option[selected='selected']")));
        s2.selectByValue("1");
        // Delivery Status
        Select s3 = new Select(driver.findElement(By.cssSelector("[name='delivery_status_id']")));
        WebElement S3 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='delivery_status_id'] option[selected]")));
        s3.selectByValue("1");
        // Sold Out Status
        Select s4 = new Select(driver.findElement(By.cssSelector("[name='sold_out_status_id']")));
        WebElement S4 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='sold_out_status_id'] option[value='2']")));
        s4.selectByIndex(2);
        // Upload Image
        // преобразовать относительный путь в абсолютный
        Path image = Path.of("C:\\Users\\Юлия\\Desktop\\selenium\\Litecart\\src\\main\\resources\\Mandarinka.jpg")
                .toAbsolutePath();
        String pathString =  image.toString();
        driver.findElement(By.cssSelector("[type='file']")).sendKeys(pathString);
        // Date
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).clear();
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("10052023");
        driver.findElement(By.cssSelector("input[name='date_valid_to']")).clear();
        driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("10052024");
        // блок Information
        driver.findElement(By.cssSelector("[href='#tab-information']")).click();
        Select s5 = new Select(driver.findElement(By.cssSelector("[name='manufacturer_id']")));
        WebElement S5 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='manufacturer_id'] [value='1']")));
        s5.selectByIndex(1);
        Select s6 = new Select(driver.findElement(By.cssSelector("[name='supplier_id']")));
        WebElement S6 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='supplier_id'] [value]")));
        s6.selectByIndex(0);
        driver.findElement(By.cssSelector("[name='keywords']")).sendKeys("Duck");
        driver.findElement(By.cssSelector("[name='short_description[en]']")).sendKeys("Duck");
        // Description
        driver.findElement(By.cssSelector("button.trumbowyg-bold-button")).click();
        driver.findElement(By.cssSelector("button.trumbowyg-justifyCenter-button")).click();
        driver.findElement(By.cssSelector("button[class*='foreColor']")).click();
        driver.findElement(By.cssSelector("button[class*='548dd4']")).click();
        driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("The description");
        driver.findElement(By.cssSelector("[name='head_title[en]']")).sendKeys("The title");
        driver.findElement(By.cssSelector("[name='meta_description[en]']")).sendKeys("The meta description");
        // блок Prices
        driver.findElement(By.cssSelector("[href='#tab-prices']")).click();
        driver.findElement(By.cssSelector("[name='purchase_price']")).clear();
        driver.findElement(By.cssSelector("[name='purchase_price']")).sendKeys("3");
        Select s7 = new Select(driver.findElement(By.cssSelector("[name='purchase_price_currency_code']")));
        WebElement S7 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='purchase_price_currency_code'] [value='USD']")));
        s7.selectByIndex(1);
        driver.findElement(By.cssSelector("[name='prices[USD]']")).sendKeys("5");
        // Save
        driver.findElement(By.cssSelector("button[name=save]")).click();
        // Проверить, что товар появился в каталоге (в админке)
        driver.findElement(By.cssSelector("ul#box-apps-menu [href*=catalog] span.name")).click();
        String name = driver.findElement(By.cssSelector("a[href*='edit_product&category']:not([title='Edit'])")).getAttribute("textContent");
        if(name.equals("Mandarinka duck")){
            System.out.println("Товар добавлен в каталог");
            }
        else{
            System.out.println("Ошибка");
        }
    }
}
