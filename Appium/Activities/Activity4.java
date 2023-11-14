package Activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class Activity4{
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException
    {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.setAppPackage("com.google.android.dialer");
        URL serverURL=new URL("https://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);
    }
    @Test
    public void testContact()
    {
        driver.findElement(By.id("contacts_tab")).click();
        driver.findElement(By.id("empty_list_view_action")).click();
        driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]")).sendKeys("Mukulesh");
        driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[2]")).sendKeys("Singh");
        driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout'])[1]")).sendKeys("999148292");
        driver.findElement(By.id("editor_menu_save_button")).click();
        String Name=driver.findElement(By.id("large_title")).getText();
        String Contact=driver.findElement(By.id("large_title")).getText();
        Assert.assertEquals(Name,"Mukulesh Singh");
    }
}
