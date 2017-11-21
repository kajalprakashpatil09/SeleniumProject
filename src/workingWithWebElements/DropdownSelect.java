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
import org.openqa.selenium.support.ui.Select;

/* 
 * This class opens baseURL in Chrome browser and selects different drop down options under 'Select Class Example'
 * using Selenium. 
 */

public class DropdownSelect {

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
	public void dropdownOptions() throws InterruptedException {

		WebElement dropdownElement = driver.findElement(By.id("carselect"));

		Select dropdownValues = new Select(dropdownElement);
		System.out.println("Select BMW by value");
		dropdownValues.selectByValue("bmw");

		Thread.sleep(2000);
		System.out.println("Select Honda by index");
		dropdownValues.selectByIndex(2);

		Thread.sleep(2000);
		System.out.println("Select Benz by visible text");
		dropdownValues.selectByVisibleText("Benz");

		List<WebElement> options = dropdownValues.getOptions();

		int size = options.size();

		for (int i = 0; i < size; i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
		}

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
