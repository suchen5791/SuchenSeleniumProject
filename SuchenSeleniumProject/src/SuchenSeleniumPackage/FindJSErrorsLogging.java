package SuchenSeleniumPackage;

import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindJSErrorsLogging {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		LoggingPreferences logginPreferences = new LoggingPreferences();
		logginPreferences.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logginPreferences);
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver(capabilities);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void extractJSLogsInfo() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp())+" "+ entry.getLevel()+" "+ entry.getMessage());
					}
		
	}
	
	@Test
	public void testMethod() {
		driver.get("http://www.facebook.com");
		extractJSLogsInfo();
	}

}
