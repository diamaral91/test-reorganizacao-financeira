import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculationWorksheetPage;
import pages.HomePage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;

import java.util.regex.Pattern;

public class SegundaViaContratoTest extends TestBase {

    @Test
    public void segundaViaContrato(){

        String cpfCnpj = DataUtil.readPropertie("cpfCnpj");

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = DataUtil.readPropertie("contractNumber");

        HomePage home = new HomePage(driver);
        home.closePopUp().selectContract(contract).accessOperation(OperationsEnum.VIA_CONTRATO).confirmContract();

        CalculationWorksheetPage calculationWorksheetPage = new CalculationWorksheetPage(driver);
        calculationWorksheetPage.downloadPdf();

        Assert.assertTrue(DataUtil.findFile(Pattern.compile(
                "\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{11}.pdf").pattern()));
    }
}