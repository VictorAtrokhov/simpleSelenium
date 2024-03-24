package victor.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Victor
 */
public class CheckoutPage
{
    @FindBy(id = "termsofservice")
    WebElement termsOfService;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "billing-address-select")
    WebElement selectAddress;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countrySelect;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phone;

    @FindBy(id = "opc-billing")
    WebElement checkoutBillingSection;

    @FindBy(id = "opc-shipping")
    WebElement checkoutShippingSection;

    @FindBy(id = "opc-shipping_method")
    WebElement checkoutShippingMethodSection;

    @FindBy(id = "opc-payment_method")
    WebElement checkoutPaymentMethodSection;

    @FindBy(id = "opc-payment_info")
    WebElement checkoutPaymentInfoSection;

    @FindBy(xpath = "//input[@value='Confirm']")
    WebElement confirmBtn;

    @FindBy(css = ".page.checkout-page")
    WebElement checkoutPage;

    public void startCheckout()
    {
        termsOfService.click();
        checkoutBtn.click();
    }

    public void fillDefaultCheckoutAddress()
    {
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Latvia");
        city.sendKeys("Riga");
        address.sendKeys("Middle of nowhere");
        postalCode.sendKeys("LV-1234");
        phone.sendKeys("987654321");
        checkoutBillingSection.findElement(By.cssSelector("input[value='Continue']")).click();
    }

    public void completeDefaultCheckout()
    {
        checkoutShippingSection.findElement(By.cssSelector("input[value='Continue']")).click();
        checkoutShippingMethodSection.findElement(By.cssSelector("input[value='Continue']")).click();
        checkoutPaymentMethodSection.findElement(By.cssSelector("input[value='Continue']")).click();
        checkoutPaymentInfoSection.findElement(By.cssSelector("input[value='Continue']")).click();
        confirmBtn.click();
    }

    public void selectNewAddress()
    {
        Select select = new Select(selectAddress);
        select.selectByVisibleText("New Address");
    }

    public String viewCheckoutPageContent()
    {
        return checkoutPage.getText();
    }
}
