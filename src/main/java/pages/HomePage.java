package pages;

import objects.HomeObject;
import objects.LoginObject;
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

    public void accessOperation(){
        wait.elementToBeVisibility(home.popUpText).isDisplayed();
        wait.elementToBeClickable(home.seeMyMessagesButton).click();
        wait.elementToBeClickable(home.cdcContractText).click();
        wait.interactElementWithText(home.operationOptions, "REORGANIZAÇÃO FINANCEIRA").click();
    }
}
