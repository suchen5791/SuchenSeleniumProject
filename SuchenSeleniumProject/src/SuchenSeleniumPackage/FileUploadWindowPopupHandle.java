package SuchenSeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadWindowPopupHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://html.com/input-type-file/");
         
		//type= "file" should be present for Browser/AttachFile/UploadFile buttons		
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\suchendrags\\Desktop\\test.txt");

	}

}
