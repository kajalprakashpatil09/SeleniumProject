package workingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * This class opens a URL in Chrome browser and gets webpage title, webpage URL and 
 * performs different navigations on webpage like forward,back,refresh
 */

public class NavigateBetweenPages {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://letskodeit.teachable.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void navigateBetweenPages() {
		driver.get(baseURL);

		String title = driver.getTitle();
		System.out.println("Title of Welcome webpage : " + title);

		String currentURL = driver.getCurrentUrl();
		System.out.println("URL of current webpage : " + currentURL);

		String navigateURL = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";

		driver.navigate().to(navigateURL);
		System.out.println("Navigated to Login webpage");

		currentURL = driver.getCurrentUrl();
		System.out.println("URL of Login webpage : " + currentURL);

		driver.navigate().back();
		System.out.println("Navigated back to Welcome page");

		driver.navigate().forward();
		System.out.println("Navigated forward to Login page");

		driver.navigate().back();
		System.out.println("Navigated back to Welcome page");

		driver.navigate().refresh();
		System.out.println("Refreshed current web page");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
