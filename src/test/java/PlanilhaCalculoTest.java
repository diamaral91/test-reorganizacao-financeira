import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculationWorksheetPage;
import pages.HomePage;
import pages.LettersAndDocumentsPage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;

public class PlanilhaCalculoTest extends TestBase {

    @Test
    public void planilhaCalculo(){

        String cpfCnpj = DataUtil.readPropertie("cpfCnpj");

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = DataUtil.readPropertie("contractNumber");

        HomePage home = new HomePage(driver);
        home.closePopUp().selectContract(contract).accessOperation(OperationsEnum.CARTAS_E_DOCUMENTOS).confirmContract();

        LettersAndDocumentsPage lettersAndDocuments = new LettersAndDocumentsPage(driver);
        lettersAndDocuments.selectLetterOrDocument(OperationsEnum.PLANILHA_CALCULO).request();

        CalculationWorksheetPage calculationWorksheetPage = new CalculationWorksheetPage(driver);
        calculationWorksheetPage.downloadPdf();

        Assert.assertTrue(DataUtil.checkFile("PLANILHA_DE_CALCULO.pdf"));
    }
}