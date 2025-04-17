package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.configReader;
import utils.extentReportManager;
import utils.screenshotUtility;

//import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.lang.reflect.Method;

//@Listeners(ChainTestListener.class)
public class BaseTest {


	protected WebDriver driver;
	protected Properties prop;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeMethod
	public void setUp(Method method) {
		prop = configReader.initProperties();

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	
		
		extent = extentReportManager.getInstance();
		test = extent.createTest(method.getName());
	}
	
	@AfterMethod
		public void tearDown(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotPath = screenshotUtility.captureScreenshot(driver, result.getName());
				test.fail(result.getThrowable());
				test.addScreenCaptureFromPath(screenshotPath);
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.pass("Test passed");
			} else if (result.getStatus() == ITestResult.SKIP) {
				test.skip("Test skipped");
			}
			driver.quit();
			extent.flush();
		}
}

