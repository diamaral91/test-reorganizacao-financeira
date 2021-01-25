package pages;

import objects.ContractInstallmentsObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;
import utils.DataUtil;
import utils.Utils;

public class ContractInstallmentsPage {

    private WebDriver driver;
    private DriverWait wait;
    private ContractInstallmentsObject contractInstallmentsObj;

    public ContractInstallmentsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new DriverWait(driver);
        this.contractInstallmentsObj = new ContractInstallmentsObject(driver);
        PageFactory.initElements(driver, this);
    }

    public ContractInstallmentsPage generateContract(){
        wait.waitToElementClickNotIntercepted(contractInstallmentsObj.gerarBoleto);
        return this;
    }

    public String contractTitle(){
        Utils.sleep(3);
        return wait.elementToBeVisibility(contractInstallmentsObj.tituloListagem).getText();
    }

    public boolean checkBoleto(String contract){
        String fileName = contract;
        return DataUtil.checkFile(driver, fileName);
    }
}
