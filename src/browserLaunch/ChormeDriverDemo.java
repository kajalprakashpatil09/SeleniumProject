package browserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * This class explains running selenium test on Chrome browser.
 */

public class ChormeDriverDemo {

	public static void main(String[] args) throws InterruptedException {

		String baseURL = "https://www.google.com";
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(baseURL);

		Thread.sleep(3000);
		driver.quit();
	}

}
