package com.reports;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.ConstantGlobal;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(ConstantGlobal.EXTENT_REPORT_PATH);
        reporter.config().setReportName("Extent Report | Hoan Tester");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java Course 04/2022 | Hoan Tester");
        extentReports.setSystemInfo("Author", ConstantGlobal.AUTHOR);
        return extentReports;

    }

}
