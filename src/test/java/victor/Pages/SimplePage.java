package victor.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor
 */
public class SimplePage
{
    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "gender-male")
    WebElement radioMale;

    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @FindBy(id = "LastName")
    WebElement lastNameField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = ".page-body")
    WebElement pageBody;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchBtn;

    @FindBy(id = "small-searchterms")
    WebElement searchInput;

    @FindBy(className = "search-results")
    WebElement searchResults;

    @FindBy(css = ".top-menu a[href]")
    List<WebElement> topCategoryItems;

    @FindBy(css = ".sub-category-item a[href]")
    List<WebElement> subCategoryItems;

    @FindBy(css = ".product-title a")
    List<WebElement> products;

    @FindBy(xpath = "//input[contains(@id,'EnteredQuantity')]")
    WebElement quantitySetter;

    @FindBy(id = "topcartlink")
    WebElement toCartButton;

    @FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
    WebElement addToCartBtn;



    public void register(String email, String firstname, String lastname, String password)
    {
        radioMale.click();
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        registerBtn.click();
    }

    public void login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    public boolean registrationSuccess()
    {
        List<WebElement> results = pageBody.findElements(By.className("result"));
        if (results.isEmpty())
        {
            return false;
        }
        WebElement first = results.get(0);
        return "Your registration completed".equals(first.getText());
    }

    public void search(String query)
    {
        searchInput.sendKeys(query);
        searchBtn.click();
    }

    public List<String> getFoundItems()
    {
        List<WebElement> products = searchResults.findElements(By.cssSelector(".product-title a"));

        List<String> productNames = new ArrayList<>();

        if (products.isEmpty())
        {
            return null;
        }
        // Iterate over the list of WebElement objects and extract their text
        for (WebElement product : products)
        {

            productNames.add(product.getText());
        }

        return productNames;
    }

    public void selectTopCategory(String text)
    {
        for (WebElement item : topCategoryItems)
        {
            if (text.equalsIgnoreCase(item.getText()))
            {
                item.click();
                return;
            }
        }
    }

    public void selectSubCategory(String text)
    {
        for (WebElement item : subCategoryItems)
        {
            if (text.equalsIgnoreCase(item.getText()))
            {
                item.click();
                return;
            }
        }
    }

    public void selectProduct(String productName)
    {
        for (WebElement product : products)
        {
            if (productName.equalsIgnoreCase(product.getText()))
            {
                product.click();
                return;
            }
        }
    }

    public void addToCart(int quantity)
    {
        quantitySetter.clear();
        quantitySetter.sendKeys(Integer.toString(quantity));
        addToCartBtn.click();
    }

    public void openCart()
    {
        toCartButton.click();
    }
}
