import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;
import utils.DataUtil;

public class RenegotiationTest extends TestBase {

    @Test
    public void renegotiation(){

        String cpfCnpj = DataUtil.readPropertie("cpfCnpj");

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = DataUtil.readPropertie("contractNumber");

        HomePage home = new HomePage(driver);
        home.closePopUp().selectContract(contract).accessFinancialReorganization().confirmContract();

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
    }
}
