package victor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/**
 * @author Victor
 */
public class WebDriverSingleton
{
    private static WebDriver driver;

    private WebDriverSingleton()
    {
    }

    public static WebDriver getDriver()
    {
        if (driver == null)
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}
