package support;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverWait {

    private Wait<WebDriver> wait;
    private int timeOut = 20;

    public DriverWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitForJavaScriptCondition(driver);
        waitForJQueryProcessing(driver);
        Utils.sleep(1);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotSelectableException.class);
    }

    public WebElement elementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToElementClickNotIntercepted(WebElement element){
        int count =0;
        while(count < 10) {
            try {
                elementToBeClickable(element).click();
                break;
            } catch (ElementClickInterceptedException e) {
                Utils.sleep();
                count++;
            }
        }
    }

    public Select elementToBeSelectionState(WebElement element){
        return new Select(element);
    }

    public WebElement elementToBeVisibility(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean textToBePresentInElement(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public List<WebElement> elementsToBeVisibility(List<WebElement> element){
        Utils.sleep(1);
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

    private DriverWait waitForJavaScriptCondition(WebDriver driver) {
        boolean jscondition = false;
        String javaScript = "return (xmlhttp.readyState >= 2 && xmlhttp.status == 200)";
        try{
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            new WebDriverWait(driver, timeOut) {
            }.until(new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
                }
            });
            jscondition =  (Boolean) ((JavascriptExecutor) driver).executeScript(javaScript);
            driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS); //reset implicitlyWait
        } catch (JavascriptException e) { }
        return this;
    }

    private DriverWait waitForJQueryProcessing(WebDriver driver){
        boolean jQcondition = false;
        try{
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
            new WebDriverWait(driver, timeOut) {
            }.until(new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
                }
            });
            jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS); //reset implicitlyWait
        } catch (Exception e) { }
        return this;
    }
}
