import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FirstTest extends MainClass {
    @Test
    public void Test() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> listVertical = driver.findElements(By.cssSelector("ul.list-vertical a"));
        Object[] listArray = listVertical.toArray();
        for (int i = 1; i <= listArray.length; i++){
            List<WebElement> listVerticalNew = driver.findElements(By.cssSelector("ul.list-vertical a"));
            (listVerticalNew.get(i)).click();
            if(driver.findElement(By.cssSelector("h1[style='margin-top: 0px;']")) != null){
                System.out.println("Заголовок найден");
            }
            else {System.out.println("Заголовок не найден");
            }
        }
    }
}
