package com.example.livewebsitetest;

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
import org.openqa.selenium.support.ui.Select;

/*/
* This class opens a URL:http://www.phptravels.net/ in Chrome browser
* and search for hotels as per specified location and check-in check-out dates,
* then select reasonable price hotel and fill the form details required for booking hotel
*/

public class HotelBooking {

	WebDriver driver;
	String baseURL;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {

		baseURL = "http://www.phptravels.net/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kajal\\Desktop\\Job\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);

		String partialTypedText = "Bost";
		String completeHotelText = "Boston, Massachusetts, United States";

		WebElement hotelTextBox = driver.findElement(By.id("citiesInput"));
		hotelTextBox.sendKeys(partialTypedText);
		Thread.sleep(4000);

		WebElement autoPopupCities = driver.findElement(By.xpath(".//div[@class='easy-autocomplete-container']"));
		List<WebElement> listOfCities = autoPopupCities.findElements(By.tagName("li"));

		for (WebElement singleCity : listOfCities) {
			if (singleCity.getText().equals(completeHotelText)) {
				singleCity.click();
				break;
			}
		}

		WebElement checkInTextBox = driver.findElement(By.name("checkin"));
		checkInTextBox.clear();
		checkInTextBox.sendKeys("03/01/2018");

		WebElement checkOutTextBox = driver.findElement(By.name("checkout"));
		checkOutTextBox.clear();
		checkOutTextBox.sendKeys("03/03/2018");

		WebElement searchButton = driver
				.findElement(By.xpath("//div[@id='EXPEDIA']//button[contains(text(),'Search')]"));
		searchButton.click();

		Thread.sleep(6000);

		WebElement hotelSection1 = driver
				.findElement(By.xpath("//div[@id='body-section']//tr[1]//button[contains(text(),'Details')]"));
		hotelSection1.click();

		js.executeScript("window.scrollBy(0,500)");

		WebElement bookHotel = driver
				.findElement(By.xpath("//section[@id='ROOMS']/form[1]//div[3]//span[contains(text(),'Book')]"));
		bookHotel.click();

		Thread.sleep(2000);
		WebElement bookGuestButton = driver
				.findElement(By.xpath("//div[@id='book204329435']//button[contains(text(),'Book as a Guest')]"));
		bookGuestButton.click();

		WebElement firstNmTxtBox = driver.findElement(By.id("card-holder-firstname"));
		firstNmTxtBox.sendKeys("Alex");

		WebElement lastNmTxtBox = driver.findElement(By.id("card-holder-lastname"));
		lastNmTxtBox.sendKeys("Perrish");

		WebElement emailTextBox = driver.findElement(By.id("card-holder-email"));
		emailTextBox.sendKeys("Alex@gmail.com");

		WebElement phoneTextBox = driver.findElement(By.id("card-holder-phone"));
		phoneTextBox.sendKeys("360-316-8767");

		Select countryDropdown = new Select(driver.findElement(By.id("country")));
		countryDropdown.selectByValue("IN");

		WebElement stateTextBox = driver.findElement(By.id("card-holder-state"));
		stateTextBox.sendKeys("CA");

		WebElement cityTextBox = driver.findElement(By.id("card-holder-city"));
		cityTextBox.sendKeys("San Francisco");

		WebElement zipcodeTextBox = driver.findElement(By.id("card-holder-postalcode"));
		zipcodeTextBox.sendKeys("94567");

		Select cardTypeDropdown = new Select(driver.findElement(By.id("cardtype")));
		cardTypeDropdown.selectByIndex(1);

		WebElement cardNumberTextBox = driver.findElement(By.id("card-number"));
		cardNumberTextBox.sendKeys("1234 2345 2234 3456");

		Select expiryMonthDropdown = new Select(driver.findElement(By.id("expiry-month")));
		expiryMonthDropdown.selectByIndex(2);

		Select expiryYearDropdown = new Select(driver.findElement(By.id("expiry-year")));
		expiryYearDropdown.selectByIndex(2);

		WebElement cardCVVTextBox = driver.findElement(By.id("cvv"));
		cardCVVTextBox.sendKeys("123");

		WebElement agreeCheckbox = driver.findElement(By.id("policy"));
		agreeCheckbox.click();

		WebElement confirmBookingButton = driver.findElement(By.xpath("//button[contains(text(),'CONFIRM')]"));
		confirmBookingButton.click();

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
