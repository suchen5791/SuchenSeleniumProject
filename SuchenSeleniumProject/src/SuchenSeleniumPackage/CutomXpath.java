package SuchenSeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CutomXpath {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		
		//Absolute xpath: not recommended
		//*[@id='headersearchbar']/div/div[2]/table/tbody/tr/td[2]/input
		//1.Performance issue
		//2.not reliable
		//3.can be changed at any time in future
		
//		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("java");
//		driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("selenium");
//		
//		driver.findElement(By.xpath("//input[contains(@name,'_nkw')]")).sendKeys("rock");
		
		//dynamic id: input
		//id = test_123
		//By.id("test_123")
//		driver.findElement(By.xpath("//input[contains(@id,'test_') ]")).sendKeys("sand");
		
		//starts-with
		//id = test_456
		//id = test_789
		//id = test_test_7890_test
//		driver.findElement(By.xpath("//input[starts-with(@id, 'test_')]")).sendKeys("water");
		
		//ends-with
		//id = 1234_test_t
		//id = 23456_test_t
		//id = 6789_test_t
//		driver.findElement(By.xpath("//input[ends-with(@id, '_test_t')]")).sendKeys("pan");
		
		//links
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		

	}

}
