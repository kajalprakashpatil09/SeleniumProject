package advanced;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * This class explains how to find size of the window using javascriptexecutor
 */

public class SizeOfWindow {

	WebDriver driver;
	String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {

		js.executeScript("window.location='https://letskodeit.teachable.com/p/practice';");

		long height = (long) js.executeScript("return window.innerHeight;");
		long width = (long) js.executeScript("return window.innerWidth;");

		System.out.println("Width of window :" + width);
		System.out.println("Height of window :" + height);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
