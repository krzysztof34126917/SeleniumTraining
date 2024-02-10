package Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Test.BaseClass.driver;

public interface IGenericMethods<T> {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    T getInstance();
    default T verifyThatElementExists(By locator) {
        driver.findElement(locator);
        return getInstance();
    }
    default String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    default T waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getInstance();
    }
    default T acceptAlert() {
        driver.switchTo().alert().accept();
        return getInstance();
    }
    default T dismissAlert() {
        driver.switchTo().alert().dismiss();
        return getInstance();
    }
    default T sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        return getInstance();
    }
}
