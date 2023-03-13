import org.openqa.selenium.By;
public class LoginPage extends Driver {
    public static void authorizationSuccessful(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[class*='submit']")).click();
    }
    public static void authorizationFailed(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("test");
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("test");
        driver.findElement(By.cssSelector("input[class*='submit']")).click();
    }
}
