package Page.PageObject;

import Interface.IGenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class JavaScriptAlertsPage implements IGenericMethods<JavaScriptAlertsPage> {
    public static By BTN_JS_ALERT = By.xpath("//button[text() = 'Click for JS Alert']");
    public static By BTN_ALERT_CONFIRM = By.xpath("//button[text() = 'Click for JS Confirm']");
    public static By BTN_JS_PROMPT = By.xpath("//button[text() = 'Click for JS Prompt']");
    public static By RESULT = By.xpath("//*[@id = 'result']");
    WebDriver driver;
    @Override
    public JavaScriptAlertsPage getInstance() {
        return this;
    }
    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    public JavaScriptAlertsPage clickBtnJsAlert() {
        driver.findElement(BTN_JS_ALERT).click();
        return new JavaScriptAlertsPage(driver);
    }
    public JavaScriptAlertsPage clickBtnJsAlertChoice() {
        driver.findElement(BTN_ALERT_CONFIRM).click();
        return new JavaScriptAlertsPage(driver);
    }
    public JavaScriptAlertsPage clickBtnJsPrompt() {
        driver.findElement(BTN_JS_PROMPT).click();
        return new JavaScriptAlertsPage(driver);
    }
    public JavaScriptAlertsPage checkResult(String expectedText) {
        assertEquals(expectedText, driver.findElement(RESULT).getText());
        return new JavaScriptAlertsPage(driver);
    }
}
