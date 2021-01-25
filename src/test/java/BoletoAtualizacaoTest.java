import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContractInstallmentsPage;
import pages.HomePage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;

public class BoletoAtualizacaoTest extends TestBase {

    @Test
    public void boletoAtualizacao(){

        String cpfCnpj = DataUtil.readPropertie("cpfCnpj");

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = DataUtil.readPropertie("contractNumber");

        HomePage home = new HomePage(driver);
        home.selectContract(contract).accessOperation(OperationsEnum.BOLETO_ATUALIZADO);

        ContractInstallmentsPage contractInstallments = new ContractInstallmentsPage(driver);
        contractInstallments.generateContract();

        Assert.assertEquals("PARCELAS DO CONTRATO " + contract, contractInstallments.contractTitle());

        Assert.assertTrue(contractInstallments.checkBoleto(contract + "_P_Boleto_Santander.pdf"));
    }
}
