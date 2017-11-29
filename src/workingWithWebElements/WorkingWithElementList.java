package workingWithWebElements;

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
 * This class opens baseURL in Chrome browser and  select different radio buttons if it's not previously selected. 
 */

public class WorkingWithElementList {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {

		baseURL = "https://letskodeit.teachable.com/p/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@Test
	public void elementsList() throws InterruptedException {
		boolean isChecked = false;
		List<WebElement> radioButtons = driver
				.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));

		int countRadiobuttons = radioButtons.size();

		for (int i = 0; i < countRadiobuttons; i++) {
			isChecked = radioButtons.get(i).isSelected();

			if (!isChecked) {
				Thread.sleep(3000);
				radioButtons.get(i).click();

			}

		}

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
