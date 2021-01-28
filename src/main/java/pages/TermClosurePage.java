package pages;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import objects.TermClosureObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

public class TermClosurePage {

    private TermClosureObject termClosureObject;
    private DriverWait wait;

    public TermClosurePage(WebDriver driver){
        this.wait = new DriverWait(driver);
        this.termClosureObject = new TermClosureObject(driver);
        PageFactory.initElements(driver, this);
    }

    public void requestLeasingClosure(){
        wait.elementToBeClickable(termClosureObject.requestLeasingClosureButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "request leasing closure");
    }

    public TermClosurePage clickTermClosureLeasing(){
        wait.elementToBeClickable(termClosureObject.termClosureLeasingButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "term closure leasing");
        return this;
    }

    public TermClosurePage clickClosureManual(){
        wait.elementToBeClickable(termClosureObject.closureManualButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "closure manual");
        return this;
    }
}
