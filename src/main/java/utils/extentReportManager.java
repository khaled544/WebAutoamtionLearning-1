package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportManager {

	private static ExtentReports extent;

		public static ExtentReports getInstance() {
			if (extent == null) {
				ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
				extent = new ExtentReports();
				extent.attachReporter(spark);
				extent.setSystemInfo("Tester", "Khaled");
				extent.setSystemInfo("Environment", "QA");
			}
			return extent;
		}
	}

