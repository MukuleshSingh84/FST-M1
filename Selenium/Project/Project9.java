package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project9 {
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
        driver.findElement(By.xpath("//div[@class=\"wp-menu-name\"][contains(text(),'Job Listings')]")).click();
        driver.findElement(By.xpath("//a[@class=\"page-title-action\"][contains(text(),'Add New')]")).click();
        driver.findElement(By.id("toolbar-231cac1e-2a8a-4461-bbc8-3aa13484f912")).click();
        driver.findElement(By.xpath("//div[@id=\"editor-231cac1e-2a8a-4461-bbc8-3aa13484f912\"]//p")).click();
        driver.findElement(By.xpath("//div[@id=\"editor-231cac1e-2a8a-4461-bbc8-3aa13484f912\"]//p")).sendKeys("Testing");
        driver.findElement(By.id("post-title-0")).click();
        driver.findElement(By.xpath("//button[text()=\"Publish…\"]")).click();
        WebElement publishJob= driver.findElement(By.xpath("(//h3[text()='Testing'])[1]"));
        Assert.assertEquals("Testing",publishJob);
    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
