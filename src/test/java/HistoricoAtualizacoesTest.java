import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculationWorksheetPage;
import pages.HomePage;
import pages.LettersAndDocumentsPage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;

public class HistoricoAtualizacoesTest extends TestBase {

    @Test
    public void historicoAtualizacoes(){

        String cpfCnpj = "39871347987";

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = "20032308452";

        HomePage home = new HomePage(driver);
        home.closePopUp().selectContract(contract).accessOperation(OperationsEnum.HISTORICO_SOLICITACOES).confirmContract();

        LettersAndDocumentsPage lettersAndDocuments = new LettersAndDocumentsPage(driver);
        lettersAndDocuments.selectLetterOrDocument(OperationsEnum.PLANILHA_CALCULO).request();

        CalculationWorksheetPage calculationWorksheetPage = new CalculationWorksheetPage(driver);
        calculationWorksheetPage.downloadPdf();

        Assert.assertTrue(DataUtil.checkFile("PLANILHA_DE_CALCULO.pdf"));
    }
}