package findElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
* This class opens a URL in Chrome browser and identifies web element by linkText.
*/

public class FindbyLinkText {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		String baseURL = "https://demostore.x-cart.com/";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(baseURL);
		Thread.sleep(2000);

		System.out.println("Finding element by linktext");
		driver.findElement(By.linkText("Shipping")).click();

		driver.quit();
	}

}
