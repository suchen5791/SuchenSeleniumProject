package SuchenSeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsAndLinks {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.ebay.com/");

		// 1.get total count of links on the page
		// all links are represented by <a> html tag:
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		// List <WebElement> linkList1= driver.findElements(By.tagName("input"));
		// List <WebElement> linkList2= driver.findElements(By.tagName("button"));
		// size of linkList:
		System.out.println(linkList.size());

		// 2.get text of each link on the page
		for (int i = 0; i < linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
		}

	}

}
