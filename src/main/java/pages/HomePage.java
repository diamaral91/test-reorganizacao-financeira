package pages;

import com.relevantcodes.extentreports.LogStatus;
import enums.OperationsEnum;
import extentReport.ExtentTestManager;
import objects.HomeObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public HomePage closePopUp(){
        wait.elementToBeClickable(home.popUpText).isDisplayed();
        wait.elementToBeClickable(home.seeMyMessagesButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "close pop up");
        return this;
    }

    public HomePage clickHomePage(){
        wait.elementToBeClickable(home.homePageButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "access home page");
        return this;
    }

    public HomePage selectContract(String contract){
        wait.interactElementWithText(home.contractsList, contract).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "contract: " + contract);
        return this;
    }

    public HomePage selectLeasingContract(String contract){
        WebElement element = wait.interactElementWithText(home.menuLeasingList, contract);
        wait.elementToBeClickable(element).click();
        wait.elementToBeClickable(element).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "contract leasing: " + contract);
        return this;
    }

    public void selectInformation(OperationsEnum info){
        wait.interactElementWithText(home.importantInfoButton, info.getOperation()).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "select info:" + info);
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
