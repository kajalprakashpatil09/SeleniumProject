package browserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* 
 * This class explains running Selenium test on Firefox  browser.
 */
public class FirefoxDriverDemo {

	public static void main(String[] args) throws InterruptedException {

		String baseURL = "http://www.google.com";
		WebDriver driver;

		driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.driver",
				"C:\\Users\\kajal\\Desktop\\Job\\Downloads\\geckodriver-v0.14.0-win64.exe");
		driver.get(baseURL);

		System.out.println("Launched application on Firefox browser");
		Thread.sleep(3000);
		driver.quit();

	}

}
