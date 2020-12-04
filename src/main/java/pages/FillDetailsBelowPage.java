package pages;

import objects.FillDetailsBelowObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

public class FillDetailsBelowPage {

    private DriverWait wait;
    private objects.FillDetailsBelowObject fillDetailsBelow;

    public FillDetailsBelowPage(WebDriver driver){
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
}
