package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        //Firefox driver setup
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.chromedriver().setup();
        //driver=new ChromeDriver();
        driver=new FirefoxDriver();
        //Fetch URL
        driver.get("https://alchemy.hguy.co/jobs");
        driver.manage().window().maximize();
    }
    @Test
    public void secondHeading()
    {
        String strScndHeading=driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Quia quis non",strScndHeading);
        System.out.println(strScndHeading);
    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
