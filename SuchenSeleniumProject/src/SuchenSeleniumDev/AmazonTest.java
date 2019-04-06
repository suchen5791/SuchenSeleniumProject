package SuchenSeleniumDev;

public class AmazonTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com;");
		driver.findElement("name");
		driver.close();
		driver.quit();
		
		WebDriver driver1 = new FireFoxDriver();
		driver.get("http://amazon.com;");
		driver.findElement("name");
		driver.close();
		driver.quit();
	}

}
