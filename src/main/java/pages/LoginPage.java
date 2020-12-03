package pages;

import objects.LoginObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;

public class LoginPage {

    private DriverWait wait;
    private LoginObject loginObject;

    public LoginPage(WebDriver driver){
        wait = new DriverWait(driver);
        loginObject = new LoginObject(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String cpfCnpj){
        wait.elementToBeClickable(loginObject.cokkieButton).click();
        wait.elementToBeVisibility(loginObject.cpfCnpjInput).sendKeys(cpfCnpj);
        wait.elementToBeVisibility(loginObject.passwordInput).sendKeys("Rci@123*");
        wait.elementToBeClickable(loginObject.loginButton).click();
    }
}
