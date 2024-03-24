package victor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.time.Duration;

/**
 * @author Victor
 */
public class DriverController
{
    public static WebDriver driver;

    public static void initDriver()
    {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
