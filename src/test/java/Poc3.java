import org.testng.annotations.Test;
import pages.FillDetailsBelowPage;
import support.TestBase;

public class Poc3 extends TestBase {

    @Test
    public void poc3(){
        new FillDetailsBelowPage(driver).checkDocuments();
    }
}
