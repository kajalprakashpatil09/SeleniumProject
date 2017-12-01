package advanced;

import java.util.List;
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
 * This class explains how to select date in Calendar
 */

public class CalendarSelectionRealTime {
	WebDriver driver;
	String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		baseURL = "https://www.expedia.com/";

		js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {

		driver.get(baseURL);

		driver.findElement(By.id("tab-flight-tab-hp")).click();
		System.out.println("Clicked on Flights tab");

		driver.findElement(By.id("flight-departing-hp-flight")).click();
		System.out.println("Clicked on Departing Date field");
		Thread.sleep(3000);

		WebElement calMonth = driver.findElement(By.xpath(".//div[@class='datepicker-cal-month'][position()=1]"));

		js.executeScript("arguments[0].scrollIntoView(true);", calMonth);

		List<WebElement> allValidDates = calMonth.findElements(By.tagName("button"));

		for (WebElement date : allValidDates) {
			if (date.getText().equals("30")) {
				date.click();
				break;
			}
		}

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
