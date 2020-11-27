package support;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class DriverWait {

    private Wait<WebDriver> wait;
    private int timeOut = 10;

    public DriverWait(WebDriver driver){
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchFieldException.class)
                .ignoring(ElementNotSelectableException.class);
    }

    public WebElement elementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement elementToBeVisibility(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> elementsToBeVisibility(List<WebElement> element){
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public WebElement interactElementWithText(List<WebElement> elements, String text){
        elementsToBeVisibility(elements);
        for(WebElement element : elements) {
            if(element.getText().contains(text)){
                return element;
            }
        }
        new RuntimeException(text + "nao encontrado");
        return null;
    }
}
