package findElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* 
* This class opens a URL in Firefox browser and identifies web element by ID and Name.
*/

public class FindByNameAndID {

	public static void main(String[] args) throws InterruptedException {
		String baseURL = "http://www.google.com";
		WebDriver driver;

		driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.driver",
				"C:\\Users\\kajal\\Desktop\\Job\\Downloads\\geckodriver-v0.14.0-win64.exe");

		driver.get(baseURL);

		driver.findElement(By.id("gs_htif0")).sendKeys("Element identification by ID");
		System.out.println("Search textbox identified by ID");
		Thread.sleep(3000);

		System.out.println("Identify search button by Name");
		driver.findElement(By.name("btnK")).click();
		System.out.println("Clicked on Google Search button");

		Thread.sleep(3000);
		driver.quit();
	}

}
