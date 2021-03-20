package com.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();

	@Override
	public void onTestStart(ITestResult Result) {
		test = extent.createTest(Result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		test.log(Status.PASS, "Test passed!");

	}

	@Override
	public void onTestFailure(ITestResult Result) {

		test.fail(Result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext Result) {
		extent.flush();

	}

	@Override
	public void onStart(ITestContext Result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :" + Result.getName());
	}

}
