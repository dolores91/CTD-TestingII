package extentReport;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance(){
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("selenium version", "4.9.1");
        return extent;
    }
}
