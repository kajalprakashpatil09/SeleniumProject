package workingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * This class opens a URL in Chrome and identifies the textbox based on ID/XPATH on webpage and inputs value in the textbox.
 */

public class ClickTypeElement {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://letskodeit.teachable.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {

		driver.get(baseURL);

		driver.findElement(By.xpath("//*[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("Clicked on Login button");

		driver.findElement(By.id("user_email")).sendKeys("Bryan@gmail.com");
		System.out.println("Entered email under Email Address field");

		driver.findElement(By.id("user_password")).sendKeys("hip");
		System.out.println("Entered password under Password field");
		Thread.sleep(3000);

		driver.findElement(By.id("user_password")).clear();
		System.out.println("Clear the password field");

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
