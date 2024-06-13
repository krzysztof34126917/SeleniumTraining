package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MedicoverTest extends BaseClass {
    @Test
    public void someTest() {
        driver.get("https://www.medicover.pl/");
        // Accept cookies
        SearchContext shadowRoot = driver.findElement(By.xpath("//div[@id = 'cmpwrapper']")).getShadowRoot();
        WebElement cookie_consent_button = shadowRoot.findElement(By.id("cmpwelcomebtnyes"));
        cookie_consent_button.click();
        // Log in
        WebElement log_in_button = driver.findElement(By.xpath("//*[@class = 'login-widget-button-login']"));
        log_in_button.click();
        String currentHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("We're now in the handle: " + driver.getWindowHandle());
        System.out.println("Now we're switching");
        Optional<String> otherHandle = windowHandles.stream().filter(x -> !x.equals(currentHandle)).findFirst();
        driver.switchTo().window(otherHandle.get());
        System.out.println("We're now in the handle: " + driver.getWindowHandle());
        WebElement log_in_button_2 = driver.findElement(By.xpath("//input[@id = 'oidc-submit']"));
        log_in_button_2.click();


    }
}
