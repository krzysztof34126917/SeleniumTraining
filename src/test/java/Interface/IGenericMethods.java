package Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Test.BaseClass.driver;

public interface IGenericMethods<T> {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    Actions action = new Actions(driver);
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
    default T click(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
        return getInstance();
    }
    default T dragAndDrop(By sourceLocator, By targetLocator) {
//        Action dragAndDrop = action
//                .clickAndHold(driver.findElement(sourceLocator))
//                .moveToElement(driver.findElement(targetLocator))
//                .release(driver.findElement(targetLocator))
//                .build();
//        dragAndDrop.perform();

        action.dragAndDrop(driver.findElement(sourceLocator), driver.findElement(targetLocator)).build().perform();
        return getInstance();
    }
    default T waitForSec(long millis) {
        try {
            wait(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getInstance();
    }
}
