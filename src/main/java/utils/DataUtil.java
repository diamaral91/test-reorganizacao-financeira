package utils;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataUtil {

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
}
