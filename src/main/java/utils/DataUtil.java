package utils;

import com.relevantcodes.extentreports.LogStatus;
import extentReport.ExtentTestManager;

import java.io.InputStream;
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
}
