package SuchenSeleniumPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		//1. ALERTS WINDOW POPUP -- javaScript Pop up - Alert API (ACCEPT, DISMISS)
		//2. FILE UPLOAD POPUP -- Browse Button (type = file, sendKeys(path)
		//3. BROWSER WINDOW POPUP -- Advertisement pop up (windowHandler API - getWindowHandles())

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.popuptest.com/goodpopups.html");

		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();

		Thread.sleep(2000);
		// getWindowHandles method used to get windowId's (parent & child)
		// this method will give a set object (but it wont store values on basis of
		// indexes) - so can't use for loop--> so use iterator
		Set<String> handler = driver.getWindowHandles();
		// hadler.iterator method will give iterator object
		// Iterator<String> is written because all the values are coming in the form of
		// String
		Iterator<String> it = handler.iterator();
		// iterator all ways points above the set object
		// to move to next location --> use it.next method (this will then point to
		// parent window)

		String parentWindowId = it.next();
		System.out.println("parent window id:" + parentWindowId);

		// it.next will now point to child window id
		String childWindowId = it.next(); 
		System.out.println("Child window id:" + childWindowId);

		// switching between parent and child windows
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		System.out.println("child window popup title" + driver.getTitle());

		// close the child window (don't use driver.quit -- will close both the windows)
		driver.close();

		// come back to parent window
		driver.switchTo().window(parentWindowId);

		System.out.println("parent window title" + driver.getTitle());

	}

}
