package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtil {

	private WebDriver driver;

	public SeleniumUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void clickByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clickById(String id) {
		driver.findElement(By.id(id)).click();
	}

	public WebElement findByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement findById(String id) {
		return driver.findElement(By.id(id));
	}
	
	public WebElement findByLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	public WebElement findByClass(String className) {
		return driver.findElement(By.className(className));
	}

}
