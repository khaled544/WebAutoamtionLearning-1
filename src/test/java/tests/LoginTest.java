package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest {


	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testValidLogin() {
	LoginPage loginpage = new LoginPage(driver);
	
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.clickSubmit();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	System.out.println("Title of the page is : " + driver.getTitle());
	
	}
}
