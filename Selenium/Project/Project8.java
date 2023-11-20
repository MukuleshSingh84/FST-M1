package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project8 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.manage().window().maximize();
    }
    @Test
    public void testClass()
    {
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        String UID=driver.findElement(By.xpath("(//span[@class=\"display-name\"])[1]")).getText();
        Assert.assertEquals("root","UID");
    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
