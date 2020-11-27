import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import support.TestBase;

public class PocTest extends TestBase {

    @Test
    public void poc(){
        LoginPage login = new LoginPage(driver);
        login.login("");

        HomePage home = new HomePage(driver);
        home.accessOperation();
    }
}