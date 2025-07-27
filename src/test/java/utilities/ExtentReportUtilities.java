package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseTestcaseClass;

public class ExtentReportUtilities implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String FileName;
	
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		FileName = "Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+FileName);
		
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
		sparkReporter.config().setReportName("OpenCart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application Name", "Open Cart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("OS", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Broswer", browser);
		
		List<String> groupsList = context.getCurrentXmlTest().getIncludedGroups();
		if(!groupsList.isEmpty()) {
			extent.setSystemInfo("Groups", groupsList.toString());
		}
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());// Displaying Group Name
		test.log(Status.PASS, "Test Case Passes is : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, "Test Case Failed is : "+result.getName());
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String path = new BaseTestcaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(path);
			System.out.println(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Case Skipped is : "+result.getName());
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
		
		String pathOfReport = System.getProperty("user.dir")+"\\reports\\"+FileName;
		File extentReport = new File(pathOfReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
