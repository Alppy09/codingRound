package tests;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.Hotelpage;

public class HotelBookingTest extends BaseTest {

	private Homepage homepage;
	private Hotelpage hotelpage;
	
	private final String TEST_URL = "https://www.cleartrip.com/";

	@Test
	public void shouldBeAbleToSearchForHotels() {
		
		homepage = new Homepage(driver);
		hotelpage = new Hotelpage(driver);

		driver.get(TEST_URL);
		homepage.clickHotelLink();
		hotelpage.searchHotel();

	}

}
