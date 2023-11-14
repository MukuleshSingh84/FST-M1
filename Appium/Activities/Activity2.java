package Activity;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class Activity2 {
    AndroidDriver driver;
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    // Test method
    @Test
    public void multiplyTest() {
        driver.get("https://www.training-support.net/");
        // Perform the calculation
        String pageTitle=driver.findElement(AppiumBy.xpath("//*[text()='Training Support']")).getText();
        System.out.println("Heading: " + pageTitle);
        // Assertion
        Assert.assertEquals("Training Support",pageTitle);
    }
    // Tear down method
    @AfterClass
    public void tearDown() {
       //driver.quit();
    }
}
