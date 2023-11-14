package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Project2 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException
    {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);
    }
    @Test
    public void googleTasks()
    {
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("new_note_button")));
        driver.findElement(By.id("new_note_button")).click();
        driver.findElement(By.id("editable_title")).sendKeys("FST Class For Google Keep");
        driver.findElement(By.id("edit_note_text")).sendKeys("Google Keep FST class reminder");
        driver.findElement(By.id("menu_reminder")).click();
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.TextView")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("date_spinner")));
        driver.findElement(By.id("date_spinner")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("reminder_date_tomorrow")));
        driver.findElement(By.id("reminder_date_tomorrow")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("time_spinner")));
        driver.findElement(By.id("time_spinner")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("reminder_time_afternoon")));
        driver.findElement(By.id("reminder_time_afternoon")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        driver.findElement(By.xpath("(//*[@content-desc=\"FST Class For Google Keep. Google Keep FST class reminder. \"])[1]")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("editable_title")));
        String task1=driver.findElement(By.id("editable_title")).getText();
        System.out.println("task1"+task1);
        Assert.assertEquals(task1,"FST Class For Google Keep");
    }
    @AfterClass
    public void appClose()
    {
        driver.quit();
    }

}
