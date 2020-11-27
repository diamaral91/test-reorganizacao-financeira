package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObject {

    public LoginObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cpfcnpj")
    public WebElement cpfCnpjInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button-home")
    public WebElement loginButton;

    @FindBy(id = "dm876A")
    public WebElement cokkieButton;
}
