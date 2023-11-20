package Activity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        //Firefox driver setup
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        //Fetch URL
        driver.get("https://alchemy.hguy.co/jobs");
        driver.manage().window().maximize();
    }
    @Test
    public void secondHeading() throws InterruptedException {
        driver.findElement(By.id("menu-item-26")).click();
        String pgTitle=driver.findElement(By.className("entry-title")).getText();
        System.out.println(pgTitle);
        Assert.assertEquals("Post a Job",pgTitle);
        driver.findElement(By.id("create_account_email")).sendKeys("me5@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("Testing");
        driver.findElement(By.id("job_description_ifr")).sendKeys("Testing");
        driver.findElement(By.id("application")).sendKeys("https://google.com");
        driver.findElement(By.id("company_name")).sendKeys("IBM");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@value='Save Draft']")).click();
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@value='Edit listing']")).getText();
        driver.findElement(By.id("job_preview_submit_button")).click();
        driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("Testing");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        WebElement fstJob= driver.findElement(By.xpath("(//h3[text()='Testing'])[1]"));
        Assert.assertEquals("Testing",fstJob);

    }
    @AfterClass
    public void afterClass()
    {
        //driver.quit();
    }
}
