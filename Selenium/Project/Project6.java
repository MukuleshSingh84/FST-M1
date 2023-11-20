package Project;

import com.sun.jna.Structure;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Project6 {
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
        driver.findElement(By.id("menu-item-24")).click();
        String pgTitle=driver.getTitle();
        System.out.println(pgTitle);
        Assert.assertEquals("Jobs – Alchemy Jobs",pgTitle);
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        WebElement SearchJobs= driver.findElement(By.xpath("//input[@value='Search Jobs']"));
        SearchJobs.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement fstJob= driver.findElement(By.xpath("(//h3[text()='Banking'])[1]"));
        fstJob.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement applyJob = driver.findElement(By.xpath("*//input[@value='Apply for job']"));
        applyJob.click();
        WebElement emailId = driver.findElement(By.className("job_application_email"));
        System.out.println(emailId.getText());
    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
