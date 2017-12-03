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
* This class explains how to get the value of atrribute of different web element.
*/
public class GetValueOfAttribute {

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
	public void getText() throws Exception {
		driver.get(baseURL);
		
		WebElement textBox=driver.findElement(By.id("name"));
		String attributeValue=textBox.getAttribute("class");
				System.out.println("Value of Class attribute of textbox 'Enter your Name' is: " + attributeValue);
				
		String attributeType=textBox.getAttribute("type");
		System.out.println("Value of Type attribute of textbox 'Enter your Name' is: "+ attributeType);
		
	}
	

	@After
	
	public void tearDown() throws Exception {
	Thread.sleep(2000);
	driver.quit();
	}

	
}
