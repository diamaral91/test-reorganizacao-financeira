package support;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentManager;
import extentReport.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DataUtil;
import utils.ScreenshotUtil;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class TestBase {

    public WebDriver driver;
    private ExtentReports extent = null;

    @BeforeMethod
    public void beforeMethod(Method method) {
        driver = Browsers.getChrome();

        String url = DataUtil.readPropertie("url.hml.renault");
        driver.get(url);
        driver.manage().window().maximize();

        ExtentTestManager.startTest(method.getName());
    }

    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        }

        ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest()
                .addBase64ScreenShot(ScreenshotUtil.captureEvidence(driver)
                ));

        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();

//        driver.quit();
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}
