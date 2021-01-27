import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContractInstallmentsPage;
import pages.HomePage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;

public class BoletoQuitacaoTest extends TestBase {

    @Test
    public void boletoQuitacao(){

        String cpfCnpj = DataUtil.readPropertie("cpfCnpj");

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = DataUtil.readPropertie("contractNumber");

        HomePage home = new HomePage(driver);
        home.closePopUp().selectContract(contract).accessOperation(OperationsEnum.BOLETO_QUITACAO);

        ContractInstallmentsPage contractInstallments = new ContractInstallmentsPage(driver);
        contractInstallments.generateContract();

        Assert.assertTrue(contractInstallments.checkBoleto(contract + "_Q_Boleto_Santander.pdf"));
    }
}