package pages;

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

    public void selectBestOption(){
        wait.elementToBeSelectionState(currentInformation.newInstallmentSelect).selectByVisibleText("3");

        String firstDueDate = DateUtil.firstDueDate();
        wait.elementToBeSelectionState(currentInformation.firstDueDateSelect).selectByVisibleText(firstDueDate);
        wait.elementToBeClickable(currentInformation.firstDueDateSelect).click();
    }
}
