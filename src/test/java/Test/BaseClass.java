package Test;

import Interface.IGenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseClass {
    FirefoxOptions options = new FirefoxOptions();
    public static FirefoxDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

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
