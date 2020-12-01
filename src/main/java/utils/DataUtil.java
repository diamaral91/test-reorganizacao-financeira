package utils;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataUtil {

    public static String readPropertie(String propertie){
        InputStream inputStream;
        Properties prop = new Properties();
        try {
            String filePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";

            inputStream = DataUtil.class.getClassLoader().getResourceAsStream(filePath);

            if (inputStream != null) {
                prop.load(inputStream);
            }

            inputStream.close();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, "properties or file not found");
        }
        return prop.getProperty(propertie);
    }

    public static List<String> readCsv(String field){
        List<String> values = new ArrayList<>();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("pathToCsv"));
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if ("cpfCnpj".equalsIgnoreCase(field)) {
                    values.add(data[0]);
                } else if ("senha".equalsIgnoreCase(field)) {
                    values.add(data[1]);
                }
            }
            csvReader.close();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, "field not found: " + field);
        }
        return values;
    }
}
