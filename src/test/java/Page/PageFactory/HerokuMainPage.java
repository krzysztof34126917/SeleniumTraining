package Page.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuMainPage {
    @FindBy(xpath = "//a[@href = '/context_menu']") public WebElement btn_context_menu;
    @FindBy(xpath = "//a[@href = '/checkboxes']") public WebElement btn_checkboxes;
    @FindBy(xpath = "//*[@id = 'hot-spot']") public WebElement right_click_field;

    WebDriver driver;

    public HerokuMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
