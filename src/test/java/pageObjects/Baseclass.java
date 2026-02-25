package pageObjects;
import org.openqa.selenium.WebDriver;
public abstract class Baseclass {
	
	protected WebDriver driver;

    public Baseclass(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}