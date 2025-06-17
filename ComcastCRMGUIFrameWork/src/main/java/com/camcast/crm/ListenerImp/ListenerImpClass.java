package com.camcast.crm.ListenerImp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.generic.baseUtility.BaseClass;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	public static ExtentTest test;
	public ExtentReports reporter;

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		test.log(Status.INFO, "==the test suit is finished==");
		reporter.flush();
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("Crm Reporter");
		spark.config().setTheme(Theme.DARK);

		reporter = new ExtentReports();
		reporter.attachReporter(spark);
		reporter.setSystemInfo("OS", "WINDOWS-10");
		reporter.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println("==" + result.getMethod().getMethodName() + "==");
		String methodname = result.getMethod().getMethodName();
		TakesScreenshot screenShot = (TakesScreenshot) BaseClass.sdriver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		String filePath = screenShot.getScreenshotAs(OutputType.BASE64);
		File dest = new File("./screenshot/" + methodname + "" + time + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromBase64String(filePath, methodname + time);
		test.log(Status.INFO, "failed testCase");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		System.out.println("test skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		test = reporter.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, "test start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		test.log(Status.INFO, "test pass");
	}

}
