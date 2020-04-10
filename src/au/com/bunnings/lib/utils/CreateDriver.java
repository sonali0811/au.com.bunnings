package au.com.bunnings.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	// Method to initialize Browser
	public static WebDriver getBrowserInstance() {

		// Create Browser Reference
		WebDriver driver;

		// Read Browser Information from Configuration Properties File
		String browser = DataHandlers.readDataFromProperties("config-data", "browser");

		// Read URL from Configuration Properties File
		String url = DataHandlers.readDataFromProperties("config-data", "url");

		// Initialize Browser based on Configuration Properties file data
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./browser-servers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.err.print("Invalid Browser Information, Please check config-data/config-data.properties file");
			return null;
		}

		// Maximize the Browser Window
		driver.manage().window().maximize();

		// Define implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Open URL read from the Configuration Properties file
		driver.get(url);

		// Return browser reference
		return driver;
	}
}
