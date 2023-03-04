import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;

public class ProductPage {
    public static String cartCounter() { // получить значение счетчика товаров в корзине
        return DriverClass.driver.findElement(By.cssSelector("div#cart span.quantity")).getAttribute("textContent");
    }
    public static void fillSelectsSize(){
        try {
            WebElement selectSize = DriverClass.driver.findElement(By.cssSelector("select[name='options[Size]']"));
            Select select = new Select(selectSize);
            WebElement selectWE = new WebDriverWait(DriverClass.driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name*=Size] [value*=M]")));
            select.selectByIndex(2);
        } catch (NoSuchElementException ex) {
            System.out.println("Отсутствует селект size на данной странице");
        }
    }
    public static void addProductIntoCart(){
        DriverClass.driver.findElement(By.cssSelector("button[name*='add_cart'][value]")).click();
    }
    public static void waitNewCartCounter(){
        boolean NewCartCounter = new WebDriverWait(DriverClass.driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .not(attributeContains(By.cssSelector("div#cart span.quantity"),
                        "textContent", ProductPage.cartCounter())));
    }
    public static void openCart(){
        DriverClass.driver.findElement(By.cssSelector("div#cart a.link")).click();
    }
}
