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

    @FindBy(css = "ul[id='ulMenuCdc'] strong[class='ng-binding']")
    public WebElement cdcContractText;

    @FindBy(xpath = "//ul[@class='submenu leasing']/li/a")
    public List<WebElement> operationOptions;
}
