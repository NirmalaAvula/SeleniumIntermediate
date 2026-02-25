package pageObjects;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utilities.BrowserFactory;

public class HookClass {

	public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}