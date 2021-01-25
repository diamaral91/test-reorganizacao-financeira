import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculationWorksheetPage;
import pages.HomePage;
import pages.LettersAndDocumentsPage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;

public class CartaImpostoRendaTest extends TestBase {

    @Test
    public void planilhaCalculo(){

        String cpfCnpj = DataUtil.readPropertie("cpfCnpj");

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = DataUtil.readPropertie("contractNumber");

        HomePage home = new HomePage(driver);
        home.selectContract(contract).accessOperation(OperationsEnum.CARTAS_E_DOCUMENTOS).confirmContract();

        LettersAndDocumentsPage lettersAndDocuments = new LettersAndDocumentsPage(driver);
        lettersAndDocuments.selectLetterOrDocument(OperationsEnum.CARTA_IMPOSTO_RENDA).request();

        CalculationWorksheetPage calculationWorksheetPage = new CalculationWorksheetPage(driver);
        calculationWorksheetPage.downloadPdf();

        Assert.assertTrue(DataUtil.checkFile(driver, "CARTAO_IMPOSTO_RENDA.pdf"));
    }
}