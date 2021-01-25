import enums.OperationsEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculationWorksheetPage;
import pages.HomePage;
import pages.LettersAndDocumentsPage;
import pages.LoginPage;
import support.TestBase;
import utils.DataUtil;

public class EncerramentoLeasingTest extends TestBase {

    @Test
    public void encerramentoLeasing(){

        String cpfCnpj = DataUtil.readPropertie("cpfCnpj");

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        HomePage home = new HomePage(driver);
        home.closePopUp().clickHomePage().selectInformation(OperationsEnum.ENCERRANDO_LEASING);

        Assert.assertTrue(DataUtil.checkFile(driver, ""));
    }
}