package victor.SharedSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import victor.Pages.CheckoutPage;
import victor.WebDriverSingleton;

import java.time.Duration;

/**
 * @author Victor
 */
public class CheckoutSteps
{
    private static WebDriver driver;
    private final CheckoutPage checkoutPage;

    public CheckoutSteps()
    {
        driver = WebDriverSingleton.getDriver();
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }

    public void performDefaultCheckout()
    {
        checkoutPage.startCheckout();
        checkoutPage.selectNewAddress();
        checkoutPage.fillDefaultCheckoutAddress();
        checkoutPage.completeDefaultCheckout();
    }

    public String getCheckoutPageText()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("checkout/completed"));
        return checkoutPage.viewCheckoutPageContent();
    }

}
