package workingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
* This class explains how to get the text of web element.
*/
public class GetTextofElement {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://letskodeit.teachable.com/p/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test() {
		driver.get(baseURL);

		System.out.println("Find text of web element 'Open Tab'");
		WebElement buttonOpenTab = driver.findElement(By.id("opentab"));
		String elementText = buttonOpenTab.getText();
		System.out.println("Text on the element is: " + elementText);

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();

	}

}
