package actionClass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* 
 * This class explains how to mouse hover on menu and click on sub-items.
 */

public class MouseHoverAction {
	WebDriver driver;
	String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		//baseURL = "https://letskodeit.teachable.com/p/practice";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//driver.get(baseURL);
	}

	@Test
	public void mouseHover() throws InterruptedException {
		js.executeScript("window.location='https://letskodeit.teachable.com/p/practice';");
		Thread.sleep(2000);

		WebElement mousehoverBtn = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);", mousehoverBtn);
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.moveToElement(mousehoverBtn).perform();
		Thread.sleep(3000);

		WebElement topButton=driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		action.moveToElement(topButton).click().perform();

		
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
