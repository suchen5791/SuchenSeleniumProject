package SuchenSeleniumPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http:/www.google.com");
		
        //Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//now copy the screen shot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("C:\\Users\\suchendrags\\Documents\\workspace-sts-3.9.7.RELEASE\\SuchenSeleniumProject\\src\\SuchenSeleniumPackage/google.png"));

	}

}
