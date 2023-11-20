package Activity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
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
    public void secondHeading()
    {
        String strMenu=driver.findElement(By.id("menu-item-24")).getText();
        Assert.assertEquals("Jobs",strMenu);
        System.out.println(strMenu);
        driver.findElement(By.id("menu-item-24")).click();
        String pgTitle=driver.getTitle();
        Assert.assertEquals("Jobs – Alchemy Jobs",pgTitle);
        System.out.println(pgTitle);
    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
