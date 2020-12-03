package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HowWorkItObject {

    public HowWorkItObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[ng-click='stepSimulation()']")
    public WebElement simulateRenegotiationBtn;
}
