package Project;

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

public class Project1 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException
    {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);
    }
    @Test
    public void googleTasks()
    {
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("welcome_get_started")));
        driver.findElement(By.id("welcome_get_started")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tasks_fab")));
        driver.findElement(By.id("tasks_fab")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_task_title")));
        driver.findElement(By.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(By.id("add_task_done")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tasks_fab")));
        driver.findElement(By.id("tasks_fab")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_task_title")));
        driver.findElement(By.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(By.id("add_task_done")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tasks_fab")));
        driver.findElement(By.id("tasks_fab")).click();
        wait =new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_task_title")));
        driver.findElement(By.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(By.id("add_task_done")).click();
        String task1=driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[4]")).getText();
        String task2=driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[5]")).getText();
        String task3=driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[6]")).getText();
        System.out.println("task1"+task1);
        System.out.println("task2"+task2);
        System.out.println("task3"+task3);
        Assert.assertEquals(task3,"Complete Activity with Google Tasks");
        Assert.assertEquals(task2,"Complete Activity with Google Keep");
        //Assert.assertEquals(task1,"Complete the second Activity Google Keep");
    }
    @AfterClass
    public void appClose()
    {
        driver.quit();
    }

}
