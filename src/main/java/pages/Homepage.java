package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage {
	
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

	public Homepage(WebDriver driver) {
		
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void clickHotelLink() {
		hotelLink.click();
	}

}
