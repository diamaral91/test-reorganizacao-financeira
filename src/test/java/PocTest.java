import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;
import utils.ScreenshotUtil;

import java.util.ArrayList;
import java.util.List;

public class PocTest extends TestBase {

    @Test
    public void poc(){
        List<String> cpfsCnpjs = new ArrayList<>();
        for(String cpfCnpj : cpfsCnpjs) {
            try {
                LoginPage login = new LoginPage(driver);
                login.login("");

                HomePage home = new HomePage(driver);
                home.accessOperation();
            } catch (WebDriverException e) {
                ExtentTestManager.getTest().log(LogStatus.FAIL,
                        ExtentTestManager.getTest().addScreencast(ScreenshotUtil.captureEvidence(driver)));
            }

            driver.quit();
            driver = new ChromeDriver();
            driver.get(DataUtil.readPropertie("url.hml"));
            driver.manage().window().maximize();
        }
    }
}
