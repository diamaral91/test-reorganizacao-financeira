package pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentManager;
import extentReport.ExtentTestManager;
import objects.CalculationWorksheetObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

public class CalculationWorksheetPage {

    private CalculationWorksheetObject calculationWorksheetObject;
    private DriverWait wait;

    public CalculationWorksheetPage(WebDriver driver){
        this.wait = new DriverWait(driver);
        calculationWorksheetObject = new CalculationWorksheetObject(driver);
        PageFactory.initElements(driver, this);
    }

    public void downloadPdf(){
        wait.elementToBeClickable(calculationWorksheetObject.downloadPdfButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "download pdf");
    }
}
