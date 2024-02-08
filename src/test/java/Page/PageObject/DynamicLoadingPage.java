package Page.PageObject;

import Interface.IGenericMethods;
import Test.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BaseClass implements IGenericMethods<DynamicLoadingPage> {
    WebDriver driver;
    public By btnHiddenElementOnPage = By.xpath("//*[@href = '/dynamic_loading/1']");
    public By btnStart = By.xpath("//button[text() = 'Start']");
    public static By TXT_HELLO_WORLD = By.xpath("//*[text() = 'Hello World!']");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }
    @Override
    public DynamicLoadingPage getInstance() {
        return this;
    }
    public DynamicLoadingPage goToExample1Page() {
        driver.findElement(btnHiddenElementOnPage).click();
        return this;
    }
    public DynamicLoadingPage clickStart() {
        driver.findElement(btnStart).click();
        return this;
    }
}
