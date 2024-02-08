package Test;

import Page.PageObject.DynamicLoadingPage;
import Page.PageObject.HerokuMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstClass extends BaseClass{
    HerokuMainPage mainPage = new HerokuMainPage(driver);
    @Test
    public void withStandardLocatorsTest() {
        driver.get("https://the-internet.herokuapp.com/");
        HerokuMainPage mainPage = new HerokuMainPage(driver);
        driver.findElement(mainPage.btn_context_menu).click();
        System.out.println("Test done!");
    }
    @Test
    public void withPageFactoryLocatorsTest() {
        driver.get("https://the-internet.herokuapp.com/");
        Page.PageFactory.HerokuMainPage mainPage = new Page.PageFactory.HerokuMainPage(driver);
        mainPage.btn_context_menu.click();
        System.out.println("Test done");
    }
    @Test
    public void useExplicitWait() {
        driver.get("https://the-internet.herokuapp.com/");
        Page.PageObject.HerokuMainPage mainPage = new Page.PageObject.HerokuMainPage(driver);
        driver.findElement(mainPage.btn_context_menu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.right_click_field));
        System.out.println("Test done");
    }
    @Test
    public void dynamicLoadingTest() {
        driver.get("https://the-internet.herokuapp.com/");
        String txt =
        mainPage
                .goToDynamicLoadingPage()
                .goToExample1Page()
                .clickStart()
                .verifyThatElementExists(DynamicLoadingPage.TXT_HELLO_WORLD)
                .waitForElement(DynamicLoadingPage.TXT_HELLO_WORLD)
                .getText(DynamicLoadingPage.TXT_HELLO_WORLD);
        System.out.println("The text is " + txt);
    }
}
