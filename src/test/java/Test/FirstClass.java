package Test;

import Page.HerokuMainPage;
import org.testng.annotations.Test;

public class FirstClass extends BaseClass{
    @Test
    public void firstSeleniumTest() {
        driver.get("https://the-internet.herokuapp.com/");
        HerokuMainPage mainPage = new HerokuMainPage(driver);
        driver.findElement(mainPage.btn_context_menu).click();
        System.out.println("Test done!");
    }
}
