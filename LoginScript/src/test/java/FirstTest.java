import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
public class FirstTest extends MainClass {
    @Test
    public void FirstTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.xpath("//ul[@class='list-vertical']//span[text()='Appearence']")).click();
        // проверяем наличие заголовка Template
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Template')]"));
        driver.findElement(By.cssSelector("li.selected[id=doc-template] span.name")).click();
        driver.findElement(By.cssSelector("li[id=doc-logotype] span.name")).click();
        // проверяем наличие заголовка Logotype
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Logotype')]"));

        driver.findElement(By.xpath("//ul[@class='list-vertical']//span[text()='Catalog']")).click();
        // проверяем наличие заголовка Catalog
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Catalog')]"));
        driver.findElement(By.cssSelector("li.selected[id=doc-catalog]")).click();
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=product_groups']")).click();
        // проверяем наличие заголовка Product Groups
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Product Groups')]"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=option_groups']")).click();
        // проверяем наличие заголовка Option Groups
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Option Groups')]"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=manufacturers']")).click();
        // проверяем наличие заголовка Manufacturers
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Manufacturers')]"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=suppliers']")).click();
        // проверяем наличие заголовка Suppliers
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Suppliers')]"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=delivery_statuses']")).click();
        // проверяем наличие заголовка Delivery Statuses
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Delivery Statuses')]"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=sold_out_statuses']")).click();
        // проверяем наличие заголовка Sold Out Statuses
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Sold Out Statuses')]"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=quantity_units']")).click();
        // проверяем наличие заголовка Quantity Units
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Quantity Units')]"));
        driver.findElement(By.cssSelector("a[href='http://localhost/litecart/admin/?app=catalog&doc=csv']")).click();
        // проверяем наличие заголовка CSV Import/Export
        driver.findElement(By.xpath("//h1[@style][contains(text(),' CSV Import/Export')]"));

        driver.findElement(By.xpath("//ul[@class='list-vertical']//span[text()='Countries']")).click();
        // проверяем наличие заголовка Countries
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Countries')]"));

        driver.findElement(By.xpath("//ul[@class='list-vertical']//span[text()='Currencies']")).click();
        // проверяем наличие заголовка Currencies
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Currencies')]"));

        driver.findElement(By.xpath("//ul[@class='list-vertical']//span[text()='Customers']")).click();
        // проверяем наличие заголовка Customers
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Customers')]"));
        driver.findElement(By.xpath("//span[text()='CSV Import/Export']")).click();
        // проверяем наличие заголовка CSV Import/Export
        driver.findElement(By.xpath("//h1[@style][contains(text(),' CSV Import/Export')]"));
        driver.findElement(By.xpath("//span[text()='Newsletter']")).click();
        // проверяем наличие заголовка Newsletter
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Newsletter')]"));

        driver.findElement(By.xpath("//span[text()='Geo Zones']")).click();
        // проверяем наличие заголовка Geo Zones
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Geo Zones')]"));

        driver.findElement(By.xpath("//span[text()='Languages']")).click();
        // проверяем наличие заголовка Languages
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Languages')]"));
        driver.findElement(By.cssSelector("li.selected[id=doc-languages]")).click();
        driver.findElement(By.cssSelector("li[id=doc-storage_encoding]")).click();
        // проверяем наличие заголовка Storage Encoding
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Storage Encoding')]"));

        driver.findElement(By.xpath("//span[text()='Modules']")).click();
        // проверяем наличие заголовка Job Modules
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Job Modules')]"));
        driver.findElement(By.xpath("//span[text()='Background Jobs']")).click();
        driver.findElement(By.xpath("//span[text()='Customer']")).click();
        // проверяем наличие заголовка Customer Modules
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Customer Modules')]"));
        driver.findElement(By.xpath("//span[text()='Shipping']")).click();
        // проверяем наличие заголовка Shipping Modules
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Shipping Modules')]"));
        driver.findElement(By.xpath("//span[text()='Payment']")).click();
        // проверяем наличие заголовка Payment Modules
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Payment Modules')]"));
        driver.findElement(By.xpath("//span[text()='Order Total']")).click();
        // проверяем наличие заголовка Order Total Modules
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Order Total Modules')]"));
        driver.findElement(By.xpath("//span[text()='Order Success']")).click();
        // проверяем наличие заголовка Order Success Modules
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Order Success Modules')]"));
        driver.findElement(By.xpath("//span[text()='Order Action']")).click();
        // проверяем наличие заголовка Order Action Modules
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Order Action Modules')]"));

        driver.findElement(By.xpath("//span[text()='Orders']")).click();
        // проверяем наличие заголовка Orders
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Orders')]"));
        driver.findElement(By.cssSelector("li.selected[id=doc-orders]")).click();
        driver.findElement(By.cssSelector("li[id=doc-order_statuses]")).click();
        // проверяем наличие заголовка Order Statuses
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Order Statuses')]"));

        driver.findElement(By.xpath("//span[text()='Pages']")).click();
        // проверяем наличие заголовка Pages
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Pages')]"));

        driver.findElement(By.xpath("//span[text()='Reports']")).click();
        // проверяем наличие заголовка Monthly Sales
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Monthly Sales')]"));
        driver.findElement(By.xpath("//span[text()='Monthly Sales']")).click();
        driver.findElement(By.xpath("//span[text()='Most Sold Products']")).click();
        // проверяем наличие заголовка Most Sold Products
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Most Sold Products')]"));
        driver.findElement(By.xpath("//span[text()='Most Shopping Customers']")).click();
        // проверяем наличие заголовка Most Shopping Customers
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Most Shopping Customers')]"));

        driver.findElement(By.xpath("//span[text()='Settings']")).click();
        // проверяем наличие заголовка Settings
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Settings')]"));
        driver.findElement(By.xpath("//span[text()='Store Info']")).click();
        driver.findElement(By.xpath("//span[text()='Defaults']")).click();
        driver.findElement(By.xpath("//span[text()='General']")).click();
        driver.findElement(By.xpath("//span[text()='Listings']")).click();
        driver.findElement(By.xpath("//span[text()='Images']")).click();
        driver.findElement(By.xpath("//span[text()='Checkout']")).click();
        driver.findElement(By.xpath("//span[text()='Advanced']")).click();
        driver.findElement(By.xpath("//span[text()='Security']")).click();

        driver.findElement(By.xpath("//span[text()='Slides']")).click();
        // проверяем наличие заголовка Slides
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Slides')]"));

        driver.findElement(By.xpath("//span[text()='Tax']")).click();
        // проверяем наличие заголовка Tax Classes
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Tax Classes')]"));
        driver.findElement(By.xpath("//span[text()='Tax Classes']")).click();
        driver.findElement(By.xpath("//span[text()='Tax Rates']")).click();
        // проверяем наличие заголовка Tax Rates
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Tax Rates')]"));

        driver.findElement(By.xpath("//span[text()='Translations']")).click();
        // проверяем наличие заголовка Search Translations
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Search Translations')]"));
        driver.findElement(By.xpath("//span[text()='Search Translations']")).click();
        driver.findElement(By.xpath("//span[text()='Scan Files']")).click();
        // проверяем наличие заголовка Scan Files For Translations
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Scan Files For Translations')]"));
        driver.findElement(By.xpath("//span[text()='CSV Import/Export']")).click();
        // проверяем наличие заголовка CSV Import/Export
        driver.findElement(By.xpath("//h1[@style][contains(text(),' CSV Import/Export')]"));

        driver.findElement(By.xpath("//span[text()='Users']")).click();
        // проверяем наличие заголовка Users
        driver.findElement(By.xpath("//h1[@style][contains(text(),' Users')]"));

        driver.findElement(By.xpath("//span[text()='vQmods']")).click();
        // проверяем наличие заголовка vQmods
        driver.findElement(By.xpath("//h1[@style][contains(text(),' vQmods')]"));
    }
}
