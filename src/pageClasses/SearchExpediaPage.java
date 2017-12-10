package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchExpediaPage {

	public static WebElement element = null;

	public static WebElement sourceTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("flight-origin-hp-flight"));
		return element;

	}

	public static WebElement destinationTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("flight-destination-hp-flight"));
		return element;

	}

	public static WebElement departDate(WebDriver driver) {
		WebElement element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;

	}

	public static WebElement returnDate(WebDriver driver) {
		WebElement element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;

	}

	public static void clickFlights(WebDriver driver) {
		WebElement element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}

}
