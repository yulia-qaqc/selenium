import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
public class CartTest extends DriverClass {
    @Test
    public void cartTest() {
        MainPage.getMainPage();
        for (int i = 0; i < 3; i++) {
            WebElement product = MainPage.allProductsList().get(i);
            product.click();
            ProductPage.fillSelectsSize();
            ProductPage.addProductIntoCart();
            ProductPage.waitNewCartCounter();
            MainPage.getMainPage();
            MainPage.allProductsList();
        }
        ProductPage.openCart();
        CartPage.deleteProducts();
        CartPage.checkProductsDeletion();
    }
}
