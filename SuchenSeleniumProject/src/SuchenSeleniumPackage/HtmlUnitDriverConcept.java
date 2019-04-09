package SuchenSeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");

		//WebDriver driver = new ChromeDriver();

		// htmlunitdriver is not available in Selenium 3.x version
		// htmlunitdriver -- to use this concept, we have to download htmluntidriver JAR
		// file.

		// advantages:
		// 1.testing is happening behind the scene -- no browser is launched
		// 2.Very fast -- execution of test cases -- very fast -- perfomance of the
		// script
		// 3.not suitable for Action class -- user actions -- mouse movements , double
		// click, drag and drop
		// 4.Ghost Driver -- Headless Browser:
		// HtmlUnit Driver -- Java
		// PhantomJS -- JavaScript

		WebDriver driver = new HtmlUnitDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		System.out.println("Before login, title is:===" + driver.getTitle());
		
		driver.findElement(By.id("email")).sendKeys("suchendrags@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Jaiamrrajrajsuc1975");

		driver.findElement(By.xpath("//input[@id='u_0_2']")).click();

		// Thread.sleep(200);

		System.out.println("after login, title is:===" + driver.getTitle());

	}

}
