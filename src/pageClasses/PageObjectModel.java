package pageClasses;

/* 
 * This class explains concept of Page Object Model
 */

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageClasses.SearchExpediaPage;

public class PageObjectModel {

	WebDriver driver;
	String baseURL;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://www.expedia.com/";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void mouseHover() throws InterruptedException {

		driver.get(baseURL);

		SearchExpediaPage.clickFlights(driver);
		SearchExpediaPage.sourceTextBox(driver).sendKeys("New York");
		SearchExpediaPage.destinationTextBox(driver).sendKeys("SFO");
		js.executeScript("window.scrollBy(0,300);");
		SearchExpediaPage.departDate(driver).sendKeys("12/15/2017");
		SearchExpediaPage.returnDate(driver).sendKeys("");

	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
