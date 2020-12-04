package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrentInformationObject {

    public CurrentInformationObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-ng-model='form.installment']")
    public WebElement newInstallmentSelect;

    @FindBy(css = "[data-ng-model='form.dueDate']")
    public WebElement firstDueDateSelect;

    @FindBy(css = "[ng-click='consultSimulation()']")
    public WebElement consultSimulationBtn;

    @FindBy(xpath = "//label[text()='Nº do financiamento']/parent::div/span")
    public WebElement fundingNumber;

    @FindBy(xpath = "//label[text()='Forma de pagamento']/parent::div/span")
    public WebElement formPayment;

    @FindBy(css = "[ng-click='consultSimulation()']")
    public WebElement consultSimulation;
}
