import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;

public class RenegotiationTest extends TestBase {

    @Test
    public void poc(){
        LoginPage login = new LoginPage(driver);
        login.login("10360865852");

        HomePage home = new HomePage(driver);

        String contract = "31131613";
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

        String expectedResult = "Reorganização realizada com sucesso!\n" +
                "Os documentos serão enviados para o e-mail informado. Isso pode levar até 30min. Certifique-se de verificar sua caixa de spam.\n" +
                "FECHAR";

        Assert.assertEquals(message, expectedResult);
    }
}
