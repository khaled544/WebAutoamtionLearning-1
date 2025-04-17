package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;

public class screenshotUtility {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		String path = "screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.createDirectories(Paths.get("screenshots"));
			Files.copy(src.toPath(), Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
