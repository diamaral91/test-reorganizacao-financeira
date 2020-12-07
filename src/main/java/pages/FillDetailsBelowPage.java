package pages;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import objects.FillDetailsBelowObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FillDetailsBelowPage {

    private DriverWait wait;
    private FillDetailsBelowObject fillDetailsBelow;
    private WebDriver driver;

    public FillDetailsBelowPage(WebDriver driver){
        this.driver = driver;
        wait = new DriverWait(driver);
        fillDetailsBelow = new FillDetailsBelowObject(driver);
        PageFactory.initElements(driver, this);
    }

    public String completeProcess(){
        wait.elementToBeVisibility(fillDetailsBelow.emailInput).sendKeys("email@email.com");
        wait.elementToBeClickable(fillDetailsBelow.acceptAditivoReorgCheck).click();
        wait.elementToBeClickable(fillDetailsBelow.confirmAcceptedBtn).click();

        return wait.elementToBeVisibility(fillDetailsBelow.msgSuccessText).getText();
    }

    public FillDetailsBelowPage openDocuments(){
        wait.elementToBeClickable(fillDetailsBelow.viewAditivoReorg).click();
        wait.elementToBeClickable(fillDetailsBelow.viewCetReorg).click();
        return this;
    }

    public boolean checkDocuments(){
        boolean validate = false;

        String aditivo = "Aditivo - Reorganização Financeira.pdf";
        String cet = "CET - Reorganização Financeira.pdf";
        String userPath = System.getProperty("user.home");
        String folder = "/Downloads/";

        try {
            File aditivoFile = new File(userPath + folder + aditivo);
            validate = aditivoFile.exists();
            ExtentTestManager.getTest().log(LogStatus.INFO, "file: " + aditivo + " " + validate);

            File cetFile = new File(userPath + folder + cet);
            validate = cetFile.exists();
            ExtentTestManager.getTest().log(LogStatus.INFO, "file: " + cet + " " + validate);

            aditivoFile.delete();
            cetFile.delete();
        } catch (Exception e) {
            List<String> abas = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(abas.get(1)).quit();
            driver.switchTo().window(abas.get(2)).quit();
        }

        return validate;
    }
}
