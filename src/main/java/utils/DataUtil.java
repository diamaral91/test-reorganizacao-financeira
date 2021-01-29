package utils;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataUtil {

    private static String userPath = System.getProperty("user.home");
    private static String folder = "/Downloads/";

    public static String readPropertie(String propertie){
        Properties prop = new Properties();
        try {
            String filePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
            InputStream inputStream = new FileInputStream(filePath);

            prop.load(inputStream);

            inputStream.close();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, "properties or file not found");
        }
        return prop.getProperty(propertie);
    }

    public static List<String> readCsv(String field){
        List<String> values = new ArrayList<>();

        String pathToCsv = System.getProperty("user.dir") + "/src/main/resources/datapool.csv";
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if ("cpfCnpj".equalsIgnoreCase(field)) {
                    values.add(data[1]);
                } else if ("contrato".equalsIgnoreCase(field)) {
                    values.add(data[0]);
                }
            }
            csvReader.close();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, "field not found: " + field);
        }
        values.remove(0);
        return values;
    }

    public static boolean checkFile(String fileName){
        boolean validate = false;
        int count = 0;

        while(count < 10) {
            File file = new File(userPath + folder + fileName);
            validate = file.exists();

            if(validate == true) {
                ExtentTestManager.getTest().log(LogStatus.INFO, "file: " + fileName + " " + validate);
                file.delete();
                break;
            } else {
                count++;
                Utils.sleep(1);
            }
        }
        return validate;
    }

    public static boolean closeTab(WebDriver driver){
        int count =0;
        while (count < 10) {
            try {
                Utils.sleep(1);
                List<String> abas = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(abas.get(1)).quit();
                break;
            } catch (IndexOutOfBoundsException e) {
                count++;
            }
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "closed tab");
        return true;
    }

    public static boolean findFile(String name){
        List<String> files = readFiles();
        for(String file : files) {
            if(file.matches(name)){
                return true;
            }
        }
        return false;
    }

    private static List<String> readFiles() {
        List<String> filesName = new ArrayList<>();

        File file = new File(userPath + folder);
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            filesName.add(arquivos.getName());
        }
        return filesName;
    }
}
