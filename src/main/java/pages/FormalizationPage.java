package pages;

import objects.FormalizationObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;
import utils.Utils;

public class FormalizationPage {

    private DriverWait wait;
    private FormalizationObject formalization;

    public FormalizationPage(WebDriver driver){
        wait = new DriverWait(driver);
        formalization = new FormalizationObject(driver);
        Utils.scrollDown(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkFormalization(){
        wait.elementToBeVisibility(formalization.formalizationText).isDisplayed();
//        wait.textToBePresentInElement(formalization.newInstallmentValueText, "R$ 16.179,19 ");
        wait.elementToBeClickable(formalization.confirmSimulationBtn).click();
    }
}
