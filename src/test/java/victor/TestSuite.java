package victor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import victor.SharedSteps.CheckoutSteps;
import victor.SharedSteps.GeneralSteps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Victor
 */
public class TestSuite
{
    GeneralSteps generalSteps = new GeneralSteps();
    CheckoutSteps checkoutSteps = new CheckoutSteps();

    @Test
    public void registerTest()
    {
        generalSteps.goToRegistrationPage();
        generalSteps.register();
        assertTrue(generalSteps.registrationIsSuccess(), "Something wrong custom message");
    }

    @Test
    public void searchTest() throws InterruptedException
    {
        generalSteps.goToHomepage();
        generalSteps.searchFor("blue");
        List<String> products = generalSteps.getSearchResults();
        assertNotNull(products);
        assertTrue(products.contains("Blue and green Sneaker"));
        assertTrue(products.contains("Blue Jeans"));
        assertTrue(products.contains("Green and blue Sneaker"));
        assertFalse(products.contains("Laptop"));
    }

    @Test
    public void checkoutTest()
    {
        generalSteps.loginTestUser("user12@mail.com", "Qw1#Qw1#");
        generalSteps.selectCategory("Apparel & Shoes", null);
        generalSteps.addProductToCart("Blue Jeans", 3);
        generalSteps.selectCategory("ELECTRONICS", "CELL PHONES");
        generalSteps.addProductToCart("Phone Cover", 2);
        generalSteps.openCart();
        checkoutSteps.performDefaultCheckout();
        String checkoutPageText = checkoutSteps.getCheckoutPageText();
        assertTrue(checkoutPageText.contains("Thank you") , "No thank you in: " + checkoutPageText);
        assertTrue(checkoutPageText.contains("Your order has been successfully"), "No order in: " + checkoutPageText);
    }

    @AfterEach
    public void teardown()
    {
        WebDriverSingleton.quitDriver();
    }
}
