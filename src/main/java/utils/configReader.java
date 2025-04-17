package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	private static Properties prop;

	public static Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Config file not found or unable to load.");
			e.printStackTrace();
		}
		return prop;
	}
}
