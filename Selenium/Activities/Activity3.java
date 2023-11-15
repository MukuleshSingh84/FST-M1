package Activity;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity3 {
    public static void main(String[]args)
    {

        WebDriver driver=new FirefoxDriver();
        //Activity 1 using xpath
        driver.get("https://v1.training-support.net");
        System.out.println("Title of 1st Activity: "+driver.getTitle());
        driver.findElement(By.xpath("//a[@id=\"about-link\"]")).getText();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id=\"about-link\"]")));
        System.out.println("Element Name: "+driver.findElement(By.xpath("//a[@id=\"about-link\"]")).getText());
        driver.findElement(By.xpath("//a[@id=\"about-link\"]")).click();
        //Activity 2 using xpath
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Title of 2nd Activity: "+driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"username\"]")));
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"action-confirmation\"]")));
        // Print the confirmation message
        String message = driver.findElement(By.xpath("//div[@id=\"action-confirmation\"]")).getText();
        System.out.println("Login message: " + message);

        // Close the browser
        driver.close();
    }
}
