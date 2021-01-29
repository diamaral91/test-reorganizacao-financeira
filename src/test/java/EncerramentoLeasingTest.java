import enums.OperationsEnum;
import objects.TermClosureObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import support.TestBase;
import utils.DataUtil;

public class EncerramentoLeasingTest extends TestBase {

    @Test
    public void encerramentoLeasing(){

        String cpfCnpj = "10360865852";

        LoginPage login = new LoginPage(driver);
        login.login(cpfCnpj);

        String contract = "70008236650";

        HomePage home = new HomePage(driver);
        home.selectLeasingContract(contract)
                .accessOperation(OperationsEnum.ENCERRANDO_LEASING)
                .confirmContract();

        TermClosurePage termClosure = new TermClosurePage(driver);
        termClosure.requestLeasingClosure();

        termClosure.clickTermClosureLeasing();

        Assert.assertTrue(DataUtil.closeTab(driver));
    }
}