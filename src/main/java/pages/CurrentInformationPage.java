package pages;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import objects.CurrentInformationObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;
import utils.DateUtil;

public class CurrentInformationPage {

    private DriverWait wait;
    private CurrentInformationObject currentInformation;

    public CurrentInformationPage(WebDriver driver){
        wait = new DriverWait(driver);
        currentInformation = new CurrentInformationObject(driver);
        PageFactory.initElements(driver, this);
    }

    public CurrentInformationPage summaryOfCurrentFunding(String contract, String payment){
        String number = "200" + contract;
        wait.textToBePresentInElement(currentInformation.fundingNumber, number);
        wait.textToBePresentInElement(currentInformation.formPayment, payment);

        ExtentTestManager.getTest().log(LogStatus.INFO, "payment: " + payment);
        return this;
    }


    public void selectBestOption(){
        String day = new DateUtil("dd").nextDate(+3);
        wait.elementToBeSelectionState(currentInformation.newInstallmentSelect).selectByVisibleText(day);

        String firstDueDate = new DateUtil("dd/MM/yyyy").nextDate(+10);
        wait.elementToBeSelectionState(currentInformation.firstDueDateSelect).selectByVisibleText(firstDueDate);
        wait.elementToBeClickable(currentInformation.firstDueDateSelect).click();
        wait.elementToBeClickable(currentInformation.consultSimulation).click();

        ExtentTestManager.getTest().log(LogStatus.INFO, "first due date: " + firstDueDate);
    }
}
