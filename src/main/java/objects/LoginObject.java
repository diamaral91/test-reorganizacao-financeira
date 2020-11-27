package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObject {

    public LoginObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy()
    public WebElement cpfCnpj;

    @FindBy()
    public WebElement password;

    @FindBy()
    public WebElement cokkies;

    @FindBy()
    public WebElement login;
}
