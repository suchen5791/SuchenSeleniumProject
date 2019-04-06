package SuchenSeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
//		driver.get("https://classic.crmpro.com/index.html?e=1");
//		driver.findElement(By.name("username")).sendKeys("naveen");
//		driver.findElement(By.name("password")).sendKeys("test@123");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();	 
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).sendKeys("this is atest");
		driver.quit();
		
		
		
		
		

	}

}
