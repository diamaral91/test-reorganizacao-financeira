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

    private boolean typeNewinstallment() {
        int count = 5;
        while (count < 50) {
            try {
                wait.elementToBeSelectionState(currentInformation.newInstallmentSelect).selectByVisibleText(String.valueOf(count));
                return true;
            } catch (Exception e) {
                System.out.println("value not found");
            }
            count = count+5;
        }
        throw new RuntimeException();
    }

    public void selectBestOption(){
        typeNewinstallment();
        String firstDueDate = new DateUtil("dd/MM/yyyy").nextDate(+10);
        wait.elementToBeSelectionState(currentInformation.firstDueDateSelect).selectByVisibleText(firstDueDate);
        wait.elementToBeClickable(currentInformation.firstDueDateSelect).click();
        wait.elementToBeClickable(currentInformation.consultSimulation).click();

        ExtentTestManager.getTest().log(LogStatus.INFO, "first due date: " + firstDueDate);
    }
}
