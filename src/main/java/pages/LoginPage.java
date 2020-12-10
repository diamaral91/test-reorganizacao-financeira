package pages;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import objects.LoginObject;
import org.openqa.selenium.TimeoutException;
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
        wait.elementToBeVisibility(loginObject.cpfCnpjInput).sendKeys(cpfCnpj);
        wait.elementToBeVisibility(loginObject.passwordInput).sendKeys("Rci@123*");
        try {
            wait.elementToBeVisibility(loginObject.cokkieButton).click();
        } catch (TimeoutException e) {
            ExtentTestManager.getTest().log(LogStatus.INFO, "enable cokkie");
        }
        wait.elementToBeClickable(loginObject.loginButton).click();

        ExtentTestManager.getTest().log(LogStatus.INFO, "login: " + cpfCnpj);
    }
}
