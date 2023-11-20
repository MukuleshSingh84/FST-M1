package Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project2 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {

        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
        driver.manage().window().maximize();
    }
    @Test
    public void titleValidate()
    {
        String strTitle=driver.findElement(By.xpath("//h1[text()='Welcome to Alchemy Jobs']")).getText();
        Assert.assertEquals("Welcome to Alchemy Jobs", strTitle);
    }
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.quit();
    }
}
