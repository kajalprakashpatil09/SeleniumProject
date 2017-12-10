package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* 
 * This class explains the concept of Page Factory
 */
public class SearchPageFactory {

	WebDriver driver;

	@FindBy(id = "tab-flight-tab-hp")
	WebElement flightTab;

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	WebElement originCity;

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	WebElement destinationCity;

	@FindBy(id = "flight-departing-hp-flight")
	WebElement departingDate;

	@FindBy(id = "flight-returning-hp-flight")
	WebElement returnDate;

	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickFlight() {
		flightTab.click();
	}

	public void setOriginCity(String origin) {
		originCity.click();
		originCity.sendKeys(origin);
	}

	public void setDestinationCity(String destination) {
		destinationCity.click();
		destinationCity.sendKeys(destination);
	}

}
