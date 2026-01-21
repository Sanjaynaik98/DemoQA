package com.demoqa.webautomation.utilities;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoqa.webautomation.pagebase.TestBase;

public class ExtentReportManager implements ITestListener, IAnnotationTransformer {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private String reportName;

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Retry.class);
    }

    @Override
    public void onStart(ITestContext context) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + reportName);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "DemoQA");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", System.getProperty("user.name"));

        String os = context.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = context.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser Name", browser);

        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {

        String fullTestName = result.getTestClass().getName() + "." + result.getMethod().getMethodName();

        ExtentTest test = extent.createTest(fullTestName);
        test.assignCategory(result.getMethod().getGroups());

        extentTest.set(test);
        extentTest.get().log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Case Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().log(Status.FAIL, "Test Case Failed: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, "Error Message: " + result.getThrowable());

        try {
            String imgPath = TestBase.captureScreen(result.getMethod().getMethodName());
            if (imgPath != null) {
                extentTest.get().addScreenCaptureFromPath(imgPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().log(Status.SKIP, "Test Case Skipped: " + result.getMethod().getMethodName());

        if (result.getThrowable() != null) {
            extentTest.get().log(Status.SKIP, "Reason: " + result.getThrowable().getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + reportName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}
