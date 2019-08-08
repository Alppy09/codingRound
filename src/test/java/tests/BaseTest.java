package tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.sun.javafx.PlatformUtil;

import util.SeleniumUtil;

public class BaseTest {

	protected WebDriver driver;
	protected SeleniumUtil selUtil;

	private final int TIME_OUT = 30;

	public BaseTest() {
	}

	@BeforeClass
	public void initialize() {
		System.out.println("In Basetest's initialize method");
		setDriverPath();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
		selUtil = new SeleniumUtil(driver);

	}

	/*
	 *It will set the driver path according to the OS
	 *@return void 
	 */
	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}

	@AfterClass
	public void closeResources() {
		driver.quit();
	}
}
