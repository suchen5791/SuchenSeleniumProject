package SuchenSeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://reg.ebay.ca/reg/PartialReg");

		// 1. By.xpath
		driver.findElement(By.xpath("//*[@id=\'firstname\']")).sendKeys("Suchen");
		driver.findElement(By.xpath("//*[@id=\'lastname\']")).sendKeys("Goud");
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("abc@fmail.com");

		// 2. By.id
		driver.findElement(By.id("firstname")).sendKeys("tom");
		driver.findElement(By.id("lastname")).sendKeys("smith");
		driver.findElement(By.id("email")).sendKeys("abc@gaa.com");

		// 3.By.name
		driver.findElement(By.name("firstname")).sendKeys("mat");
		driver.findElement(By.name("lastname")).sendKeys("ram");

		// 4.By.linkText
		driver.findElement(By.linkText("Sign in")).click();

		// 5.By.partialLinkText
		driver.findElement(By.partialLinkText("User")).click();

		// 6.By.cssSelector
		driver.findElement(By.cssSelector("#firstname")).sendKeys("jones");
		driver.findElement(By.cssSelector("#showPASSWORD > ul > li > span.checkbox.gspr.chk-off > input")).click();

		// 7.By.className
		driver.findElement(By.className("fld wide wide fld regular-text bold-text float-box")).sendKeys("rock");
	}

}
