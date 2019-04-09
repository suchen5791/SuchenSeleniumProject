package SuchenSeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitExplicitWaitSynchronization {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicitly wait -- is always applied globally -- is available for all the web
		// dynamic in nature
		// it can be changed anywhere and at any time in your code
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Explicitly wait
		driver.get("https://www.facebook.com");
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement mobileNum = driver.findElement(By.name("reg_email__"));
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		WebElement forgotAccount = driver.findElement(By.linkText("Forgot account?"));

		sendKeys(driver, firstName, 10, "Tom");
		sendKeys(driver, lastName, 5, "Peter");
		sendKeys(driver, mobileNum, 5, "987879123");
		sendKeys(driver, password, 10, "test@1234");
		clickOn(driver, forgotAccount, 5);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// now implicitly wait will be 30 seconds

	}

	// Explicit Wait:
	// 1.no explicit keyword method
	// 2.available with WebDriverWait with some ExpectedConditions
	// 3.specific to element
	// 4.dynamic in nature
	// 5.we should never use implicit wait and explicit wait together:
	// --selenium WD will wait for element first because of IMPLICIT WAIT and then
	// Explicit wait will be applied
	// hence , total sync wait will be increased for each element
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
