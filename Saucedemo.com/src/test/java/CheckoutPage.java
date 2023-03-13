import org.openqa.selenium.By;

public class CheckoutPage extends Driver {
    public static void fillCheckoutInfo() {
        driver.findElement(By.id("first-name")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("test");
        driver.findElement(By.cssSelector("[data-test='postalCode']")).sendKeys("test");
        driver.findElement(By.cssSelector("[class*='submit-button']")).click();
        driver.findElement(By.id("finish")).click();
    }
    public static String getUrl() {
        return driver.getCurrentUrl();
    }
    public static String getInfoText() {
        return driver.findElement(By.cssSelector("h2.complete-header")).getAttribute("textContent");
    }
}
