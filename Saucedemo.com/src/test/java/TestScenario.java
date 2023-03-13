import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestScenario extends Driver {
    @Test
    public void testCase1() {
        LoginPage.authorizationSuccessful();
        ProductsPage.addFirstProductIntoCart();
        ProductsPage.openCart();
        CartPage.pressCheckout();
        CheckoutPage.fillCheckoutInfo();

        assertEquals("https://www.saucedemo.com/checkout-complete.html",CheckoutPage.getUrl());
        assertEquals("Thank you for your order!",CheckoutPage.getInfoText());
    }
    @Test
    public void testCase2() {
        // авторизация
        LoginPage.authorizationFailed();
        String textInfoError = driver.findElement(By.cssSelector("h3[data-test='error']")).getAttribute("textContent");
        assertEquals("Epic sadface: Username and password do not match any user in this service",textInfoError);
    }
}