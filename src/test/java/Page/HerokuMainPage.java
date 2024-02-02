package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HerokuMainPage {
    WebDriver driver;
    public By btn_context_menu = By.xpath("//a[@href = '/context_menu']");

    public HerokuMainPage(WebDriver driver) {
        this.driver = driver;
    }
}
