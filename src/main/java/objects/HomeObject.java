package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeObject {

    public HomeObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Fique por dentro!']")
    public WebElement popUpText;

    @FindBy(css = "a[ng-click='close()']")
    public WebElement seeMyMessagesButton;

    @FindBy(xpath = "//a[text()='Homepage']")
    public WebElement homePageButton;

    @FindBy(css = "ul[id='ulMenuCdc'] strong[class='ng-binding']")
    public WebElement cdcContractText;

    @FindBy(id = "filterContractsCDCInputMenu")
    public WebElement filterContractInput;

    @FindBy(xpath = "//ul[@class='submenu leasing']/li/a")
    public List<WebElement> operationOptions;

    @FindBy(css = "#ulMenuCdc > li > a > span > strong")
    public List<WebElement> contractsList;

    @FindBy(css = "[data-ng-click='botaoSim()']")
    public WebElement yesBtn;

    @FindBy(css = "[ng-click='handleGenericClick(item)']")
    public List<WebElement> importantInfoButton;
}
