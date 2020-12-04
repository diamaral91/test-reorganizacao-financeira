package pages;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import objects.HowWorkItObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

public class HowWorkItPage {

    private DriverWait wait;
    private HowWorkItObject howWorkIt;

    public HowWorkItPage(WebDriver driver){
        wait = new DriverWait(driver);
        howWorkIt = new HowWorkItObject(driver);
        PageFactory.initElements(driver, this);
    }

    public void simulateRenegotiation(){
        wait.elementToBeVisibility(howWorkIt.simulateRenegotiationBtn).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "simulate renegociation");
    }
}