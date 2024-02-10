package Page.PageObject;

import Test.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HerokuMainPage extends BaseClass {
    WebDriver driver;
    public By btn_context_menu = By.xpath("//a[@href = '/context_menu']");
    public By btn_dynamic_loading = By.xpath("//a[@href = '/dynamic_loading']");
    public By right_click_field = By.xpath("//*[@id = 'hot-spot']");
    public By btn_js_alert = By.xpath("//a[@href = '/javascript_alerts']");



    public HerokuMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public DynamicLoadingPage goToDynamicLoadingPage() {
        driver.findElement(btn_dynamic_loading).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated())
        return new DynamicLoadingPage(driver);
    }
    public JavaScriptAlertsPage goToJavaScriptAlertsPage() {
        driver.findElement(btn_js_alert).click();
        return new JavaScriptAlertsPage(driver);
    }
}
