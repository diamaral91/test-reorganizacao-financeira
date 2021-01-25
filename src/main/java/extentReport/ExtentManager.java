package extentReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import utils.DateUtil;

public class ExtentManager {

    private static ExtentReports extent;
    private final static String FILEPATH = System.getProperty("user.dir") + "/reports/";
    private static String FILENAME = "report_" + new DateUtil("dd.MM.yy_hh.mm").dateTime() + ".html";

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(FILEPATH + FILENAME, true, NetworkMode.ONLINE);

            extent
                    .addSystemInfo("Host Name", "URA")
                    .addSystemInfo("Environment", "HML");
        }
        return extent;
    }
}
