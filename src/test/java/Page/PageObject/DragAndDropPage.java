package Page.PageObject;

import Interface.IGenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

public class DragAndDropPage implements IGenericMethods<DragAndDropPage> {
    public static By OBJECT_1 = By.xpath("//*[@id = 'column-a']");
    public static By OBJECT_2 = By.xpath("//*[@id = 'column-b']");
    public static By OBJECT_1_TEXT = By.xpath("//*[@id = 'column-a']//header");
    public static By OBJECT_2_TEXT = By.xpath("//*[@id = 'column-b']//header");

    WebDriver driver;

    @Override
    public DragAndDropPage getInstance() {
        return this;
    }

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }
    public DragAndDropPage checkObjectText(String object1Expected, String object2Expected) {
        String object1Actual = driver.findElement(OBJECT_1_TEXT).getText();
        String object2Actual = driver.findElement(OBJECT_2_TEXT).getText();
        assertEquals(object1Expected, object1Actual);
        assertEquals(object2Expected, object2Actual);
        return new DragAndDropPage(driver);
    }
}
