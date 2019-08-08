package tests;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

	private final String TEST_URL = "https://www.cleartrip.com/";
	private final String YOUR_TRIPS = "Your trips";
	private final String SIGN_IN = "SignIn";
	private final String SIGN_IN_BUTTON = "signInButton";
	private final String ERRORS_1 = "errors1";
	private final String SUBMISSION_ERROR_MESSAGE = "There were errors in your submission";
	
	
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        driver.get(TEST_URL);
        waitFor(2000);

        selUtil.findByLinkText(YOUR_TRIPS).click();
        selUtil.findById(SIGN_IN).click();
        
        selUtil.findById(SIGN_IN_BUTTON).click();

        String errors1 = selUtil.findById(ERRORS_1).getText();
        Assert.assertTrue(errors1.contains(SUBMISSION_ERROR_MESSAGE));
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
