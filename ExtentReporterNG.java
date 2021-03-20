package com.Listener;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	public static ExtentReports getReportObject()

	{

		String path = System.getProperty("user.dir") + "\\reports\\ExtentReport.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("ExtentReport");

		reporter.config().setDocumentTitle("Extent Report");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester    ", "Digambar Khodse");

		return extent;

	}
}
