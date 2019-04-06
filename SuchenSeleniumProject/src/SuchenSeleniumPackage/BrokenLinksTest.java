package SuchenSeleniumPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrokenLinksTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("suchendrags");
		driver.findElement(By.id("pass")).sendKeys("Jaiamrrajrajsuc1975");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));
        
        List<WebElement> activeLinks = new ArrayList<WebElement>();
        
        //2. iterate linksList :
        for(int i=0; i<linksList.size(); i++) {
        	if(linksList.get(i).getAttribute("href")!= null) {
        		activeLinks.add(linksList.get(i));
        	}
        }
        
        //get the size of active links list:
        System.out.println("size of active links and images --> "+activeLinks.size());
        
        
        
		
		
		
		
		
		
		
		

	}

}
