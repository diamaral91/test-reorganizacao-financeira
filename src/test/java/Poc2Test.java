import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;

public class Poc2Test extends TestBase {

    @Test
    public void poc(){
        LoginPage login = new LoginPage(driver);
        login.login("01220601000172");

        HomePage home = new HomePage(driver);

        String contract = "32353849";
        home.accessOperation(contract);

        HowWorkItPage howWorkIt = new HowWorkItPage(driver);
        howWorkIt.simulateRenegotiation();

        CurrentInformationPage currentInformation = new CurrentInformationPage(driver);
        currentInformation.summaryOfCurrentFunding(contract, "Boleto")
                .selectBestOption();

        FormalizationPage formalization = new FormalizationPage(driver);
        formalization.checkFormalization();

        FillDetailsBelowPage fillDetailsBelow = new FillDetailsBelowPage(driver);
        String message = fillDetailsBelow.completeProcess();

        String expectedResult = "\n" +
                "Reorganização realizada com sucesso!\n" +
                "Os documentos serão enviados para o e-mail informado. Isso pode levar até 30min. Certifique-se de verificar sua caixa de spam.";

        Assert.assertEquals(message, expectedResult);
    }
}
