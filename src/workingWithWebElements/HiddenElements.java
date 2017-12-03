package workingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * This class explains to identify hidden elements on webpage. 
 */

public class HiddenElements {
	WebDriver driver;
	String baseURL;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://letskodeit.teachable.com/p/practice";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testLetKodeIt() throws InterruptedException {

		driver.get(baseURL);
		js.executeScript("window.scrollBy(0,600);");

		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text box displayed? " + textBox.isDisplayed());

		Thread.sleep(3000);
		System.out.println("Click on Hide button");
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Text box displayed? " + textBox.isDisplayed());

		Thread.sleep(3000);
		System.out.println("Click on Show button");
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Text box displayed? " + textBox.isDisplayed());

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
