import org.testng.annotations.Test;
import pages.CurrentInformationPage;
import pages.HomePage;
import pages.HowWorkItPage;
import pages.LoginPage;
import support.TestBase;

public class Poc2Test extends TestBase {

    @Test
    public void poc(){
        LoginPage login = new LoginPage(driver);
        login.login("04573344000140");

        HomePage home = new HomePage(driver);
        home.accessOperation("31943299");

        HowWorkItPage howWorkIt = new HowWorkItPage(driver);
        howWorkIt.simulateRenegotiation();

        CurrentInformationPage currentInformation = new CurrentInformationPage(driver);
        currentInformation.selectBestOption();
    }
}
