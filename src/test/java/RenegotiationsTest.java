import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;
import utils.DataUtil;
import utils.ScreenshotUtil;

import java.util.List;

public class RenegotiationsTest extends TestBase {

    @Test
    public void poc(){
        List<String> cpfsCnpjs = DataUtil.readCsv("cpfCnpj");
        List<String> contracts = DataUtil.readCsv("contrato");
        for(int count=0; count < cpfsCnpjs.size(); count++) {
            try {
                LoginPage login = new LoginPage(driver);
                login.login(cpfsCnpjs.get(count));

                HomePage home = new HomePage(driver);

                String contract = contracts.get(count);
                home.selectContract(contract).accessFinancialReorganization().confirmContract();

                HowWorkItPage howWorkIt = new HowWorkItPage(driver);
                howWorkIt.simulateRenegotiation();

                CurrentInformationPage currentInformation = new CurrentInformationPage(driver);
                currentInformation.summaryOfCurrentFunding(contract, "Boleto")
                        .selectBestOption();

                FormalizationPage formalization = new FormalizationPage(driver);
                formalization.checkFormalization();

                FillDetailsBelowPage fillDetailsBelow = new FillDetailsBelowPage(driver);
                Assert.assertEquals(true, fillDetailsBelow.openDocuments().checkDocuments());

                String message = fillDetailsBelow.completeProcess();

                String expectedResult = "Reorganização realizada com sucesso!\n" +
                        "Os documentos serão enviados para o e-mail informado. Isso pode levar até 30min. Certifique-se de verificar sua caixa de spam.\n" +
                        "FECHAR";

                Assert.assertEquals(message, expectedResult);
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
