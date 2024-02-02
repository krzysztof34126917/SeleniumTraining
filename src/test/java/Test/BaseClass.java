package Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    FirefoxOptions options = new FirefoxOptions();
    public static FirefoxDriver driver = new FirefoxDriver();

    @BeforeSuite
    public void beforeSuite() {
//        options.addArguments("-headless");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
