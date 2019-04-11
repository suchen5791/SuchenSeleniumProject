package SuchenSeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/index.html?e=1");
		driver.findElement(By.name("username")).sendKeys("suchen");
		driver.findElement(By.name("password")).sendKeys("Jainigam@28");
		// Thread.sleep(200);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();

		driver.switchTo().frame("mainpanel");
		Thread.sleep(200);

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		// *[@id="vContactsForm"]/table/tbody/tr[4]/td[2]
		// *[@id="vContactsForm"]/table/tbody/tr[5]/td[2]
		// *[@id="vContactsForm"]/table/tbody/tr[6]/td[2]
		// *[@id="vContactsForm"]/table/tbody/tr[7]/td[2]
		// *[@id="vContactsForm"]/table/tbody/tr[8]/td[2]

		// Method-1:
		String before_xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 4; i <= 8; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);

			if (name.contains("suchi veer")) {// i=7
				// *[@id="vContactsForm"]/table/tbody/tr[7]/td[2]
				driver.findElement(By.xpath("//[*id='vContactsForm']/table/tbody/tr[" + i + "]/td[1]/input")).click();

				// Method-2:
				driver.findElement(By.xpath(
						"//a[contains(text(),'suchi veer')]/parent::td//preceding-sibling::td//input[@name='contact_id']"))
						.click();

			}

		}

	}

}
