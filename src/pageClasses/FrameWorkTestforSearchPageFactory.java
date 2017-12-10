package pageClasses;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageClasses.SearchPageFactory;

/* 
 * This class explains the concept of Page Factory
 */

public class FrameWorkTestforSearchPageFactory {

	WebDriver driver;
	String baseURL;
	SearchPageFactory searchPage;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://www.expedia.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		searchPage = new SearchPageFactory(driver);
		driver.get(baseURL);
	}

	@Test
	public void test() {
		searchPage.clickFlight();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("SFO");

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
