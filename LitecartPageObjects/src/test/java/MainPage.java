import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    public static void getMainPage() {
        DriverClass.driver.get("http://localhost/litecart/en/");
    }
    public static List<WebElement> allProductsList(){
        return DriverClass.driver.findElements(By.cssSelector("li[class*='product column']"));
    }
}
