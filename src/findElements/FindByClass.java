package findElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * This class opens a URL in Chrome browser and identifies web element labelled as Theme using Class.
 * 
 */
public class FindByClass {

	public static void main(String[] args) throws InterruptedException {

		String baseURL = "https://demostore.x-cart.com/";
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(baseURL);
		System.out.println("Identify web element:Theme using class");
		driver.findElement(By.className("title")).click();

		Thread.sleep(3000);
		driver.quit();

	}

}
