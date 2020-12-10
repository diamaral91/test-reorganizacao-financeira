import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;

public class RenegotiationTest extends TestBase {

    @Test
    public void poc(){
        LoginPage login = new LoginPage(driver);
        login.login("07866156000107");

        HomePage home = new HomePage(driver);

        String contract = "32308450";
        home.accessOperation(contract);

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

        String expectedResult = "Reorganiza��o realizada com sucesso!\n" +
                "Os documentos ser�o enviados para o e-mail informado. Isso pode levar at� 30min. Certifique-se de verificar sua caixa de spam.\n" +
                "FECHAR";

        Assert.assertEquals(message, expectedResult);
    }
}
