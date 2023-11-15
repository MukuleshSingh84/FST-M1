package Activity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity21 {
    public static void main(String[]args)
    {
         WebDriver driver=new FirefoxDriver();
         WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
         driver.get("https://v1.training-support.net/selenium/tab-opener");
         System.out.println("Page Title: "+driver.getTitle());
         System.out.println("Current Tab: "+driver.getWindowHandle());
         driver.findElement(By.id("launcher")).click();
         wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String handle:driver.getWindowHandles())
        {
            driver.switchTo().window(handle);

        }
         System.out.println("Current Tab: "+driver.getWindowHandles());
         System.out.println("Next Tab: "+driver.getWindowHandle());
         wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
         System.out.println("Page Title: "+driver.getTitle());
         driver.findElement(By.id("actionButton")).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
         System.out.println("All Tab: "+driver.getWindowHandles());
         System.out.println("Current Tab: "+driver.getWindowHandle());
         System.out.println("Page Title: "+driver.findElement(By.xpath("//div[@class='sub header']")).getText());
         driver.quit();
    }
}
