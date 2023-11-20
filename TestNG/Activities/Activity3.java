package Activity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        // Set up the Firefox driver
        //WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
        driver.manage().window().maximize();
    }
    @Test
    public void imgValidation()
    {
        String strPageSrc=driver.findElement(By.xpath("//div[@class=\"post-thumb-img-content post-thumb\"]/img")).getAttribute("src");
        System.out.println(strPageSrc);
    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }

}
