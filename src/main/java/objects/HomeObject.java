package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObject {

    public HomeObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy()
    private WebElement cpfCnpj;

    @FindBy()
    private WebElement password;

    @FindBy()
    private WebElement cokkies;

    @FindBy()
    private WebElement login;
}
