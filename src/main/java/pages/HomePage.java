package pages;

import com.relevantcodes.extentreports.LogStatus;
import enums.OperationsEnum;
import extentReport.ExtentTestManager;
import objects.HomeObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

public class HomePage {

    private DriverWait wait;
    private HomeObject home;

    public HomePage(WebDriver driver){
        wait = new DriverWait(driver);
        home = new HomeObject(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage selectContract(String contract){
        try{
            wait.elementToBeVisibility(home.popUpText).isDisplayed();
            wait.elementToBeClickable(home.seeMyMessagesButton).click();
            wait.interactElementWithText(home.contractsList, contract).click();
        } catch (TimeoutException e) {
            wait.interactElementWithText(home.contractsList, contract).click();
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "contract: " + contract);
        return this;
    }

    public HomePage accessFinancialReorganization(){
        wait.interactElementWithText(home.operationOptions, "REORGANIZAÇÃO FINANCEIRA").click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "accessOperation: Reorganização Financeira");
        return this;
    }

    public void confirmContract(){
        wait.elementToBeClickable(home.yesBtn).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "confirm contract");
    }

    public HomePage accessOperation(OperationsEnum operation){
        wait.interactElementWithText(home.operationOptions, operation.getOperation()).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "accessOperation: " + operation);
        return this;
    }
}
