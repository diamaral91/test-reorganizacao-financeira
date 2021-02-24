package pages;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import objects.AutorizazaoSaidaPaisObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import support.DriverWait;

public class AutorizazaoSaidaPaisPage {

    private DriverWait wait;
    private AutorizazaoSaidaPaisObject autorizazaoSaidaPaisObj;

    public AutorizazaoSaidaPaisPage(WebDriver driver){
        this.wait = new DriverWait(driver);
        this.autorizazaoSaidaPaisObj = new AutorizazaoSaidaPaisObject(driver);
        PageFactory.initElements(driver, this);
    }

    public AutorizazaoSaidaPaisPage selectCountryOfVisit(){
        WebElement element = wait.elementToBeVisibility(autorizazaoSaidaPaisObj.countrySelect);
        new Select(element).selectByVisibleText("Argentina");
        ExtentTestManager.getTest().log(LogStatus.INFO, "country: Argentina");
        return this;
    }

    public AutorizazaoSaidaPaisPage clickAdd(){
        wait.waitToElementClickNotIntercepted(autorizazaoSaidaPaisObj.addButton);
        ExtentTestManager.getTest().log(LogStatus.INFO, "add");
        return this;
    }

    public void requestGreenLetter(){
        wait.elementToBeClickable(autorizazaoSaidaPaisObj.downloadButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "request letter");
    }

    public boolean checkTicketMessage(){
        return wait.elementToBeVisibility(autorizazaoSaidaPaisObj.ticketMessage).isDisplayed();
    }
}
