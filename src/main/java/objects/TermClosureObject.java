package objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermClosureObject {

    public TermClosureObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[ng-click=\"requestDocument()\"]")
    public WebElement requestLeasingClosureButton;

    @FindBy(css = "[ng-click=\"checkPdf('3')\"]")
    public WebElement termClosureLeasingButton;

    @FindBy(css = "ng-click=\"checkPdf('1')\"")
    public WebElement closureManualButton;
}
