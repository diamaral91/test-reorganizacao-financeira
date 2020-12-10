package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormalizationObject {

    public FormalizationObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[contains(text(),'Formaliza')]")
    public WebElement formalizationText;

    @FindBy(css = "//label[text()='Novo valor da parcela']/parent::div/span")
    public WebElement newInstallmentValueText;

    @FindBy(css = "[ng-click='confirmSimulation()']")
    public WebElement confirmSimulationBtn;
}
