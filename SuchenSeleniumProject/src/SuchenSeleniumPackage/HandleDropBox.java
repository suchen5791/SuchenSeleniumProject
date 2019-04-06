package SuchenSeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		
		//handle drop box:
		Select select = new Select(driver.findElement(By.id("testingDropdown")));
		select.selectByVisibleText("Manual Testing");
		
		
		

	}

}
