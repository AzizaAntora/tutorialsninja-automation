package com.tutorialsninja.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extent-reports/myTestReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Aziza");
        extent.setSystemInfo("os", "Windows11");
        extent.setSystemInfo("Browser name", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test  = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED is:" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test  = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is:" + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test  = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
