import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;
import utils.DataUtil;

public class CartaQuitacaoTest extends TestBase {

    @Test
    public void cartaQuitacao(){

        LoginPage login = new LoginPage(driver);
        login.login("12697028749");

        String contract = "20023878372";

        HomePage home = new HomePage(driver);
        home.closePopUp()
                .selectContract(contract)
                .accessOperation(OperationsEnum.CARTAS_E_DOCUMENTOS)
                .confirmContract();

        LettersAndDocumentsPage lettersAndDocuments = new LettersAndDocumentsPage(driver);
        lettersAndDocuments.clickDiscountLetter().request();

        CalculationWorksheetPage calculationWorksheetPage = new CalculationWorksheetPage(driver);
        calculationWorksheetPage.downloadPdf();

        Assert.assertTrue(DataUtil.checkFile(driver,"download.pdf"));
    }
}