package victor.SharedSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import victor.Pages.SimplePage;
import victor.Util;
import victor.WebDriverSingleton;

import java.util.List;


/**
 * @author Victor
 */
public class GeneralSteps
{
    private final WebDriver driver;
    private final SimplePage simplePage;

    private static final String baseUrl = "https://demowebshop.tricentis.com/";

    public GeneralSteps()
    {
        this.driver = WebDriverSingleton.getDriver();
        simplePage = PageFactory.initElements(driver, SimplePage.class);
    }

    public void goToHomepage()
    {
        driver.get(baseUrl);
    }

    public void goToRegistrationPage()
    {
        driver.get(baseUrl + "register");
    }

    public void register()
    {
        Util.generateRandomEmail();
        simplePage.register(Util.get("email"), "Donald", "Trump", "Qw1#Qw1#");
    }

    public void loginTestUser(String email, String password)
    {
        driver.get(baseUrl + "login");
        simplePage.login(email, password);
    }

    public boolean registrationIsSuccess()
    {
        return simplePage.registrationSuccess() && driver.getCurrentUrl().contains(
                "registerresult/1");
    }

    public void searchFor(String query)
    {
        simplePage.search(query);
    }

    public List<String> getSearchResults()
    {
        return simplePage.getFoundItems();
    }

    public void selectCategory(String topCategory, String subCategory)
    {
        simplePage.selectTopCategory(topCategory);
        if (subCategory != null)
        {
            simplePage.selectSubCategory(subCategory);
        }
    }

    public void addProductToCart(String product, int quantity)
    {
        simplePage.selectProduct(product);
        simplePage.addToCart(quantity);
    }

    public void openCart()
    {
        simplePage.openCart();
    }
}
