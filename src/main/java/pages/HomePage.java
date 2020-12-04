package pages;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import objects.HomeObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;
import utils.Utils;

public class HomePage {

    private DriverWait wait;
    private HomeObject home;

    public HomePage(WebDriver driver){
        wait = new DriverWait(driver);
        home = new HomeObject(driver);
        PageFactory.initElements(driver, this);
    }

    public void accessOperation(String contract){
        wait.elementToBeVisibility(home.popUpText).isDisplayed();
        wait.elementToBeClickable(home.seeMyMessagesButton).click();
        Utils.sleep();
        wait.elementToBeVisibility(home.filterContractInput).sendKeys(contract);
        Utils.sleep();
        wait.elementToBeClickable(home.cdcContractText).click();
        wait.interactElementWithText(home.operationOptions, "REORGANIZAÇÃO FINANCEIRA").click();
        wait.elementToBeClickable(home.yesBtn).click();

        ExtentTestManager.getTest().log(LogStatus.INFO, "accessOperation: " + contract);
    }
}
