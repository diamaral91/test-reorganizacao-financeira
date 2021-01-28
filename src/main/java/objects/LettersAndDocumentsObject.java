package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LettersAndDocumentsObject {

    public LettersAndDocumentsObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-ng-click='selectItem(doc.id)']/span")
    public List<WebElement> letterDocumentButton;

    @FindBy(id = "send-button")
    public WebElement requestButton;

    @FindBy(id = "document-2")
    public WebElement discountLetterButton;

    @FindBy(css = "#document-1 > span")
    public WebElement LetterProofPaymentButton;
}
