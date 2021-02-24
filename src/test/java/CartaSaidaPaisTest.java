import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;
import utils.DataUtil;

public class CartaSaidaPaisTest extends TestBase {

    @Test
    public void cartaSaidaPaisTest(){

        LoginPage login = new LoginPage(driver);
        login.login("39871347987");

        String contract = "70008191085";

        HomePage home = new HomePage(driver);
        home.closePopUp()
                .selectContract(contract)
                .accessOperation(OperationsEnum.CARTAS_E_DOCUMENTOS)
                .confirmContract();

        LettersAndDocumentsPage lettersAndDocuments = new LettersAndDocumentsPage(driver);
        lettersAndDocuments.selectLetterOrDocument(OperationsEnum.CARTA_SAIDA_PAIS).request();

        AutorizazaoSaidaPaisPage autorizazaoSaidaPais = new AutorizazaoSaidaPaisPage(driver);
        autorizazaoSaidaPais.selectCountryOfVisit().clickAdd().requestGreenLetter();

        Assert.assertTrue(autorizazaoSaidaPais.checkTicketMessage());
    }
}