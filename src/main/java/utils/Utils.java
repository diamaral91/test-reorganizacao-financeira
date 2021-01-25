package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {

    public static void sleep(){
        try {
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sleep(int timeOut){
        try {
            Thread.sleep(timeOut * 1000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }
}
