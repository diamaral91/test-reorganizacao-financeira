package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutorizazaoSaidaPaisObject {

    public AutorizazaoSaidaPaisObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-ng-model='country']")
    public WebElement countrySelect;

    @FindBy(className = "download")
    public WebElement downloadButton;

    @FindBy(css = "[data-ng-click='addCountry()']")
    public WebElement addButton;

    @FindBy(xpath = "//p[contains(@class,'text-message-carta')]")
    public WebElement ticketMessage;
}
