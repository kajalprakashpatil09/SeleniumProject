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
 * This class explains how to drag and drop a web element on webpage.
 */
public class DragandDropAction {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "http://jqueryui.com/droppable/";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void mouseHover() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(2000);

		driver.switchTo().frame(0);

		WebElement fromElement = driver.findElement(By.id("draggable"));
		WebElement toElement = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		action.dragAndDrop(fromElement, toElement).build().perform();
		Thread.sleep(2000);

	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
