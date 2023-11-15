package Activity;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity2 {
    public static void main(String[]args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver D=new FirefoxDriver();
        D.get("https://v1.training-support.net/selenium/login-form");
        String Str=D.getTitle();
        System.out.println(Str);
        D.findElement(By.id("username")).sendKeys("admin");
        D.findElement(By.id("password")).sendKeys("password");
        //D.findElement(By.name("Log in")).click();
        //D.findElement(By.xpath("//button[text()='Log in']")).click();
        D.findElement(By.xpath("//*[@type='submit']")).click();

        // Print the confirmation message
        String message = D.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);
        D.quit();
    }
}
