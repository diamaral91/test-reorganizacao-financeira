package pages;

import com.relevantcodes.extentreports.LogStatus;
import enums.OperationsEnum;
import extentReport.ExtentTestManager;
import objects.LettersAndDocumentsObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

public class LettersAndDocumentsPage {

    private DriverWait wait;
    private LettersAndDocumentsObject lettersAndDocumentsObject;

    public LettersAndDocumentsPage(WebDriver driver){
        wait = new DriverWait(driver);
        lettersAndDocumentsObject = new LettersAndDocumentsObject(driver);
        PageFactory.initElements(driver, this);
    }

    public LettersAndDocumentsPage selectLetterOrDocument(OperationsEnum desejado){
        wait.interactElementWithText(lettersAndDocumentsObject.letterDocumentButton, desejado.getOperation()).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "letter or document: " + desejado);
        return this;
    }

    public LettersAndDocumentsPage clickDiscountLetter(){
        wait.elementToBeClickable(lettersAndDocumentsObject.discountLetterButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "discount letter");
        return this;
    }

    public LettersAndDocumentsPage clickLetterProofPayment(){
        wait.elementToBeClickable(lettersAndDocumentsObject.LetterProofPaymentButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Letter of Proof of Payment");
        return this;
    }

    public void request(){
        wait.elementToBeClickable(lettersAndDocumentsObject.requestButton).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "request file");
    }
}
