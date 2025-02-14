package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest {
	
	private final String TEST_URL = "https://www.cleartrip.com/";
	private final String ONE_WAY = "OneWay";
	private final String FROM_TAG = "FromTag";
	private final String TO_TAG = "ToTag";
	private final String CITY_BANGALORE = "Bangalore";
	private final String CITY_DELHI = "Delhi";
	private final String UI_ID_1 = "ui-id-1";
	private final String UI_ID_2 = "ui-id-2";
	private final String SEARCH_BUTTON = "SearchBtn";
	private final String SEARCH_SUMMARY = "searchSummary";
	private final String DESTINATION_XPATH = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a";

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		driver.get(TEST_URL);
		waitFor(2000);
		selUtil.findById(ONE_WAY).click();

		selUtil.findById(FROM_TAG).clear();
		selUtil.findById(FROM_TAG).sendKeys(CITY_BANGALORE);

		waitFor(2000);
		List<WebElement> originOptions = selUtil.findById(UI_ID_1).findElements(By.tagName("li"));
		originOptions.get(0).click();

		selUtil.findById(TO_TAG).clear();
		selUtil.findById(TO_TAG).sendKeys(CITY_DELHI);


		waitFor(2000);
		List<WebElement> destinationOptions = driver.findElement(By.id(UI_ID_2)).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		selUtil.findByXpath(DESTINATION_XPATH).click();

		selUtil.findById(SEARCH_BUTTON).click();

		waitFor(5000);
		Assert.assertTrue(isElementPresent(By.className(SEARCH_SUMMARY)));

	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
