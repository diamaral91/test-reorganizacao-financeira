package pages;

import objects.FillDetailsBelowObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;
import utils.DataUtil;
import utils.Utils;

public class FillDetailsBelowPage {

    private DriverWait wait;
    private FillDetailsBelowObject fillDetailsBelow;
    private WebDriver driver;

    public FillDetailsBelowPage(WebDriver driver){
        this.driver = driver;
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

    public FillDetailsBelowPage openDocuments(){
        wait.elementToBeClickable(fillDetailsBelow.viewAditivoReorg).click();
        wait.waitToElementClickNotIntercepted(fillDetailsBelow.viewCetReorg);
        Utils.sleep();
        return this;
    }

    public boolean checkDocuments(){
        boolean validate = false;

        String aditivo = "Aditivo - Reorganização Financeira.pdf";
        String cet = "CET - Reorganização Financeira.pdf";

        validate = DataUtil.checkFile(driver, aditivo);
        validate = DataUtil.checkFile(driver, cet);

        return validate;
    }
}
