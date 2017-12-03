package findElements;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * This class explains how to find web element by class name.
 */

public class IDXpathDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		JavascriptExecutor js;
		String baseURL = "https://letskodeit.teachable.com/p/practice";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		js = (JavascriptExecutor) driver;

		driver.get(baseURL);
		js.executeScript("window.scrollBy(0,500);");

		System.out.println("Identification of web element by class name");
		WebElement nameTextbox = driver.findElement(By.className("inputs"));
		nameTextbox.sendKeys("Letskodeit");

		Thread.sleep(3000);
		driver.quit();

	}

}
