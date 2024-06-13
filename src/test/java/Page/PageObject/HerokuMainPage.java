package Page.PageObject;

import Interface.IGenericMethods;
import Test.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HerokuMainPage extends BaseClass implements IGenericMethods<HerokuMainPage> {
    WebDriver driver;
    public static By BTN_CONTEXT_MENU = By.xpath("//a[@href = '/context_menu']");
    public static By BTN_DYNAMIC_LOADING = By.xpath("//a[@href = '/dynamic_loading']");
    public static By RIGHT_CLICK_FIELD = By.xpath("//*[@id = 'hot-spot']");
    public static By BTN_JS_ALERT = By.xpath("//a[@href = '/javascript_alerts']");
    public static By BTN_DRAG_AND_DROP = By.xpath("//a[@href = '/drag_and_drop']");

    @Override
    public HerokuMainPage getInstance() {
        return this;
    }

    public HerokuMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public DynamicLoadingPage goToDynamicLoadingPage() {
        driver.findElement(BTN_DYNAMIC_LOADING).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated())
        return new DynamicLoadingPage(driver);
    }
    public JavaScriptAlertsPage goToJavaScriptAlertsPage() {
        driver.findElement(BTN_JS_ALERT).click();
        return new JavaScriptAlertsPage(driver);
    }
    public DragAndDropPage goToDragAndDropPage() {
        click(BTN_DRAG_AND_DROP);
        return new DragAndDropPage(driver);
    }
}
