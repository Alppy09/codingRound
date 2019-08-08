package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Hotelpage {

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	public Hotelpage(WebDriver driver) {
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchHotel() {
		localityTextBox.sendKeys("Bangalore");
		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();
	}

}
