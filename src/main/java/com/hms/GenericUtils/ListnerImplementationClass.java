package com.hms.GenericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.bytebuddy.implementation.bind.MethodNameEqualityResolver;

public class ListnerImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"---Testscript execution start from here---");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,  MethodName+"---->PASSES");
		Reporter.log(MethodName+"---Testscript executed successfully==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	String fs=result.getMethod().getMethodName();
	String fsscript = fs+new JavaUtils().systemDateInFormat();
	test.addScreenCaptureFromPath(fsscript);
	try {
		WebdriverUtils.Takescreenshot(BaseClass.sdriver, fs);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.log(Status.FAIL, result.getThrowable());
	test.log(Status.FAIL, fsscript+"--->Failed");
	Reporter.log(fsscript+"----->Testscript execution failed");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"-----> Testscript execution Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("HMS");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("PatientBookAppointment");
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Base-Browser", "chrome");
		 report.setSystemInfo("url", "http://rmgtestingserver/domain/Hospital_Management_System/");
		 report.setSystemInfo("ReporterName", "Poojita");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
