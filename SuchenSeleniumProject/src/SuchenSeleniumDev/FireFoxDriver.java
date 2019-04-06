package SuchenSeleniumDev;

public class FireFoxDriver implements WebDriver {

	public FireFoxDriver() {
	System.out.println("launch fire fox browser");
}

public void get(String url) {
	System.out.println("launch url " + url);

}

public void findElement(String locator) {
	System.out.println("finding the element " + locator);

}

public void close() {
	System.out.println("close the browser");

}

public void quit() {
	System.out.println("quit all the browser");

}

}
