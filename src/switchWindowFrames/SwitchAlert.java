package switchWindowFrames;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
* This class opens a URL in Chrome browser and identifies web element by linkText.
*/
public class SwitchAlert {
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
	public void switchAlert() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);

	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
