package SuchenSeleniumPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		//*[@id="customers"]/tbody/tr[2]/td[2]
		
		String beforeXpath_company = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_company = "]/td[1]";
		
		String beforeXpath_contact = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_contact = "]/td[2]";
		
		//total number of rows get dynamically
		 List<WebElement> rows =driver.findElements(By.xpath("//table[@id='customers']//tr"));
		 System.out.println("total number of rows = " +(rows.size()-1));//-1 is for heading
		 int rowCount = rows.size();
		 
		 Xls_Reader reader = new Xls_Reader("path for the xl sheet");
		 reader.addSheet("TableData name of the sheet");
		 
		 if(!reader.isSheetExist("TableData")) {
			 reader.addSheet("TableData");
			 reader.addColumn("TableData", "CompanyName");
			 reader.addColumn("TableData", "ContactName");
		 }
		 
		
		for (int i =2; i<=rowCount; i++) {
			String actualXpath = beforeXpath_company+i+afterXpath_company;
			String companyName =driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println(companyName);
			reader.setCellData("TableData", "CompanyName", i, companyName);
			
			String actualXpath_contact = beforeXpath_contact+i+afterXpath_contact;
			String contactName = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contactName);
			reader.setCellData("TableData", "ContactName", i, contactName);
		}

	}

}
