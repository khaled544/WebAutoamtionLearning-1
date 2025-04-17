package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	private By emailUsernameField = By.xpath("//input[@class='email']");
	private By passwordField = By.xpath("//input[@class='password']");
	private By submitButton = By.xpath("//button[@type='submits']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public void enterUsername(String username) {
		driver.findElement(emailUsernameField).clear();
		driver.findElement(emailUsernameField).sendKeys(username);
		
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
		
	}
	
	public void clickSubmit() {
		driver.findElement(submitButton).click();
		
	}
	}

