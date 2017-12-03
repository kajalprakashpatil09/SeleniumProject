package switchWindowFrames;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
* This class explains how to switch focus to Iframe.
*/

public class SwitchIframe {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://letskodeit.teachable.com/p/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void switchFrame() throws InterruptedException {

		driver.switchTo().frame("iframe-name");
		Thread.sleep(3000);

		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("Python");
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).sendKeys("Test Done");
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
