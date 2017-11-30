package actionClass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* 
 * This class explains Slider action on web page using Actions class.
 */
public class SliderAction {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "http://jqueryui.com/slider/";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void sliderAction() throws InterruptedException {

		driver.get(baseURL);
		driver.switchTo().frame(0);
		Thread.sleep(2000);

		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']//span"));

		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(2000);

	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
