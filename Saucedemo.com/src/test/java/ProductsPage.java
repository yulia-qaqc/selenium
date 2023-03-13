import org.openqa.selenium.By;

public class ProductsPage extends Driver{
    public static void addFirstProductIntoCart(){
        driver.findElement(By.xpath("//button[contains(@name,'add-to-cart')]")).click();
    }
    public static void openCart(){
        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
    }
}
