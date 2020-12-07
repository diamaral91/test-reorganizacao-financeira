package extentReport;

import com.relevantcodes.extentreports.ExtentReports;
import utils.DateUtil;

public class ExtentManager {

    static ExtentReports extent;
    final static String filePath = System.getProperty("user.dir") + "/reports/";
    private static String fileName = "report_" + new DateUtil("dd.MM.yy_hh.mm").dateTime() + ".html";

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath + fileName, true);
        }
        return extent;
    }
}
