import org.openqa.selenium.By;
public class CartPage extends Driver {
    public static void pressCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
}
