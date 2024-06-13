package Test;

import Page.PageObject.DragAndDropPage;
import Page.PageObject.DynamicLoadingPage;
import Page.PageObject.HerokuMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstClass extends BaseClass {
    HerokuMainPage mainPage = new HerokuMainPage(driver);
    @Test
    public void withStandardLocatorsTest() {
        driver.get("https://the-internet.herokuapp.com/");
        HerokuMainPage mainPage = new HerokuMainPage(driver);
        driver.findElement(mainPage.BTN_CONTEXT_MENU).click();
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
        driver.findElement(mainPage.BTN_CONTEXT_MENU).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.RIGHT_CLICK_FIELD));
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

    @Test
    public void javaScriptAlerts() {
        driver.get("https://the-internet.herokuapp.com/");
        String myText = "This is my text";
        mainPage
                .goToJavaScriptAlertsPage()
                .clickBtnJsAlert()
                .acceptAlert()
                .checkResult("You successfully clicked an alert")
                .clickBtnJsAlertChoice()
                .dismissAlert()
                .checkResult("You clicked: Cancel")
                .clickBtnJsAlertChoice()
                .acceptAlert()
                .checkResult("You clicked: Ok")
                .clickBtnJsPrompt()
                .sendKeysAlert(myText)
                .acceptAlert()
                .checkResult("You entered: " + myText);
        System.out.println("Test finished");
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        mainPage
                .goToDragAndDropPage()
                .checkObjectText("A", "B")
                .dragAndDrop(DragAndDropPage.OBJECT_1, DragAndDropPage.OBJECT_2)
                .checkObjectText("B", "A")
                .dragAndDrop(DragAndDropPage.OBJECT_1, DragAndDropPage.OBJECT_2)
                .checkObjectText("A", "B");
    }
}
