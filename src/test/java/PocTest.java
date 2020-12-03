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

import java.util.List;

public class PocTest extends TestBase {

    @Test
    public void poc(){
        List<String> cpfsCnpjs = DataUtil.readCsv("cpfCnpj");
        List<String> contracts = DataUtil.readCsv("cpfCnpj");
        for(int count=0; count < cpfsCnpjs.size(); count++) {
            try {
                LoginPage login = new LoginPage(driver);
                login.login(cpfsCnpjs.get(count));

                HomePage home = new HomePage(driver);
                home.accessOperation(contracts.get(count));
            } catch (WebDriverException | NullPointerException e) {
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
