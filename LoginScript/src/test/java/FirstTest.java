import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class FirstTest extends MainClass {
    @Test
    public void Test() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> listVertical = driver
                .findElements(By.cssSelector("ul.list-vertical a span:nth-child(2)"));
        int num = listVertical.size();
        for (int i = 0; i < num; i++){
            List<WebElement> listVerticalNew = driver
                    .findElements(By.cssSelector("ul.list-vertical a span:nth-child(2)"));
            (listVerticalNew.get(i)).click();
            if(driver.findElement(By.cssSelector("h1[style='margin-top: 0px;']")) != null){
                System.out.println("Заголовок найден. Пункт основного меню "+ (i+1));
            }
            else {System.out.println("Заголовок не найден. Пункт основного меню "+ (i+1));
            }
            List<WebElement> InnerlistVertical = driver
                    .findElements(By.cssSelector("li.selected span.name:nth-child(1)"));
            int num2 = InnerlistVertical.size();
            if(num2 > 0){
                for (int j = 0; j < num2; j++){
                List<WebElement> InnerlistVerticalNew = driver
                        .findElements(By.cssSelector("li.selected span.name:nth-child(1)"));
                (InnerlistVerticalNew.get(j)).click();
                if(driver.findElement(By.cssSelector("h1[style='margin-top: 0px;']")) != null){
                    System.out.println("Заголовок найден. Пункт меню второго уровня " + (j+1));
                }
                else {System.out.println("Заголовок не найден. Пункт меню второго уровня " + (j+1));
                }
            }
            }
        }
    }
}
