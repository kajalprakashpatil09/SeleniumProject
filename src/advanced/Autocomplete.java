package advanced;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This class explains auto-suggestion feature using Selenium test
 * 
 */
public class Autocomplete {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://www.southwest.com/flight/?clk=GSUBNAV-AIR-BOOK";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {

		driver.get(baseURL);

		String partialText = "York";
		String searchingText = "Rochester, NY - ROC";

		driver.findElement(By.id("originAirport_displayed")).sendKeys(partialText);
		Thread.sleep(3000);

		WebElement element = driver.findElement(By.xpath("//div[@class='ac_results']"));
		List<WebElement> results = element.findElements(By.tagName("li"));

		for (WebElement result : results) {
			if (result.getText().equals(searchingText)) {
				result.click();
				System.out.println("Selected option from autosuggetion list");
			}
		}

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
