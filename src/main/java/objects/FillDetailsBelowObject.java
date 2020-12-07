package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillDetailsBelowObject {

    public FillDetailsBelowObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "acceptAditivoReorg")
    public WebElement acceptAditivoReorgCheck;

    @FindBy(css = "[ng-click='confirmAccepted()']")
    public WebElement confirmAcceptedBtn;

    @FindBy(id = "success")
    public WebElement msgSuccessText;

    @FindBy(css = "[ng-click='viewAditivoReorg()']")
    public WebElement viewAditivoReorg;

    @FindBy(css = "[ng-click='viewCetReorg()']")
    public WebElement viewCetReorg;
}
