package Activity;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity15 {
    public static void main(String[]args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        String str= driver.getTitle();
        System.out.println(str);
        //WebElement username = driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]"));
        //WebElement password = driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]"));
        // Enter the credentials
        //username.sendKeys("admin");
        //password.sendKeys("password");
        driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]")).sendKeys("password");
        // Find and click the submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Print the login message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);

        // Close the browser
        driver.quit();
    }
}
